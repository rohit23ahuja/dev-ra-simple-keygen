package dev.ra.simple.keygen;

import javax.crypto.SecretKey;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class KeyRepository {

    public void saveKey(SecretKey secretKey, String storageLocation) {
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        try(FileOutputStream fos = new FileOutputStream(storageLocation)){
            fos.write(encodedKey.getBytes());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
