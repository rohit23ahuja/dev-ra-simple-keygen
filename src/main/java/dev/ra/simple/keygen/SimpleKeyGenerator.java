package dev.ra.simple.keygen;

import org.javatuples.Pair;

import javax.crypto.SecretKey;
import java.security.KeyPair;


public class SimpleKeyGenerator {

    public static void main(String[] args) {

        Pair<Boolean, CipherAlgos> pair = CipherAlgos.validValue(args[0], Integer.parseInt(args[1]));
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

    }


}
