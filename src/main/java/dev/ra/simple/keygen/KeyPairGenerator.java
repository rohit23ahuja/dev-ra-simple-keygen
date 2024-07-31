package dev.ra.simple.keygen;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class KeyPairGenerator {
    public KeyPair createKeyPair(final String algorithm, int keySize){
        try {
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(algorithm);
            keyPairGenerator.initialize(keySize);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
