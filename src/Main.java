import Model.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        //service.conexiune();
        //service.afisareSubiecte();
        //service.adaugaSubiect();
        File aud = new File("audit2.csv");
        PrintWriter out = new PrintWriter(aud);
        out.println("ACTIUNI    -  DATA");
        int n = 15;
        System.out.println("Alegeti o optiune de mai jos");
        System.out.println("0. Exit");
        System.out.println("1. Afisare subiecte");
        System.out.println("2. Adauga subiect");
        System.out.println("3. Sterge subiect");
        System.out.println("4. 'Update' subiect");
        System.out.println("5. Afisare un subiect dupa id");
        System.out.println(" ");
        System.out.println("6. Afisare adrese");
        System.out.println("7. Adauga o adresa");
        System.out.println("8. Sterge o adresa");
        System.out.println("9. Afisare o adresa dupa id");
        System.out.println("10. Updateaza strada unei adrese");
        System.out.println("");
        System.out.println("11. Afisare profile");
        System.out.println("12. Adauga un profil nou");
        System.out.println("13. Sterge un profil");
        System.out.println("14. Afiseaza un profil dupa id");
        System.out.println("15. Updateaza numele unui profil");
        System.out.println("");
        System.out.println("16. Afiseaza scoli");
        System.out.println("17. Adauga o scoala noua");
        System.out.println("18. Sterge o scoala");
        System.out.println("19. Afiseaza o scoala dupa id");
        System.out.println("20. Updateaza numele unei scoli");
        while(n != 0){
            System.out.println("Alege o varianta: ");
            n = Integer.valueOf(scanner.nextLine());
            if (n==0) {
                break;
            }
            if (n == 1){
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Afisare subiecte  "   +   "  " +  timeStamp);
                service.afisareSubiecte();

            }
            if(n == 2){
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Subiect adaugat  "   +   "  " +  timeStamp);
                service.adaugaSubiect();
            }
            if(n == 3){
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Subiect sters  "   +   "  " +  timeStamp);
                service.stergeSubiect();
            }
            if(n == 4){
                service.updateSubiect();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Subiect updatat  "   +   "  " +  timeStamp);
            }
            if(n == 5){
                service.afisareSubiect();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Afisare subiect dupa id "   +   "  " +  timeStamp);
            }
            if(n == 6){
                service.afisareadrese();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Afisare adrese  "   +   "  " +  timeStamp);
            }
            if(n == 7){
                service.adaugaadresa();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Adaugare adresa  "   +   "  " +  timeStamp);
            }
            if(n == 8){
                service.stergeadresa();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Adresa stearsa  "   +   "  " +  timeStamp);
            }
            if (n == 9){
                service.gasesteadresa();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Adresa gasita "   +   "  " +  timeStamp);
            }
            if(n == 10){
                service.updateadresa();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Adresa updated  "   +   "  " +  timeStamp);
            }

            if(n == 11){
                service.afisareprofile();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Afisare profile  "   +   "  " +  timeStamp);
            }
            if(n==12){
                service.adaugaprofil();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Adaugare Profil  "   +   "  " +  timeStamp);
            }
            if(n==13){
                service.stergeprofil();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Stergere profil "   +   "  " +  timeStamp);
            }
            if(n==14){
                service.gasesteprofil();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Profil gasit  "   +   "  " +  timeStamp);
            }
            if(n==15){
                service.updateprofil();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Profil updated  "   +   "  " +  timeStamp);
            }
            if(n==16){
                service.afisarescoli();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Afisare scoli  "   +   "  " +  timeStamp);
            }
            if(n==17){
                service.adaugascoala();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Adaugare scoala  "   +   "  " +  timeStamp);
            }
            if(n==18){
                service.stergescoala();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Scoala stearsa  "   +   "  " +  timeStamp);
            }
            if(n==19){
                service.gasestescoala();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Scoala gasita  "   +   "  " +  timeStamp);
            }
            if(n==20){
                service.updatescoala();
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                out.println("Scoala updated  "   +   "  " +  timeStamp);
            }
        }
        out.close();


        /*
        service.setClasses();
        int n = 15;
        System.out.println("Bine ati venit! Momentan toate campurile (Adrese, Profesori, Studenti) sunt goale");
        System.out.println("Alegeti o actiune de mai jos: ");
        System.out.println(" ");
        System.out.println("ACTIUNI ADRESE");
        System.out.println("1. Initializeaza o lista predefinita de adrese");
        System.out.println("2. Afiseaza toate adresele din baza de date");
        System.out.println("3. Adauga o adresa noua");
        System.out.println(" ");
        System.out.println("ACTIUNI STUDENTI");
        System.out.println("4. Initializeaza o lista predefinita de studenti");
        System.out.println("5. Afiseaza toti studentii din baza de date");
        System.out.println("6. Adauga un student in baza de date");
        System.out.println(" ");
        System.out.println("ACTIUNI MATERII");
        System.out.println("7. Initializeaza o lista predefinita de materii");
        System.out.println("8. Afiseaza toate materiile din baza de date");
        System.out.println("9. Adauga o materie in baza de daet");
        System.out.println(" ");
        System.out.println("ACTIUNI PROFESORI");
        System.out.println("10. Initializeaza o lista predefinita de profesori");
        System.out.println("11. Afiseaza toti profesorii din baza de date");
        System.out.println("12. Adauga un profesor in baza de date");
        System.out.println(" ");
        System.out.println("ACTIUNI PROFILE");
        System.out.println("13. Initializeaza o lista predefinita de profile");
        System.out.println("14. Afiseaza toate profilele din baza de date");
        System.out.println("");
        System.out.println("ACTIUNI CLASE");
        System.out.println("15. Afiseaza toate clasele cu studentii care fac parte din aceasta");
        System.out.println("16. Afiseaza toti studentii cu bursa");
        System.out.println("17. Afiseaza profesorii in functie de anii de experienta descrescator");
        System.out.println("18. Aflati adresa unui elev (Introduceti id-ul acestuia)");
        System.out.println("");
        System.out.println("APASA TASTA 0 PENTRU A PARASI MENIUL SI PENTRU A INCHIDE APLICATIA");
        */

        /*
        while (n != 0) {
            System.out.println(" ");


            System.out.println("Alege o varianta: ");
            n = Integer.valueOf(scanner.nextLine());

            if (n == 1) {
                service.setAdresses();
            }
            if (n == 2) {
                service.showAddresses();
            }
            if (n == 3) {
                service.addAddress();
            }
            if (n == 4) {
                service.setStudents();
            }
            if (n == 5){
                service.showStudents();
            }
            if (n == 6){
                service.addStudent();
            }
            if (n == 7){
                service.setSubjects();
            }
            if (n == 8){
                service.showSubjects();
            }
            if(n == 9){
                service.addSubject();
            }
            if(n == 10){
                service.setProfessors();
            }
            if(n == 11){
                service.showProfessors();
            }
            if(n == 12){
                service.addProfessors();
            }
            if(n == 13){
                service.setProfiles();
            }
            if(n == 14){
                service.showProfiles();
            }
            if(n == 15){
                service.showClasses();
            }
            if(n == 16){
                service.showBursa();
            }
            if(n == 17){
                service.orderProf();
            }
            if(n == 18){
                service.studentAdresa();
            }
            if(n<1 || n>18){
                System.out.println("Actiune invalida.");
            }
        }
         */
    }
}