package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeToFile(List<String> report) {
        try {
            Files.write(Path.of(FILE_PATH), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}