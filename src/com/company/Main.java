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
    public static char encryptLetter(char letter, int shift) {
        // Check if the character is a lowercase English letter
        if (Character.isLowerCase(letter)) {
            // Calculate the index of the original character in the ALPHABET
            int originalIndex = ALPHABET.indexOf(letter);

            // Calculate the index of the encrypted character after shifting
            int encryptedIndex = (originalIndex + shift) % ALPHABET.length();

            // Ensure the index wraps around the alphabet
            if (encryptedIndex < 0) {
                encryptedIndex += ALPHABET.length();
            }

            // Get the encrypted character from the ALPHABET
            char encryptedChar = ALPHABET.charAt(encryptedIndex);

            // Return the encrypted character
            return encryptedChar;
        } else {
            // If the character is not a lowercase English letter, return it unchanged
            return letter;
        }
    }


    public static void main(String[] args) {
	// write your code here
    }
}
