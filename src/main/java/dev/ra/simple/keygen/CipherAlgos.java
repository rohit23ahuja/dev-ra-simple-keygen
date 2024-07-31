package dev.ra.simple.keygen;

import org.javatuples.Pair;

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

    private String type;

    CipherAlgos(String t){
        type = t;
    }

    public String getType(){
        return type;
    }
    public static Pair<Boolean, CipherAlgos> validValue(String algo, int keySize){
        try{
            if (keySize==0)
                return new Pair<Boolean, CipherAlgos>(Boolean.TRUE, CipherAlgos.valueOf(algo));
            else
                return new Pair<Boolean, CipherAlgos>(Boolean.TRUE, CipherAlgos.valueOf(algo+"_"+keySize));
        } catch(Exception e){
            System.err.println("Illegal algo or key size passed. Supported algos are below(key size mentioned after underscore(_) charactoer) :- ");
            for (CipherAlgos c : CipherAlgos.values()) {
                System.err.println(c);
            }
            return new Pair<Boolean, CipherAlgos>(Boolean.FALSE, null);
        }
    }

}
