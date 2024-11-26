package com.security.demo.encode;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAKeyHolder {
    public static final String RSA = "RSA";
    // Mã hóa AES bằng RSA public key
    public static PublicKey PUBLIC_KEY;
    // Giải mã khóa AES bằng RSA private key
    public static PrivateKey PRIVATE_KEY;
    public static int KEY_SIZE;

    static {
        try {
            // Tạo cặp khóa RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            // - Độ dài khóa (Key Size): 2048 trở lên
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PUBLIC_KEY = keyPair.getPublic();
            PRIVATE_KEY = keyPair.getPrivate();
        }
        catch (Exception e) {
            throw new RuntimeException("Không thể tạo cặp khóa RSA !!", e);
        }
    }
}
