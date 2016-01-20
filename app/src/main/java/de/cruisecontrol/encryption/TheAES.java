package de.cruisecontrol.encryption;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import de.cruisecontrol.exceptions.UnableToEncryptException;

/**
 * Created by Moik on 09.10.2015.
 */
public class TheAES {
    private Cipher cipher = null;

    // Private Constructor
    public TheAES() {
    }

    public String encrypt(String plainText, String key) throws UnableToEncryptException {
        SecretKeySpec spec = hashThatKey(key);
        // Encrypt
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, spec);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            // bytes zu Base64-String konvertieren (dient der Lesbarkeit)
            byte[] cypherText = Base64.encode(encrypted, Base64.DEFAULT);
            // Return encrypted text
            return new String(cypherText, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            throw new UnableToEncryptException(e);
        } catch (NoSuchPaddingException e) {
            throw new UnableToEncryptException(e);
        } catch (IllegalBlockSizeException e) {
            throw new UnableToEncryptException(e);
        } catch (BadPaddingException e) {
            throw new UnableToEncryptException(e);
        } catch (InvalidKeyException e) {
            throw new UnableToEncryptException(e);
        } catch (UnsupportedEncodingException e) {
            throw new UnableToEncryptException(e);
        }
    }

    public String decrypt(String cypherText, String key) throws UnableToEncryptException {
        SecretKeySpec spec = hashThatKey(key);
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, spec);
            byte[] bytes = Base64.decode(cypherText, Base64.DEFAULT);
            byte[] decrypted = cipher.doFinal(bytes);
            return new String(decrypted, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            throw new UnableToEncryptException(e);
        } catch (NoSuchPaddingException e) {
            throw new UnableToEncryptException(e);
        } catch (IllegalBlockSizeException e) {
            throw new UnableToEncryptException(e);
        } catch (BadPaddingException e) {
            throw new UnableToEncryptException(e);
        } catch (InvalidKeyException e) {
            throw new UnableToEncryptException(e);
        } catch (UnsupportedEncodingException e) {
            throw new UnableToEncryptException(e);
        }
    }

    /**
     * Generates a hash value of the key
     *
     * @param key
     * @return
     */
    private SecretKeySpec hashThatKey(String key) throws UnableToEncryptException {
        try {
            byte[] keyArray = (key).getBytes("UTF-8");
            // Create hash value
            MessageDigest sha = MessageDigest.getInstance("MD5");
            keyArray = sha.digest(keyArray);
            // Use only first 128 bit
            keyArray = Arrays.copyOf(keyArray, 16);
            // Ecryption key
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyArray, "AES");
            return secretKeySpec;
        } catch (NoSuchAlgorithmException e) {
            UnableToEncryptException ex = new UnableToEncryptException(e);
            throw ex;
        } catch (UnsupportedEncodingException e) {
            UnableToEncryptException ex = new UnableToEncryptException(e);
            throw ex;
        }
    }
}
