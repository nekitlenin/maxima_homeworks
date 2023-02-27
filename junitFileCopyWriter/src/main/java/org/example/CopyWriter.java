package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Project: junitFileCopyWriter
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 01.02.2023 20:03 |
 * Created with IntelliJ IDEA
 */
public class CopyWriter {
    public void copyWrite(String originalFile, BufferedReader reader, BufferedWriter writerLog) throws IOException {
        String copyFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(copyFile = parseFileName(originalFile)))) {
            writeInCopyFile(reader, writer);
            writeInLog(writerLog, originalFile, copyFile);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * @param reader экземпляр класса BufferedReader с fileName = originalFile
     * @param writer экземпляр класса BufferedWriter с fileName = copyFile
     * @throws IOException если возникает ошибка ввода/вывода
     */
    private void writeInCopyFile(BufferedReader reader, BufferedWriter writer) throws IOException {
        String text;
        while ((text = reader.readLine()) != null)
            writer.write(text + "\n");
    }

    /**
     * Метод создаёт/обновляет файл log.txt, записывает в него действия
     *
     * @param writer       экземпляр класса BufferedWriter с fileName = "log.txt"
     * @param originalFile путь/имя оригинального файла
     * @param copyFile     имя скопированного файла
     * @throws IOException если возникает ошибка ввода/вывода
     */
    private void writeInLog(BufferedWriter writer, String originalFile, String copyFile) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        writer.write(date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss")));
        writer.write(" | скопирован файл: " + originalFile + " -> " + copyFile + "\n");
    }

    /**
     * Метод использует split(), чтобы распарсить входной параметр
     * (убрать пакеты, оставить название файла, добавить "_копия.", оставить расширение файла).
     * Путь режется по "/", оставляется только последний элемент, у него отделяется часть после ".",
     * прибавляется "_копия.", прибавляется всё после ".".
     *
     * @param name переменная, которая хранит путь/имяФайла.расширение
     * @return "имяФайла" + "_копия." + "расширение"
     */
    private String parseFileName(String name) {
        return (name.split("/")[name.split("/").length - 1]).split("\\.")[0]
                + "_копия." + name.split("\\.")[1];
    }
}
