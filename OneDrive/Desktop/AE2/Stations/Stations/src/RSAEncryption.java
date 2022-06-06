import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class RSAEncryption {
    public static void main(String[] args) throws Exception {
    
    	 String text = "Hello";
         String key = UtlityService.generateKey(); // 128 bit key
         // Create key and cipher
         Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        
         Cipher cipher = Cipher.getInstance("AES");
         // encrypt the text
         cipher.init(Cipher.ENCRYPT_MODE, aesKey);
         byte[] encrypted = cipher.doFinal(text.getBytes());
         System.err.println(new String(encrypted));
         String encypted=encrypted.toString();
         System.err.println(encypted);
         
         
         cipher.init(Cipher.DECRYPT_MODE, aesKey);
         String decrypted = new String(cipher.doFinal(encrypted));
         System.err.println(decrypted);
         
         
         
    }
}
