package com.company;

public class Main {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3; // Default shift value

    public static String encryptWord(String word, int shift) {
        // Initialize an empty string to store the encrypted word
        StringBuilder encryptedWord = new StringBuilder();

        // Iterate through each character in the input word
        for (int i = 0; i < word.length(); i++) {
            char originalChar = word.charAt(i);
            char encryptedChar = encryptLetter(originalChar, shift);
            encryptedWord.append(encryptedChar);
        }

        // Convert the StringBuilder to a String and return the encrypted word
        return encryptedWord.toString();
    }

    private static char encryptLetter(char originalChar, int shift) {
    }

    public static void main(String[] args) {
	// write your code here
    }
}
