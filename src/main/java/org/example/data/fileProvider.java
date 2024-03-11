package org.example.data;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class fileProvider {
    private static final String FILE_NAME="Lista Angajati";
    private static final String FILE_EXTENSION=".csv";

    public static File getFile(){
        String rootPath=System.getProperty("user.dir");
        return new File(rootPath + "/" +FILE_NAME + LocalDateTime.now().toString().replace(":","") + FILE_EXTENSION);
    }
}
