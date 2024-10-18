package dev.ra.simple.keygen;

import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CipherAlgos {
    DiffieHellman_1024("asymmetric"),
    DiffieHellman_2048("asymmetric"),
    DiffieHellman_4096("asymmetric"),
    DSA_1024("asymmetric"),
    DSA_2048("asymmetric"),
    RSA_1024("asymmetric"),
    RSA_2048("asymmetric"),
    RSA_4096("asymmetric"),
    AES_128("symmetric"),
    AES_192("symmetric"),
    AES_256("symmetric"),
    DESede_168("symmetric"),
    HmacSHA1("symmetric"),
    HmacSHA256("symmetric");

    private static final Logger _log = LoggerFactory.getLogger(CipherAlgos.class);
    private String type;

    CipherAlgos(String t){
        type = t;
    }

    public String getType(){
        return type;
    }
    public static Pair<Boolean, CipherAlgos> validateAlgorithmParameters(String algo, int keySize) throws SimpleKeyGeneratorException{
        try{
            if (keySize==0)
                return new Pair<Boolean, CipherAlgos>(Boolean.TRUE, CipherAlgos.valueOf(algo));
            else
                return new Pair<Boolean, CipherAlgos>(Boolean.TRUE, CipherAlgos.valueOf(algo+"_"+keySize));
        } catch(Exception e){
            _log.error("Invalid algo or key size passed", e);
            StringBuilder sb = new StringBuilder("Illegal algo or key size passed. Supported algos are (supported key size mentioned after underscore '_' charactoer) :- ");
            int count =0;
            for (CipherAlgos c : CipherAlgos.values()) {
                sb.append(c.toString());
                count++;
                if (count<CipherAlgos.values().length) sb.append(", ");
            }
            String s = sb.toString();
            throw new SimpleKeyGeneratorException(s);
        }
    }

}
