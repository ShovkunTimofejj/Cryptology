package com.Timofejj12;

public class CaesarCipher {
    public String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shifted = (c - base + key) % 26 + base;
                encryptedText.append((char) shifted);
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public String decrypt(String text, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shifted = (c - base - key + 26) % 26 + base;
                decryptedText.append((char) shifted);
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }

    public void bruteForce(String filePath) throws Exception {
        for (int key = 1; key <= 25; key++) {
            String text = FileService.readFile(filePath);
            String decryptedText = decrypt(text, key);
            String outputFilePath = filePath.replace("[ENCRYPTED].txt", "[DECRYPTED]_Key" + key + ".txt");
            FileService.writeFile(outputFilePath, decryptedText);
            System.out.println("Дешифровано з ключем " + key);
        }
    }
}
