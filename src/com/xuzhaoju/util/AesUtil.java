package com.xuzhaoju.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * aes
 *
 * @author zl
 */
public class AesUtil {
    final static Logger logger  = LoggerFactory.getLogger(AesUtil.class);
    private static String KEY;
    private static String IV;


    private static final String CACHE_KEY = "CONFIG_ENCRYPT";

    /**
     * 算法名称
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    private AesUtil() {
    }

    static {
        KEY = "WLZX27A621562DED";
        IV = KEY;
    }


    public static String encrypt(String data) {
        if (EmptyUtils.isEmpty(data)) {
            return null;
        }
        try {
            return encrypt(data, KEY, IV);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptHex(String data) {
        if (EmptyUtils.isEmpty(data)) {
            return null;
        }
        try {
            return encryptHex(data, KEY, IV);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String decrypt(String data) {
        if (EmptyUtils.isEmpty(data)){
            return null;
        }
        try {
            return decode(data, KEY, IV);
        } catch (Exception e) {
            logger.error("解密失败decrypt->"+data);
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptHex(String data) {
        if (EmptyUtils.isEmpty(data)) {
            return null;
        }
        try {
            return decodeHex(data, KEY, IV);
        } catch (Exception e) {
            logger.error("解密失败decryptHex->"+data);
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptHex(String data, String key, String iv) throws Exception {
        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //密码key(超过16字节即128bit的key，需要替换jre中的local_policy.jar和US_export_policy.jar，否则报错：Illegal key size)
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), KEY_ALGORITHM);
            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            //初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            //加密
            byte[] result = cipher.doFinal(data.getBytes());
            return Hex.encodeHexString(result);
        } catch (Exception var11) {
            throw new Exception("加密失败", var11);
        }
    }


    public static String encrypt(String data, String key, String iv) throws Exception {
        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //密码key(超过16字节即128bit的key，需要替换jre中的local_policy.jar和US_export_policy.jar，否则报错：Illegal key size)
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), KEY_ALGORITHM);
            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            //初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            //加密
            byte[] result = cipher.doFinal(data.getBytes());
            return new Base64().encodeToString(result);
        } catch (Exception var11) {
            throw new Exception("加密失败", var11);
        }
    }

    public static String decodeHex(String data, String key, String iv) {
        try {
            //密文使用Hex解码
            byte[] content = Hex.decodeHex(data.toCharArray());
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //密码key
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), KEY_ALGORITHM);
            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            //初始化为解密模式的密码器
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            //执行操作
            byte[] result = cipher.doFinal(content);
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decode(String data, String key, String iv) throws Exception {
        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //密码key
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), KEY_ALGORITHM);
            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            //初始化为解密模式的密码器
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            //执行操作
            byte[] result = cipher.doFinal(new Base64().decode(data));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception var9) {
            throw new Exception("解密失败", var9);
        }
    }

//    public static void main(String[] args) {
//
//    }
}

