package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;
import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GoldenMasterTest {
    private static final int SPREAD = 1000;
    private String goldenMasterFilePath;

    @Before
    public void setup() throws IOException {
        goldenMasterFilePath = System.getProperty("user.dir") + "/goldenMaster.txt";

        File f = new File(goldenMasterFilePath);
        if(!f.exists() && !f.isDirectory()) {
            createGoldenMaster();
        }
    }

    @Test
    public void currentOutputMatchesGoldenMaster() throws Exception {
        String currentOutputFilePath = System.getProperty("user.dir") + "/output.txt";

        captureCurrentOutput(currentOutputFilePath);

        String output = readFileAsString(currentOutputFilePath);
        String goldenMaster = readFileAsString(goldenMasterFilePath);

        assertTrue(output.equals(goldenMaster));
    }

    private void createGoldenMaster() throws IOException {
        captureCurrentOutput(goldenMasterFilePath);
    }

    private void captureCurrentOutput(String filename) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream(filename));
        System.setOut(out);

        for(int i = 0; i < SPREAD; i++) {
            String[] arguments = new String [1];
            arguments[0] = Integer.toString(i);
            GameRunner.main(arguments);
        }
    }

    private String readFileAsString(String currentOutputFilePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(currentOutputFilePath)));
    }
}