package Chinese_Flower.Encryption;

public class EncryptionImpl implements Encryption {

    @Override
    public String encryption(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = s1 + (char) (s.charAt(i) + 7*i);//加密
        }
        return s1;
    }
    @Override
    public String decryption(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = s1 + (char) (s.charAt(i) - 7*i);//解密
        }
        return s1;
    }
    
}
