package org.example.operatii;


import org.example.model.angajat;
import org.example.model.produs;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class vanzareTest {
    produs produs;
    angajat angajat;

    @Before

    public void setup(){
        produs= new produs(1,"banane",5.99);
        angajat= new angajat(1,"Marius",1);
    }
    @Test
    public void calculPret(){
        double vanzare= org.example.operatii.vanzare.calculPret(2,2);
        assertEquals(4,vanzare,1);



    }

}