package dev.ra.simple.keygen;

import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class KeyGenerator {

    public SecretKey createKey(final String cipher, int keySize) {
        javax.crypto.KeyGenerator keyGenerator = null;
        try {
            keyGenerator = javax.crypto.KeyGenerator.getInstance(cipher);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyGenerator.init(keySize);
        return keyGenerator.generateKey();
    }
}
