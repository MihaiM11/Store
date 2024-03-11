package org.example.dataUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class dataUtils {
    public static final String ANGAJAT_PATH="C:\\Users\\acer\\Desktop\\ProgramVanzareCoduri\\sistemVanzare\\angajati.csv";

    public static List<String> readFile (String filePathStr) throws IOException {
        Path path= Paths.get(filePathStr);

                return Files.readAllLines(path);
    }
}
