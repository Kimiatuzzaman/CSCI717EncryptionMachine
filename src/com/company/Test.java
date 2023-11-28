package com.company;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Test {

    @org.junit.Test
    public void testEncryptLetter() {

        //test without wrapping around
        assertTrue("Incorrect letter after encrypting the letter 'a'",'d' == Main.encryptLetter('a',Main.SHIFT));

        //test with wrapping around
        assertTrue("Incorrect letter after encrypting the letter 'y'",'b' == Main.encryptLetter('y',Main.SHIFT));

        //test letter not in alphabet
        assertTrue("A letter not in the alphabet was shifted",'T' == Main.encryptLetter('T',Main.SHIFT));

    }

    @org.junit.Test
    public void testEncryptWord() {

        //test shifting a word with multiple characters
        assertTrue("Incorrect word after encrypting 'abc'",Main.encryptWord("abc",Main.SHIFT).equals("def"));

        //test with entire alphabet
        assertTrue("Incorrect word after encrypting entire alphabet",
            Main.encryptWord(Main.ALPHABET,Main.SHIFT).equals("defghijklmnopqrstuvwxyzabc"));

    }

    @org.junit.Test
    public void testMain() {

        //create fake user input
        ByteArrayInputStream inputStream = new ByteArrayInputStream("key\n2\ndef\nabcxyz".getBytes());
        System.setIn(inputStream);

        //catch program console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //run main
        Main.main(new String[0]);

        //make sure main prints the correct messages
        assertTrue("Main failed to print the welcome message", outputStream.toString().contains("Welcome to the CSCI717 Encryption Machine Construction"));
        assertTrue("Main failed to print the encrypted key", outputStream.toString().contains("Encrypted Key: nhb"));
        assertTrue("Main failed to print the first encrypted word", outputStream.toString().contains("Encrypted Word 1: "));
        assertTrue("Main failed to print the second encrypted word", outputStream.toString().contains("Encrypted Word 2: "));
        assertTrue("Main failed to print the closing message", outputStream.toString().contains("Message fully encrypted. Happy secret messaging!"));

    }

}