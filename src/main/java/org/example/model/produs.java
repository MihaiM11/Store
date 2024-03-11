package org.example.model;

import lombok.Data;

@Data

public class produs {
    private int codProdus;
    private String denumire;
    private double pret;

    public produs(int codProdus, String denumire, double pret) {
        this.codProdus = codProdus;
        this.denumire = denumire;
        this.pret = pret;
    }

    public produs(String denumire, double pret){
        this.denumire=denumire;
        this.pret=pret;

    }

    @Override
    public String toString() {
        return
                "CodProdus=" + codProdus + "\n" +
                "Denumire=" + denumire + "\n" +
                "Pret=" + pret + "\n" ;

    }
}
