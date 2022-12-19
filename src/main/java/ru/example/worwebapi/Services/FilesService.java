package ru.example.worwebapi.Services;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToFile(String json);

    File getDataFile();

    String readFronFile();

    boolean cleanDataFile();

    Path createTempFile(String suffix);
}