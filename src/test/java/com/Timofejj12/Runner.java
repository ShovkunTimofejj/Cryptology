package com.Timofejj12;

public class Runner {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Недостатньо аргументів. Використання: java -jar myApp.jar command filePath key");
            return;
        }

        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        CLI cli = new CLI();
        cli.runCommand(command, filePath, key);
    }
}
