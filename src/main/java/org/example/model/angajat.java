package org.example.model;

import lombok.Data;

@Data

public class angajat {
    private String numeCasier;
    private int id;
    private int parolaCasier;

    public angajat(int id, String numeCasier,int parolaCasier){
        this.numeCasier=numeCasier;
        this.id=id;
        this.parolaCasier=parolaCasier;
    }

    public angajat(String numeCasier,int parolaCasier){
        this.numeCasier=numeCasier;
        this.parolaCasier=parolaCasier;

    }

    @Override
    public String toString() {
        return
                " Nume Casier:" + numeCasier  + "\n" +
                " ID Casier:" + id + "\n" +
                " Parola Casier:" + parolaCasier + "\n";
    }
}
