package ru.example.worwebapi.Services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.example.worwebapi.Services.FilesService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value("${name.of.data.file}")
    private String dataFileName;

    @Override
    public boolean saveToFile(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    @Override
    public File getDataFile(){
        return new File(dataFilePath + "/" + dataFileName);
    }
    @Override
    public String readFronFile() {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
@Override
    public boolean cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return false;
        } catch (IOException e) {
            return false;
        }
    }@Override
    public Path createTempFile(String suffix)  {
        try {
         return  Files.createTempFile(Path.of(dataFilePath),"tempFile",suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
