package bsr.front.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Asia on 31.12.2016.
 */

/**
 * Abstract class with method to generate hashed password to be send to server
 */
public abstract class HashUtils {
    /**
     * Method used to hash password to be send to server
     * @param password plain text password
     * @return password hashed using MD5
     */
    public static String hashPassword(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword;
    }
}
