package org.example.operatii;

import org.example.dataBase.produseDB;
import org.example.model.produs;

import java.util.List;
import java.util.Scanner;

public class vanzare {

    static double incasariTotale=0;

    static Scanner scanner= new Scanner(System.in);

    public static double calculPret(double cantitate,double pret){
        double pretFinal=pret*cantitate;
       return pretFinal;
    }


    public static void IntroducereCoduri(){
          double sumaDatorata=0;


        int codIntrodus;
        System.out.println("Introduceti codul produsului:");
        while (true) {
            codIntrodus=Integer.parseInt(scanner.nextLine());
            List<produs> listaProduse= produseDB.findALL();
            produs produsIntrodus=null;
            int produsGasit=0;
            double cantiate;

            for(produs produs:listaProduse){
                if(produs.getCodProdus()==codIntrodus){
                    System.out.println(produs.getDenumire());
                    produsIntrodus=produs;
                    produsGasit+=1;
                }
            }
            if(produsGasit==0) {
                System.out.println("Codul introdus nu exista in baza de date");
                break;

            }
            System.out.println("Introduceti cantitatea:");
            cantiate=Double.parseDouble(scanner.nextLine());
            double pretFinal= vanzare.calculPret(cantiate,produsIntrodus.getPret() );
            sumaDatorata+=pretFinal;



            System.out.println(" 0. Inchidere bon");
            System.out.println(" 1. Continua bon ");
            int varianta=Integer.parseInt(scanner.nextLine());

            if(varianta==0){
                System.out.println("Suma datorata este " +  sumaDatorata);
                break;
            }else{

                System.out.println("Subtotal: " + sumaDatorata);


                System.out.println("Introduceti codul produsului: ");
            }






        }
        incasariTotale+=sumaDatorata;

        System.out.println("VA MULTUMIM");


    }
    public static double afisareIncasari(){
        return incasariTotale;

    }


}
