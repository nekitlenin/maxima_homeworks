package org.example;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalFile = scanner.nextLine();
        CopyWriter copyWriter = new CopyWriter();

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writerLog = new BufferedWriter(new FileWriter("log.txt", true))) {
            copyWriter.copyWrite(originalFile, reader, writerLog);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
