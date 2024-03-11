package org.example.data;

import org.example.dataBase.angajatDB;
import org.example.dataUtils.dataUtils;
import org.example.model.angajat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dataLoader {


    private List<angajat> listaAngajati;

    public dataLoader() throws IOException {
        this.listaAngajati=new ArrayList<>();
    }

    public void loadData() throws IOException, SQLException {
        loadAngajati();

    }

    public void loadAngajati () throws IOException, SQLException {
        angajatDB.findAll();

    }


    private angajat creareAngajat(String [] listaAngajati){
        String nume=listaAngajati[0];
        int numarCasier=Integer.parseInt(listaAngajati[1]);
        int parolaCasier=Integer.parseInt(listaAngajati[2]);

        return new angajat(nume,parolaCasier);

    }


}
