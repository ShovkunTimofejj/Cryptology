package com.Timofejj12;

import java.io.IOException;

public class CLI {
    private FileService fileService = new FileService();
    private CaesarCipher caesarCipher = new CaesarCipher();

    public void runCommand(String command, String filePath, int key) throws Exception{
        if ("ENCRYPT".equals(command)) {
            try {
                String text = fileService.readFile(filePath);
                String encryptedText = caesarCipher.encrypt(text, key);
                fileService.writeFile(filePath.replace(".txt", "[ENCRYPTED].txt"), encryptedText);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("DECRYPT".equals(command)) {
            try {
                String text = fileService.readFile(filePath);
                String decryptedText = caesarCipher.decrypt(text, key);
                fileService.writeFile(filePath.replace("[ENCRYPTED].txt", "[DECRYPTED].txt"), decryptedText);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("BRUTE_FORCE".equals(command)) {
            caesarCipher.bruteForce(filePath);
        } else {
            System.out.println("Невідома команда: " + command);
        }
    }
}
