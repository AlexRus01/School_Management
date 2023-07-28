package InterfaceImplementation;

import java.sql.*;
import java.util.*;

import InterfaceImplementation.SubjectDao;
import Model.Subject;

public class SubjectDaoImplementation implements SubjectDao {
        static Connection con = Database.DbConnection.getConnection();

        @Override
    public int add(Subject sub)
            throws SQLException
        {
            String query
                    = "INSERT INTO `alexbaza`.`subject`\n" +
                    "(`id_subject`,\n" +
                    "`name`)\n" +
                    "VALUES\n" +
                    "(?,\n" +
                    "?);\n";

            String query2 = "select id_subject from subject";
            Statement st = con.createStatement();
            ResultSet a = st.executeQuery(query2);
//            Integer nr = 0;
//            while (a.next()) {
//                  nr = a.getInt(1);
//            }
            Vector<Integer> Ids = new Vector<Integer>();

            while (a.next()){
                Ids.add(a.getInt(1));
            }
            Integer maxv = -1;
            for(int i = 0; i<Ids.toArray().length;i++){
                if(Ids.get(i) > maxv){
                    maxv = Ids.get(i);
                }
            }
            PreparedStatement ps
                    = con.prepareStatement(query);
            ps.setInt(1, maxv + 1);
            ps.setString(2, sub.getName());

            Integer n = ps.executeUpdate();
            return n;
        }

        @Override
    public void delete(int id) throws SQLException
        {
            String query =
                    "delete from subject where id_subject = ?";
            PreparedStatement ps
                    = con.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        }

        @Override
    public Subject getSubject(int id)
            throws SQLException
        {
            String query =
                    "select * from subject where id_subject = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            Subject sub = new Subject();
            ResultSet rs = ps.executeQuery();

            boolean check = false;

            while (rs.next()){
                check = true;
                sub.setName(rs.getString("name"));
                sub.setId_subject(rs.getInt("id_subject"));
            }

            if (check == true){
                return sub;
            }else{
                return null;
            }

        }

        @Override
    public void update(Subject sub)
            throws SQLException
        {
            String query =
                    "update subject set name =? where id_subject = ?";

            PreparedStatement ps
                    = con.prepareStatement(query);

            ps.setString(1, sub.getName());
            ps.setInt(2, sub.getId_subject());

            ps.executeUpdate();
            System.out.println("Subiectul a fost schimbat cu succes");

        }
    }
