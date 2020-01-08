package doraemon.util;

import static javax.crypto.Cipher.DECRYPT_MODE;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public enum EncryptUtils {

  /**
   * SINGLETON
   */
  SINGLETON;

  // todo 关于秘钥长度的问题.
  private static final String SECRET = "=oraemon_0201111doraemon,0.01111";
  private static final String CHARSET = "UTF-8";

  public String sha(String raw) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    messageDigest.update(raw.getBytes(CHARSET));
    return Hex.encodeHexString(messageDigest.digest());
  }

  private Cipher createAesCipher() throws Exception {
    return Cipher.getInstance("AES");
  }

  /**
   * 加密
   */
  public String encryptByAes(String raw) throws Exception {
    Cipher aesCipher = createAesCipher();
/*
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128, new SecureRandom(SECRET.getBytes(CHARSET)));
    SecretKey secretKey = keyGenerator.generateKey();
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
*/

    byte[] enCodeFormat = SECRET.getBytes(CHARSET);
    SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");

    aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
    byte[] bytes = aesCipher.doFinal(raw.getBytes(CHARSET));
    return Hex.encodeHexString(bytes);
  }

  /**
   * 解密
   */
  public String decryptByAes(String raw) throws Exception {
    byte[] bytes = Hex.decodeHex(raw);
    Cipher aesCipher = createAesCipher();
/*    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128, new SecureRandom(SECRET.getBytes(CHARSET)));
    SecretKey secretKey = keyGenerator.generateKey();*/
    SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET.getBytes(CHARSET), "AES");
    aesCipher.init(DECRYPT_MODE, secretKeySpec);
    return new String(aesCipher.doFinal(bytes), CHARSET);
  }
}