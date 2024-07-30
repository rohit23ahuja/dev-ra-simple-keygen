package dev.ra.simple.keygen;

import javax.crypto.SecretKey;


public class SimpleKeyGenerator
{

    public static void main( String[] args )  {
        KeyGenerator keyGenerator = new KeyGenerator();
        SecretKey secretKey = keyGenerator.createKey(args[0], Integer.parseInt(args[1]));
        KeyRepository keyRepository = new KeyRepository();
        keyRepository.saveKey(secretKey, args[2]);
    }

}
