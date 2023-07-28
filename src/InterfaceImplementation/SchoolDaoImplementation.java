package InterfaceImplementation;

import java.sql.*;
import java.util.*;

import InterfaceImplementation.SchoolDao;
import Model.School;
import Model.School;

public class SchoolDaoImplementation implements SchoolDao{
    static Connection con = Database.DbConnection.getConnection();

    @Override
    public int add(School scoala)
            throws SQLException
    {
        String query
                = "INSERT INTO `alexbaza`.`school`\n" +
                "(`id_school`,\n" +
                "`name`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?);\n";

        String query2 = "select id_school from school";
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
        ps.setString(2, scoala.getName());

        Integer n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(Integer id) throws SQLException
    {
        String query = "delete from school where id_school = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public School getSchool(int id) throws SQLException
    {
        String query = "select * from school where id_school = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        School scol = new School();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while(rs.next()){
            check = true;
            scol.setName(rs.getString("name"));
            scol.setId_school(rs.getInt("id_school"));
        }
        if (check == true){return scol;
        }else{
            return null;
        }
    }

    @Override
    public void update(School scol) throws SQLException{
        String query = "update school set name = ? where id_school = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1,scol.getName());
        ps.setInt(2,scol.getId_school());

        ps.executeUpdate();
        System.out.println("Scoala a fost schimbata cu succes");
    }
}
