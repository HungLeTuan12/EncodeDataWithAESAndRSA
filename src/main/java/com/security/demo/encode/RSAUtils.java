package com.security.demo.encode;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAUtils {
    /**
     * Mã hóa bằng public key
     * @param data
     * @param publicKey: khóa để mã hóa
     * @throws Exception: NoSuchAlgorithmException, NoSuchPaddingException(=), InvalidKeyException
     */
    public static String encryptWithPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(RSAKeyHolder.RSA);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptBytes = cipher.doFinal(data);
            return Base64.getEncoder().encodeToString(encryptBytes);
        }
        catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("Thuat toan khong phu hop !");
        }
        catch (NoSuchPaddingException e) {
            throw new NoSuchPaddingException("Sai cau hinh padding !");
        }
        catch (InvalidKeyException e) {
            throw new InvalidKeyException("Key khong hop le !");
        }
    }

    /**
     * Giai mã ằng private key
     * @param encryptedData: dữ liệu đã được mã hóa Base 64
     * @param privateKey: khóa để giải mã
     * @throws Exception: NoSuchAlgorithmException, NoSuchPaddingException(=), InvalidKeyException
     */
    public static byte[] decryptWithPrivateKey(String encryptedData, PrivateKey privateKey) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(RSAKeyHolder.RSA);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        }
        catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("Thuat toan khong phu hop !");
        }
        catch (NoSuchPaddingException e) {
            throw new NoSuchPaddingException("Sai cau hinh padding !");
        }
        catch (InvalidKeyException e) {
            throw new InvalidKeyException("Key khong hop le !");
        }
    }
}
