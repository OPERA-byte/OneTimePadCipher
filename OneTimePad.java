import java.util.Random;
import java.util.ArrayList;

/**
 * A class that implements a simple one-time pad encryption and decryption mechanism.
 * The key for encryption and decryption is represented as an ArrayList of random integers.
 * The class provides methods to generate a new key, retrieve the current key,
 * encrypt plaintext, and decrypt ciphertext using XOR-based methods.
 */
public class OneTimePad {
    private static ArrayList<Integer> key;

    /**
     * Generates a new key for encryption or decryption.
     * The key is represented as an ArrayList of random integers.
     * Each integer is in the range between 65 and 122 (inclusive), which generally
     * covers ASCII values for upper and lower case letters and some special characters.
     *
     * @param plainTextSize The size of the key to generate, which should match the size of the plaintext.
     */
    public void newKey(int plainTextSize) {
        Random rand = new Random();
        key = new ArrayList<>();

        for(int i = 0; i < plainTextSize; i++) {
            key.add(rand.nextInt(65,122));
        }
    }

    /**
     * Retrieves the current key.
     *
     * @return An ArrayList of Integer values representing the current key.
     */
    public ArrayList<Integer> getKey() {
        return key;
    }

    /**
     * Encrypts the given plaintext using a simple XOR-based encryption method.
     * A new key is generated based on the length of the plaintext, and each character
     * of the plaintext is XORed with the corresponding element from the key to produce
     * the ciphertext.
     *
     * @param plainText The plaintext string to be encrypted.
     * @return The encrypted ciphertext as a string.
     */
    public String encrypt(String plainText) {
        String cipherText = "";
        newKey(plainText.length());

        for(int i = 0; i < plainText.length(); i++) {
            cipherText += (char)((int)plainText.charAt(i) ^ key.get(i));
        }
        return cipherText;
    }

    /**
     * Decrypts the given ciphertext using a simple XOR-based decryption method.
     * Each character of the ciphertext is XORed with the corresponding element
     * from the key to recover the original plaintext.
     *
     * @param cipherText The encrypted ciphertext string to be decrypted.
     * @return The decrypted plaintext as a string.
     */
    public String decrypt(String cipherText) {
        String plainText = "";

        for(int i = 0; i < cipherText.length(); i++) {
            plainText += (char)(key.get(i) ^ (int)cipherText.charAt(i));
        }
        return plainText;
    }

}
