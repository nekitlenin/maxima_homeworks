import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Project: homework13
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 01.02.2023 20:03 |
 * Created with IntelliJ IDEA
 */
public class CopyWriter {
    public CopyWriter() {
        Scanner scanner = new Scanner(System.in);
        String originalFile = scanner.nextLine();
        String copyFile;

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(copyFile = parseFileName(originalFile)));
             BufferedWriter writerLog = new BufferedWriter(new FileWriter("log.txt", true))) {
            writeCopyFile(reader, writer);
            writeLog(writerLog, originalFile, copyFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param reader экземпляр класса BufferedReader с fileName = originalFile
     * @param writer экземпляр класса BufferedWriter с fileName = copyFile
     * @throws IOException если возникает ошибка ввода/вывода
     */
    private void writeCopyFile(BufferedReader reader, BufferedWriter writer) throws IOException {
        String text;
        while ((text = reader.readLine()) != null)
            writer.write(text + "\n");
    }

    /**
     * Метод создаёт/обновляет файл log.txt, записывает в него действия
     * @param writer экземпляр класса BufferedWriter с fileName = "log.txt"
     * @param originalFile путь/имя оригинального файла
     * @param copyFile имя скопированного файла
     * @throws IOException если возникает ошибка ввода/вывода
     */
    private void writeLog(BufferedWriter writer, String originalFile, String copyFile) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        writer.write(date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss")));
        writer.write(" | скопирован файл: " + originalFile + " -> " + copyFile + "\n");
    }

    /**
     * Метод использует split(), чтобы распарсить входной параметр
     * (убрать папки, оставить название файла, добавить "_копия.", оставить расширение файла)
     * @param name переменная, которая хранит путь/имя файла
     * @return "имяИсходника" + "_копия." + "расширениеФайла"
     */
    private String parseFileName(String name) {
        return (name.split("/")[name.split("/").length - 1]).split("\\.")[0]
                + "_копия." + name.split("\\.")[1];
    }
}
