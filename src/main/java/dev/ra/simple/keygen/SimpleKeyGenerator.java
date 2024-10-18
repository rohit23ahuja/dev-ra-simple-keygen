package dev.ra.simple.keygen;

import io.prometheus.metrics.core.metrics.Histogram;
import io.prometheus.metrics.exporter.pushgateway.PushGateway;
import io.prometheus.metrics.model.snapshots.Unit;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.KeyPair;


public class SimpleKeyGenerator {
    private static final Logger _log = LoggerFactory.getLogger(SimpleKeyGenerator.class);

    public static void main(String[] args) throws SimpleKeyGeneratorException {
        Histogram duration =
                Histogram.builder()
                        .name("method_duration_seconds")
                        .help("method_duration in seconds")
                        .unit(Unit.SECONDS)
                        .labelNames("method", "status")
                        .register();
        long start = System.nanoTime();

        _log.info("Simple key generator. parameters received - {} {} {}", args);
        Pair<Boolean, CipherAlgos> pair = CipherAlgos.validateAlgorithmParameters(args[0], Integer.parseInt(args[1]));
        if (!pair.getValue0()) return;

        if ("asymmetric".equals(pair.getValue1().getType())) {
            KeyPairGenerator keyPairGenerator = new KeyPairGenerator();
            KeyPair keyPair = keyPairGenerator.createKeyPair(args[0], Integer.parseInt(args[1]));
            KeyRepository keyRepository = new KeyRepository();
            keyRepository.saveKeyPair(keyPair, args[2]);
        } else {
            KeyGenerator keyGenerator = new KeyGenerator();
            SecretKey secretKey = keyGenerator.createKey(args[0], Integer.parseInt(args[1]));
            KeyRepository keyRepository = new KeyRepository();
            keyRepository.saveKey(secretKey, args[2]);
        }

        duration.labelValues("main","success").observe(Unit.nanosToSeconds(System.nanoTime()-start));
        try {
            pushGateway.push();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static PushGateway pushGateway = PushGateway.builder()
            .job("simplekeygenjob")
            .build();

}
