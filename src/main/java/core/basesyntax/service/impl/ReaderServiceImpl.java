package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public String[] readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().skip(1)
                    .map(line -> line.split(System.lineSeparator()))
                    .flatMap(Arrays::stream)
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
    }
}