package dev.ra.simple.keygen;

import javax.crypto.SecretKey;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Base64;

public class KeyRepository {

    public void saveKey(SecretKey secretKey, String storageLocation) {
        try(FileOutputStream fos = new FileOutputStream(storageLocation.concat("aes.key"))){
            fos.write(secretKey.getEncoded());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void saveKeyPair(KeyPair keyPair, String storageLocation){
        try(FileOutputStream fos = new FileOutputStream(storageLocation.concat("rsa.key"))){
            fos.write(keyPair.getPrivate().getEncoded());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream(storageLocation.concat("rsa_pub.key"))){
            fos.write(keyPair.getPublic().getEncoded());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
