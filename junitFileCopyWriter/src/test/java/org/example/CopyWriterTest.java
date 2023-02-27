package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Project: junitFileCopyWriter
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.02.2023 23:21 |
 * Created with IntelliJ IDEA
 */
public class CopyWriterTest {
    private CopyWriter copyWriter;
    private BufferedReader reader;
    private BufferedWriter writerLog;
    private BufferedWriter writerForTestInputFile;
    private File testInput;
    private File output;

    @Before
    public void setUp() throws Exception {
        copyWriter = new CopyWriter();
        testInput = new File("src/test/resources/input.txt");
        if (!testInput.createNewFile())
            System.out.println("input.txt already exists!");
        output = new File("input_копия.txt");
        reader = new BufferedReader(new FileReader(testInput));
        writerLog = new BufferedWriter(new FileWriter("src/test/resources/testLog.txt", true));
        writerForTestInputFile = new BufferedWriter(new FileWriter(testInput));
    }

    @After
    public void tearDown() throws Exception {
        if (testInput.delete())
            System.out.println("input.txt removed!");
        if (output.delete())
            System.out.println("input_копия.txt removed!");
        reader.close();
        writerLog.close();
    }

    @Test
    public void copyWriteTest_whenInputWithNewLine_thenFilesEquals() throws IOException {
        writerForTestInputFile.write("Hello, world!\n");
        writerForTestInputFile.close();
        copyWriter.copyWrite(testInput.getPath(), reader, writerLog);

        assertArrayEquals(Files.readAllBytes(testInput.toPath()), Files.readAllBytes(output.toPath()));
    }

    @Test
    public void copyWriteTest_whenInputWithoutNewLine_thenFilesNotEquals() throws IOException {
        writerForTestInputFile.write("Hello, world!");
        writerForTestInputFile.close();
        copyWriter.copyWrite(testInput.getPath(), reader, writerLog);

        assertNotEquals(Files.readAllBytes(testInput.toPath()), Files.readAllBytes(output.toPath()));
    }

    @Test(expected = IOException.class)
    public void copyWriteTest_whenStreamWasClosed_thenException() throws IOException {
        reader.close();
        copyWriter.copyWrite(testInput.getPath(), reader, writerLog);
    }

    @Test(expected = FileNotFoundException.class)
    public void copyWriteTest_whenWrongPathToFile_thenException() throws IOException {
        reader = new BufferedReader(new FileReader("noSuchFile"));
        copyWriter.copyWrite(testInput.getPath(), reader, writerLog);
    }
}
