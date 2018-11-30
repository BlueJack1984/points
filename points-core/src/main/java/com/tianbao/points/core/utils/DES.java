package com.tianbao.points.core.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.KeySpec;

/**
 * des加密解密工具
 *
 * @author lushusheng 2018-11-30
 */
@Slf4j
public class DES {
    private static final String ALGORITHM = "DES/CBC/PKCS5Padding";
    private static final byte[] IV_DEFAULT = "DIICHDES".getBytes();

    private DES(){}
    /**
     * 加密
     * @param key 加密密钥
     * @param source 加密的内容
     * @param output 加密的结果
     * @return 加密后的长度
     */
    public static int encrypt(byte[] key, byte[] source, byte[] output){
        return encrypt(key, IV_DEFAULT, source, 0, source.length, output, 0);
    }

    /**
     * 加密
     * @param key 密钥
     * @param source 加密的内容
     * @return 加密的结果缓存
     */
    public static byte[] encrypt(byte[] key, byte[] source){
        return encrypt(key, IV_DEFAULT, source, 0, source.length);
    }

    /**
     * 加密
     * @param key 密钥
     * @param iv 密钥补充
     * @param source 加密的内容缓存
     * @param offset 缓存偏移
     * @param length 需要加密的长度，即从offset开始的length内容需要加密
     * @return 加密的结果缓存
     */
    public static byte[] encrypt(byte[] key, byte[] iv, byte[] source, int offset, int length){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            KeySpec keySpec = new DESKeySpec(key);
            SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] output = new byte[cipher.getOutputSize(length)];
            cipher.doFinal(source, offset, length, output, 0);
            return output;
        }catch (Exception e){
            log.error("des加密异常：{}", e.getMessage());
        }
        return new byte[0];
    }

    /**
     * 加密
     * @param key 密钥
     * @param iv 密钥补充
     * @param source 加密的内容缓存
     * @param offset 缓存的偏移
     * @param length 需要加密的长度，即从offset开始的length内容需要进行加密
     * @param output 输出缓存
     * @param offsetOutput 输出缓存的偏移
     * @return 加密后的长度
     */
    public static int encrypt(byte[] key, byte[] iv, byte[] source, int offset, int length,
                              byte[] output, int offsetOutput){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            KeySpec keySpec = new DESKeySpec(key);
            SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
            return cipher.doFinal(source, offset, length, output, offsetOutput);
        }catch (Exception e){
            log.error("des加密异常：{}", e.getMessage());
        }
        return 0;
    }

    /**
     * 解密
     * @param key 解密密钥
     * @param iv 密钥补充
     * @param source 解密的内容缓存
     * @param offset 缓存的偏移
     * @param length 需要解密的长度，即从offset开始length长度的内容需要进行解密
     * @param output 输出缓存
     * @param offsetOutput 输出缓存的偏移
     * @return 解密后的长度
     */
    public static int decrypt(byte[] key, byte[] iv, byte[] source, int offset, int length,
                              byte[] output, int offsetOutput){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            KeySpec keySpec = new DESKeySpec(key);
            SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
            return cipher.doFinal(source, offset, length, output, offsetOutput);
        }catch (Exception e){
            log.error("des加密异常：{}", e.getMessage());
        }
        return 0;
    }

    /**
     * 解密
     * @param key 密钥
     * @param iv 补充密钥
     * @param source 解密的内容
     * @param offset 缓存的偏移
     * @param length 解密的长度，即从offset开始的length长度的内容都需要解密
     * @return 解密的结果
     */
    public static byte[] decrypt(byte[] key, byte[] iv, byte[] source, int offset, int length){
        byte[] output = new byte[length];
        if (decrypt(key, iv, source, offset, length, output, 0) == 0){
            return new byte[0];
        }
        return output;
    }

    /**
     * 解密
     * @param key 密钥
     * @param source 解密的内容
     * @return 解密的结果
     */
    public static byte[] decrypt(byte[] key, byte[] source){
        return decrypt(key, IV_DEFAULT, source, 0, source.length);
    }

    /**
     * 解密
     * @param key 解密密钥
     * @param source 解密的内容
     * @param output 解密的结果
     * @return 解密结果的长度
     */
    public static int decrypt(byte[] key, byte[] source, byte[] output){
        return decrypt(key, IV_DEFAULT, source, 0, source.length, output, 0);
    }
}
