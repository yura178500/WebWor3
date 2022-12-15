package ru.example.worwebapi.Services;

public interface FilesService {
    boolean saveToFile(String json);

    String readFronFile();

}