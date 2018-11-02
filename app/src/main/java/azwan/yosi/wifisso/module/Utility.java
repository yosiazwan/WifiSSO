package azwan.yosi.wifisso.module;

import java.security.MessageDigest;

public final class Utility {

    /**
     * Convert array byte to Hex String
     *
     * @see <a href="https://stackoverflow.com/questions/19053470/android-md5-issue-calculating-md5-missing-characters">StackOverflow</a>
     * @param data byte[]
     * @return String
     */
    public static String byteToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            int halfOfByte = (data[i] >>> 4) & 0x0F;
            int twoHalfBytes = 0;

            do {
                if ((0 <= halfOfByte) && (halfOfByte <= 9)) {
                    buf.append((char) ('0' + halfOfByte));
                } else {
                    buf.append((char) ('a' + (halfOfByte - 10)));
                }

                halfOfByte = data[i] & 0x0F;

            } while (twoHalfBytes++ < 1);
        }
        return buf.toString();
    }

    /**
     * Calculate the md5 hash of a string
     *
     * @see <a href="https://stackoverflow.com/questions/19053470/android-md5-issue-calculating-md5-missing-characters">StackOverflow</a>
     * @param str String
     * @return String
     */
    public static String MD5(String str){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Byte = new byte[64];
            md.update(str.getBytes("iso-8859-1"), 0, str.length());
            md5Byte = md.digest();
            return byteToHex(md5Byte);
        }catch (Exception e){
            //Error here
        }
        return "";
    }

}
