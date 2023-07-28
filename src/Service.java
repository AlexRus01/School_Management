import Database.DbConnection;
import InterfaceImplementation.*;
import Model.Address;
import Model.Professor;
import Model.Student;
import Model.Subject;
import Model.Profile;
import Model.Clasa;
import Model.School;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import java.util.Scanner;
import java.sql.*;

public class Service {
    Scanner scan = new Scanner(System.in);
    Vector<Student> students = new Vector<Student>();
    Vector<Address> adresses = new Vector<Address>();
    Vector<Professor> professors = new Vector<Professor>();
    Vector<Subject> subjects = new Vector<Subject>();
    Vector<Clasa> classes = new Vector<Clasa>();
    Vector<Profile> profiles = new Vector<Profile>();

    public static Connection conexiune() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alexbaza", "root", "Hailaspoon123!");

            Statement statement = connection.createStatement();
            System.out.println("Conectat la baza de date");
//            ResultSet resultSet = statement.executeQuery("select * from subject");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void afisareSubiecte()
    {
        Connection conn = Database.DbConnection.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from subject");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_subject") + " " + resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void adaugaSubiect(){
        Subject sub = new Subject();
        sub.setId_subject(4);
        System.out.println("Introduceti materia dorita: ");
        sub.setName(scan.nextLine());
        SubjectDaoImplementation sdao = new SubjectDaoImplementation();

        try {
            sdao.add(sub);
            System.out.println("Materia a fost adaugata cu succes");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stergeSubiect(){
        afisareSubiecte();
        System.out.println("Introduceti id-ul materiei pe care doriti sa o stergeti");
        Integer nr = scan.nextInt();
        boolean ok = false;
        SubjectDaoImplementation sdao = new SubjectDaoImplementation();
        try{
            ok = true;
            sdao.delete(nr);
            System.out.println("Subiectul a fost sters cu succes");
        }catch (Exception e){
            e.printStackTrace();
        }
        if (ok == false){
            System.out.println("Subiectul nu a fost sters");
        }
    }

    public void afisareSubiect(){
        boolean ok = false;
        SubjectDaoImplementation sdao = new SubjectDaoImplementation();
        Integer nr;
        System.out.println("Introduceti id-ul materiei pe care doriti sa o afisati");
        nr = scan.nextInt();
        try{
            Subject sub;
            sub = sdao.getSubject(nr);
            ok = true;
            System.out.println(sub.getName());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Subiectul cu acel id nu exista");
        }
    }

    public void updateSubiect(){
        SubjectDaoImplementation sdao = new SubjectDaoImplementation();
        int nr;
        System.out.println("Introduceti id-ul materiei pe care doriti sa o editati");
        nr = scan.nextInt();
        Subject sub = new Subject();
        try {
            sub = sdao.getSubject(nr);
            String nume;
            System.out.println("Introduceti numele materiei pe care doriti sa o editati");
            nume = scan.next();
            sub.setName(nume);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            sdao.update(sub);
        }catch (Exception e){
            e.printStackTrace();
        }
        }

        public void afisareadrese(){
        try{
            Connection conn = Database.DbConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from address");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_address") + " " + resultSet.getString("city") + " " + resultSet.getString("street") + " " + resultSet.getInt("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }

        public void adaugaadresa(){
        try {
            Address p = new Address();
            p.setId_address(adresses.size() + 1);
            System.out.println("Introduceti oras-ul: ");
            p.setCity(scan.nextLine());
            System.out.println("Introduceti strada: ");
            p.setStreet(scan.nextLine());
            System.out.println("Selectati numarul strazii: ");
            p.setNumber(Integer.valueOf(scan.nextLine()));
            AdressDaoImplementation adresadao = new AdressDaoImplementation();
            adresadao.add(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }

        public void stergeadresa(){
        try{
            afisareadrese();
            System.out.println("Introduceti id-ul adresei pe care doriti sa o stergeti: ");
            Integer id = scan.nextInt();
            AdressDaoImplementation ado = new AdressDaoImplementation();
            ado.delete(id);
            System.out.println("Daca id-ul exista, adresa a fost stearsa cu succes");
        }catch (Exception e){
            e.printStackTrace();
        }
        }

        public void gasesteadresa() {
            try {
                System.out.println("Introduceti id-ul pe care il cautati");
                Integer n = scan.nextInt();
                AdressDaoImplementation ado = new AdressDaoImplementation();
                Address d = ado.getAddress(n);
                if (d != null) {
                    System.out.println("Adresa " + ": " + d.getCity() + " " + d.getStreet() + " " + d.getNumber());
                } else {
                    System.out.println("Adresa nu a fost gasita");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public void updateadresa(){
        try{
            System.out.println("Introduceti id-ul adresei pe care doriti sa o editati");
            Integer id = scan.nextInt();
            AdressDaoImplementation ado = new AdressDaoImplementation();
            Address ad = ado.getAddress(id);

            System.out.println("Introduceti strada");
            String str = scan.next();
            ad.setStreet(str);
            ado.update(ad);
        }catch (Exception e){
            e.printStackTrace();
        }
        }

        public void afisareprofile(){
        try{
            Connection con = Database.DbConnection.getConnection();
            String query = "select * from profile";
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(query);

            while(r.next()){
                System.out.println(r.getInt("id_profile") + " " + r.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        }

    public void adaugaprofil(){
        try {
            Profile p = new Profile();
            p.setId_profile(3);
            System.out.println("Introduceti numele: ");
            p.setName(scan.nextLine());
            ProfileDaoImplementation d = new ProfileDaoImplementation();
            d.add(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stergeprofil(){
        try{
            afisareprofile();
            System.out.println("Introduceti id-ul materiei pe care doriti sa o stergeti");
            Integer n = scan.nextInt();
            ProfileDaoImplementation pao = new ProfileDaoImplementation();
            pao.delete(n);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void gasesteprofil(){
        try {
            System.out.println("Introduceti id-ul pe care il cautati");
            Integer n = scan.nextInt();
            ProfileDaoImplementation pao = new ProfileDaoImplementation();
            Profile d = pao.getProfile(n);
            if (d != null) {
                System.out.println("Profilul " + ": " + d.getName());
            } else {
                System.out.println("Profilul nu a fost gasit");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateprofil(){
        ProfileDaoImplementation pr = new ProfileDaoImplementation();
        int nr;
        System.out.println("Introduceti id-ul profilului pe care doriti sa il editati");
        nr = scan.nextInt();
        Profile prof = new Profile();
        try {
            prof = pr.getProfile(nr);
            String nume;
            afisareprofile();
            System.out.println("Introduceti numele profilului pe care doriti sa il editati");
            nume = scan.next();
            prof.setName(nume);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            pr.update(prof);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afisarescoli(){
        try{
            Connection con = Database.DbConnection.getConnection();
            String query = "select * from school";
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(query);

            while(r.next()){
                System.out.println(r.getInt("id_school") + " " + r.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adaugascoala(){
        try {
            School p = new School();
            p.setId_school(5);
            System.out.println("Introduceti numele: ");
            p.setName(scan.nextLine());
            SchoolDaoImplementation schooldao = new SchoolDaoImplementation();
            schooldao.add(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stergescoala(){
        afisarescoli();
        System.out.println("Introduceti id-ul scolii pe care doriti sa o stergeti");
        Integer nr = scan.nextInt();
        boolean ok = false;
        SchoolDaoImplementation sdao = new SchoolDaoImplementation();
        try{
            ok = true;
            sdao.delete(nr);
            System.out.println("Scoala a fost stearsa cu succes");
        }catch (Exception e){
            e.printStackTrace();
        }
        if (ok == false){
            System.out.println("Scoala nu a fost stearsa");
        }
    }

    public void gasestescoala(){
        try {
            System.out.println("Introduceti id-ul pe care il cautati");
            Integer n = scan.nextInt();
            SchoolDaoImplementation sco = new SchoolDaoImplementation();
            School d = sco.getSchool(n);
            if (d != null) {
                System.out.println("Scoala " + ": " + d.getName());
            } else {
                System.out.println("Scoala nu a fost gasita");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatescoala(){
        SchoolDaoImplementation pr = new SchoolDaoImplementation();
        int nr;
        System.out.println("Introduceti id-ul profilului pe care doriti sa il editati");
        nr = scan.nextInt();
        School prof = new School();
        try {
            prof = pr.getSchool(nr);
            String nume;
            afisarescoli();;
            System.out.println("Introduceti numele scolii pe care doriti sa o editati");
            nume = scan.next();
            prof.setName(nume);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            pr.update(prof);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void setAdresses() {
        Address a1 = new Address(1, "Bucuresti", "Lalosu", 5);
        Address a2 = new Address(2, "Bucuresti", "Republicii", 52);
        Address a3 = new Address(3, "Bucuresti", "Coltei", 74);
        Address a4 = new Address(4, "Bucuresti", "Mihai Bravu", 41);
        adresses.add(a1);
        adresses.add(a2);
        adresses.add(a3);
        adresses.add(a4);
    }

    public void addAddress() {
        Address p = new Address();
        p.setId_address(adresses.size() + 1);
        System.out.println("Introduceti oras-ul: ");
        p.setCity(scan.nextLine());
        System.out.println("Introduceti strada: ");
        p.setStreet(scan.nextLine());
        System.out.println("Selectati numarul strazii: ");
        p.setNumber(Integer.valueOf(scan.nextLine()));
        adresses.add(p);
        System.out.println("Adresa a fost adaugata cu succes");
    }

    public void showAddresses() {
        System.out.println("Lista cu adresele se afla mai jos");
        for (Integer i = 0; i < adresses.size(); i++) {
            System.out.println(adresses.get(i).getId_address() + ": " + "Orasul " + adresses.get(i).getCity() + ", strada " + adresses.get(i).getStreet() + " " + adresses.get(i).getNumber());
        }
        System.out.println(" ");
    }

    public void setStudents() {
        students.clear();
        Address a1 = new Address(1, "Bucuresti", "Lalosu", 5);
        Address a2 = new Address(2, "Bucuresti", "Republicii", 52);
        Address a3 = new Address(3, "Bucuresti", "Coltei", 74);
        Address a4 = new Address(4, "Bucuresti", "Mihai Bravu", 41);
        Student s1 = new Student(students.size()+1, "Alex", "Rus", 15, a1, true, 1);
        Student s2 = new Student(students.size()+2, "Mihaela", "Popescu", 16, a2, true, 2);
        Student s3 = new Student(students.size()+3, "Mihai", "Enescu", 18, a3, true, 1);
        Student s4 = new Student(students.size()+4, "Luca", "Dinescu", 15, a4, false, 1);
        Student s5 = new Student(students.size()+5, "Maria", "Rus", 17, a1, false, 2);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        Integer id;

        id = students.size() + 1;

        System.out.println("Dati prenumele ");
        String nume;
        nume = scanner.nextLine();

        System.out.println("Dati numele ");
        String prenume;
        prenume = scanner.nextLine();

        Integer v;
        System.out.println("Varsta: ");
        v = Integer.valueOf(scanner.nextLine());

        Boolean vf;
        System.out.println("Are bursa? (true/false)");
        vf = Boolean.valueOf(scanner.nextLine());

        System.out.println("Id-ul clasei din care face parte. Aveti clasele mai jos:");
        showClasses();
        Integer id2;
        id2 = Integer.valueOf(scanner.nextLine());

        System.out.println("Acum, avem nevoie de adresa");
        Integer idadresa = adresses.size() + 1;

        System.out.println("Orasul adresei");
        String oras = scanner.nextLine();

        System.out.println("Strada adresei");
        String strada = scanner.nextLine();

        System.out.println("Numarul ");
        Integer numarul = Integer.valueOf(scanner.nextLine());

        Address adresa = new Address(idadresa, oras, strada, numarul);

        Student stud = new Student(id, nume, prenume, v, adresa, vf, id2);

        students.add(stud);
        classes.get(id2 - 1).AddStudent(stud);
        adresses.add(adresa);

        System.out.println("Studentul a fost adaugat cu succes");

    }

    public void showStudents() {
        System.out.println("Lista cu studentii se afla mai jos: ");
        Integer i;
        for (i = 0; i < students.size(); i++)
            System.out.println("Studentul " + students.get(i).getFirstname() + " " + students.get(i).getLastname() + " cu id-ul " + students.get(i).getId_person());
        System.out.println("");
    }

    public void setSubjects() {
        Subject s1 = new Subject(1, "Matematica");
        Subject s2 = new Subject(2, "Romana");
        Subject s3 = new Subject(3, "Engleza");
        Subject s4 = new Subject(4, "Istorie");
        Subject s5 = new Subject(5, "Geografie");
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);
        subjects.add(s4);
        subjects.add(s5);

    }

    public void addSubject() {
        Subject sub = new Subject();
        sub.setId_subject(subjects.size() + 1);
        System.out.println("Introduceti materia dorita: ");
        sub.setName(scan.nextLine());
        subjects.add(sub);
        System.out.println("Materia a fost adaugata cu succes");

    }

    public void showSubjects() {

        if (subjects.size() != 0) {
            System.out.println("Materiile din baza de date sunt: ");
            for (Integer i = 0; i < subjects.size(); i++) {
                System.out.println("Materia " + subjects.get(i).getName());
            }
        } else {
            System.out.println("Nu exista nicio materie in baza de date. Puteti sa initializati o lista predefinita sau sa incepeti sa adaugati materii de la tastatura.");
        }

        System.out.println(" ");
    }

    public void setProfessors() {
        Address a1 = new Address(1, "Bucuresti", "Baneasa", 341);
        Address a2 = new Address(2, "Bucuresti", "Berceni", 52);
        Address a3 = new Address(3, "Bucuresti", "Coltei", 74);
        Address a4 = new Address(4, "Bucuresti", "Mihai Bravu", 41);
        Address a5 = new Address(5, "Bucuresti", "Dristor", 8);
        Subject s1 = new Subject(1, "Matematica");
        Subject s2 = new Subject(2, "Romana");
        Subject s3 = new Subject(3, "Engleza");
        Subject s4 = new Subject(4, "Istorie");
        Subject s5 = new Subject(5, "Geografie");
        Professor prof1 = new Professor(professors.size()+1, "Horia", "Ursu", 45, a1, 5, s1);
        Professor prof2 = new Professor(professors.size()+2, "George", "Dragomir", 50, a2, 10, s2);
        Professor prof3 = new Professor(professors.size()+3, "Pavel", "Craciun", 47, a3, 15, s3);
        Professor prof4 = new Professor(professors.size()+4, "Aurelian", "Stoica", 40, a4, 10, s4);
        professors.add(prof1);
        professors.add(prof2);
        professors.add(prof3);
        professors.add(prof4);
    }

    public void showProfessors() {
        if (professors.size() != 0) {
            System.out.println("Lista profesorilor din scoala este: ");
            for (Integer i = 0; i < professors.size(); i++) {
                System.out.println(professors.get(i).getFirstname() + " " + professors.get(i).getLastname() + " cu " + professors.get(i).getExperience() + " ani experienta");
            }
        } else {
            System.out.println("Lista este goala. Puteti initia o lista predefinita de profesori sau sa incepeti sa adaugati manual profesori de la tastatura");
        }

        System.out.println(" ");
    }

    public void addProfessors() {
        Scanner scanner = new Scanner(System.in);
        Integer id;

        id = professors.size() + 1;

        System.out.println("Dati prenumele ");
        String nume;
        nume = scanner.nextLine();

        System.out.println("Dati numele ");
        String prenume;
        prenume = scanner.nextLine();

        Integer v;
        System.out.println("Varsta: ");
        v = Integer.valueOf(scanner.nextLine());

        Integer exp;
        System.out.println("Introduceti anii de experienta: ");
        exp = Integer.valueOf(Integer.valueOf(scanner.nextLine()));

        System.out.println("Acum, avem nevoie de adresa");
        Integer idadresa = adresses.size() + 1;

        System.out.println("Orasul adresei");
        String oras = scanner.nextLine();

        System.out.println("Strada adresei");
        String strada = scanner.nextLine();

        System.out.println("Numarul ");
        Integer numarul = Integer.valueOf(scanner.nextLine());

        System.out.println("Acum, materia pe care o preda");
        showSubjects();
        System.out.println("Daca materia este in lista, apasati tasta 1, daca nu, apasati tasta 0");
        Integer intr = Integer.valueOf(scanner.nextLine());
        System.out.println("Scrieti numele materiei: ");
        String mt = scanner.nextLine();
        Subject z = new Subject();
        if (intr == 1) {
            for (Integer i = 0; i <= subjects.size(); i++) {
                if (mt.equals(subjects.get(i).getName())) {
                    z = subjects.get(i);
                }
            }
        } else {
            z.setId_subject(subjects.size() + 1);
            z.setName(mt);
            subjects.add(z);
            System.out.println("Materia a fost adaugata in baza de date");
        }


        Address adresa = new Address(idadresa, oras, strada, numarul);

        Professor prf = new Professor(id, nume, prenume, v, adresa, 10, z);
        adresses.add(adresa);
        professors.add(prf);

        System.out.println("Profesorul a fost adaugat cu succes");
    }

    public void setProfiles() {
        Profile p1 = new Profile(1, "Stiintele Naturii");
        Profile p2 = new Profile(2, "Matematica - Informatica");
        Profile p3 = new Profile(3, "Filologie");
        profiles.add(p1);
        profiles.add(p2);
        profiles.add(p3);
    }

    public void showProfiles() {
        System.out.println("Profilele disponibile sunt: ");
        for (Integer i = 0; i < profiles.size(); i++) {
            System.out.println("Profilul " + profiles.get(i).getName());
        }
    }

    public void setClasses() {
        Address a1 = new Address(1, "Bucuresti", "Baneasa", 341);
        Address a2 = new Address(2, "Bucuresti", "Berceni", 52);
        Address a3 = new Address(3, "Bucuresti", "Coltei", 74);
        Address a4 = new Address(4, "Bucuresti", "Mihai Bravu", 41);
        Address a5 = new Address(5, "Bucuresti", "Dristor", 8);
        Address a6 = new Address(6, "Bucuresti", "Sun Plaza", 8);
        Address a7 = new Address(7, "Bucuresti", "Afi", 8);
        Address a8 = new Address(8, "Bucuresti", "Militari", 8);
        Address a9 = new Address(9, "Bucuresti", "Pipera", 8);

        Student s1 = new Student(1, "Alex", "Rus", 15, a1, true, 1);
        Student s2 = new Student(2, "Mihaela", "Popescu", 16, a2, true, 2);
        Student s3 = new Student(3, "Mihai", "Enescu", 18, a3, true, 1);
        Student s4 = new Student(4, "Luca", "Dinescu", 15, a4, false, 1);
        Student s5 = new Student(5, "Maria", "Rus", 17, a1, false, 2);
        Student s6 = new Student(6, "Smaranda", "Gherghe", 15, a9, true, 1);
        Student s7 = new Student(7, "Marius", "Tamas", 16, a4, true, 2);
        Student s8 = new Student(8, "Adrian", "Ifrim", 18, a8, true, 1);
        Student s9 = new Student(9, "Luca", "Olteanu", 15, a6, false, 2);
        Student s10 = new Student(10, "Sonia", "Gabureanu", 17, a5, false, 2);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        students.add(s10);
        adresses.add(a1);
        adresses.add(a2);
        adresses.add(a3);
        adresses.add(a4);
        adresses.add(a5);
        adresses.add(a6);
        adresses.add(a7);
        adresses.add(a8);
        adresses.add(a9);

        Vector<Student> vec1 = new Vector<Student>();
        Vector<Student> vec2 = new Vector<Student>();
        vec1.add(s1);
        vec1.add(s3);
        vec1.add(s4);
        vec1.add(s6);
        vec1.add(s8);
        vec2.add(s2);
        vec2.add(s5);
        vec2.add(s7);
        vec2.add(s9);
        vec2.add(s10);
        Profile p1 = new Profile(1, "Stiintele Naturii");
        Profile p2 = new Profile(2, "Matematica - Informatica");
        Clasa cl1 = new Clasa(1, 241, vec1, p1);
        Clasa cl2 = new Clasa(2, 341, vec2, p2);
        classes.add(cl1);
        classes.add(cl2);
    }

    public void showClasses() {
        System.out.println(" ");
        System.out.println("Clasele din scoala sunt: ");

        for (Integer i = 0; i < classes.size(); i++) {
            System.out.println("Clasa cu id-ul " + classes.get(i).getId_class() + " si numarul " + classes.get(i).getNumber() + " cu elevii: ");
            classes.get(i).AfisareStudenti();
        }
    }

    public void showBursa() {
        System.out.println("");
        System.out.println("Lista cu elevii care au obtinut bursa este: ");
        for (Integer i = 0; i < students.size(); i++) {
            if (students.get(i).isScholarship() == true) {
                System.out.println(students.get(i).getFirstname() + " " + students.get(i).getLastname());
            }
        }
    }

    public void orderProf() {
        Professor aux = new Professor();

        for (Integer i = 0; i < professors.size(); i++) {
            for (Integer j = i + 1; j < professors.size(); j++) {
                if (professors.get(i).getExperience() < professors.get(j).getExperience()) {
                    aux = professors.get(i);
                    professors.set(i, professors.get(j));
                    professors.set(j, aux);
                }
            }
        }
        showProfessors();
    }

    public void studentAdresa() {
        Scanner scan = new Scanner(System.in);
        showStudents();
        Integer ok = 1;
        Integer idst = scan.nextInt();
        Address adresa = new Address();
        for (Integer i = 0; i < students.size(); i++) {
            if (idst == students.get(i).getId_person()) {
                adresa = students.get(i).getAdresa();
                ok = 0;
            }
        }
        if (ok == 0) {
            System.out.println("Adresa studentului selectat este strada " + adresa.getStreet() + ",numarul " + adresa.getNumber() + ", " + adresa.getCity());
        }else{
            System.out.println("Nu exista un student cu codul pe care l-ati introdus");
        }
    }
}
