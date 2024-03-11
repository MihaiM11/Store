package org.example;




import org.example.dataBase.DB;
import org.example.dataBase.angajatDB;
import org.example.dataBase.produseDB;
import org.example.model.angajat;
import org.example.model.produs;
import org.example.operatii.vanzare;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;



public class Main {
   static final int ID_ADMIN=101;
   static final int PAROLA_ADMIN=7070;

    public static void main(String[] args) throws IOException, SQLException {


        System.out.println("Buna ziua !");
        System.out.println("Va rog selectati o varianta de mai jos:");
        System.out.println("1. Logati-va pentru vanzare! ");
        System.out.println("2. Logativa-va ca si admin");
        System.out.println("3. Inchideti aplicatia!");


        while(true){
            Scanner scanner= new Scanner(System.in);
            int optiune= Integer.parseInt(scanner.nextLine());
            switch (optiune){
                case 1 :

                    System.out.println("Introduceti id :");
                    int id=Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduceti parola");
                    int parola=Integer.parseInt(scanner.nextLine());

                    List<angajat>listaAngajati=angajatDB.findAll();
                    int angajatGasit=0;

                        for (angajat angajat : listaAngajati) {
                            if(angajat.getId()==id && angajat.getParolaCasier()==parola){
                                System.out.println(" Bine ai venit: \n" + angajat.getNumeCasier());
                                angajatGasit+=1;

                            }

                        }
                        if(angajatGasit==0){
                            System.out.println("Datele introduse sunt invalide");
                            break;
                        }
                        vanzare.IntroducereCoduri();




                    break;


                case 2:
                    System.out.println("Buna ziua!");
                    System.out.println("Introduceti id:");
                    int Admin=Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduceti parola: ");
                    int AdminP=Integer.parseInt(scanner.nextLine());

                    if(!(Admin==ID_ADMIN&& AdminP==PAROLA_ADMIN)){
                        System.out.println("Date introduse invalide");
                        break;
                    }

                    System.out.println("Ce doriti in continuare ? :" +
                            "\n 1. Adaugare angajat nou" +
                            "\n 2. Adaugare produs nou " +
                            "\n 3. Stergere angajat " +
                            "\n 4. Stergere produs" +
                            "\n 5. Vizualizare incasari totale" );

                    int optiune1=Integer.parseInt(scanner.nextLine());
                    String numeAngajatNou;
                    Random random= new Random();
                    int parolaAngajatNou= random.nextInt(1000,10000);
                    int idAngajatNou= random.nextInt(1,10);

                    switch (optiune1){
                        case 1:
                            System.out.println("In aceasta sectiune se adauga un nou angajat :" +
                                    "\nIn continuare va trebui sa introduceti numele angajatului :" );
                            numeAngajatNou=scanner.nextLine();

                            angajat angajatNou= new angajat(idAngajatNou,numeAngajatNou,parolaAngajatNou);

                             var angajati= new ArrayList<angajat>();
                             angajati.add(angajatNou);
                             int idSimilar=0;

                            for(angajat angajat:angajati){
                                if(angajat.getId()==idAngajatNou){
                                    idSimilar++;

                                }

                            }
                            if(idSimilar==0){

                                angajatDB.add(angajati);
                                System.out.println("Angajatul inregistrat este : \n" + angajatNou);
                            }else {
                                System.out.println("Id-ul generat exista deja in baza de date ! Reincercati !!");
                                break;
                            }
                            break;




                        case  2:
                            int codProdus;
                            String numeProdus;
                            double pretProdus;
                            System.out.println("In aceasta sectiune se adauga un nou produs");

                            System.out.println("Introduceti numele produslui:");
                            numeProdus=scanner.nextLine();

                            System.out.println("Introduceti codul produslui");
                            codProdus=Integer.parseInt(scanner.nextLine());

                            System.out.println("Introduceti pretul produsului");
                            pretProdus=Double.parseDouble(scanner.nextLine());

                            produs produsNou= new produs(codProdus,numeProdus,pretProdus);
                            var produse=new ArrayList<produs>();
                            produse.add(produsNou);
                            int codSimilar=0;
                            for(produs produs: produse){
                                if(produs.getCodProdus()==codProdus ){
                                    codSimilar++;

                                }

                            }
                            if(codSimilar==0){

                                produseDB.addProduse(produse);
                                System.out.println("Produsul  adaugat este : \n" + produsNou);

                            }else {
                                System.out.println(" Codul introdus exista deja in baza de date");
                                break;


                            }

                    break;
                        case 3:
                            System.out.println("In aceastas sectiune se efectueaza operatiunea de eliminare a unui angajat din lista");
                            int idSters;
                            System.out.println("Introduceti id-ul angajatului pe care doriti sa-l stergeti: ");
                            idSters=Integer.parseInt(scanner.nextLine());


                            for(angajat angajat:angajatDB.findAll()){
                                if(angajat.getId()==idSters){
                                    System.out.println("Angajatul eliminat din list este " + angajat);
                                    int sters=angajatDB.delete(idSters);
                                }else {
                                    System.out.println("Id -ul introdus nu se regaseste in baza de date");
                                }
                            }
                            break;

                        case 4 :
                            System.out.println("In aceasta sectiune se efectueaza operatiunea de eliminare a unui produs din baza de date");
                            int codSters;
                            System.out.println("Introduceti codul produslui pe care doriti sa-l stergeti: ");
                            codSters=Integer.parseInt(scanner.nextLine());

                            for(produs produs:produseDB.findALL()){
                                if(produs.getCodProdus()==codSters){
                                    System.out.println("Produsul sters este" + produs);
                                    int sters=produseDB.delete(codSters);
                                }else {
                                    System.out.println("Codul introdus nu se regaseste in baza de date");

                                }
                            }
                            break;
                        case 5 :
                            System.out.println("Totalul vanzarilor este :");
                           double totalIncasari=vanzare.afisareIncasari();
                            System.out.println(totalIncasari + " lei");








            }

        }


            System.out.println("Ati revenit la meniul intial:");
            System.out.println("1. Logati-va pentru vanzare! ");
            System.out.println("2. Logativa-va ca si admin");
            System.out.println("3. Inchideti aplicatia!");
            System.out.println("Introduceti o varianta: ");

        }





    }
    public static void dbConect() throws SQLException {
                 try(var connection = DB.connect()){
                     System.out.println("Connected to the Postgres");

        }catch (SQLException e){
                     System.out.println(e.getMessage());
                 }

    }

    public static void creareTabelAngajati(){
        var sql = "CREATE TABLE angajati (" +
                "    id SERIAL PRIMARY KEY," +
                "    numeCasier VARCHAR(255) NOT NULL," +
                "    parolaCasier integer(10, 2) NOT NULL" +
                ");";
        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void creareTabelProduse(){
        var sql = "CREATE TABLE angajati (" +
                "    codprodus SERIAL PRIMARY KEY," +
                "    denumire VARCHAR(255) NOT NULL," +
                "    pret decimal(10, 2) NOT NULL" +
                ");";
        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



}

