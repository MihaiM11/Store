package org.example.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class csvWriter {
    private FileWriter fileWriter;

    public csvWriter (FileWriter fileWriter){
        this.fileWriter=fileWriter;
    }

    public void writeHeader () throws IOException {
        fileWriter.append("Nume anagajat");
        fileWriter.append(",");
        fileWriter.append("Numar casier");
        fileWriter.append(",");
        fileWriter.append("Parola Casier");
        fileWriter.append("\n");
    }

    public void writeRecord(String numeCasier,int numarCasier,int parolaCasier) throws IOException {
        fileWriter.append(numeCasier);
        fileWriter.append(",");
        fileWriter.append(String.valueOf(numarCasier));
        fileWriter.append(",");
        fileWriter.append(String.valueOf(parolaCasier));
        fileWriter.append("\n");
    }

    public void closeFile() throws IOException {
        fileWriter.close();
    }
}
