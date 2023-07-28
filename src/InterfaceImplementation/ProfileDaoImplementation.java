package InterfaceImplementation;
import Model.*;
import java.util.*;
import java.sql.*;
public class ProfileDaoImplementation implements ProfileDao{

    static Connection con = Database.DbConnection.getConnection();
    @Override
    public int add(Profile prof) throws SQLException
    {
        String query = "INSERT INTO `alexbaza`.`profile`\n" +
                "(`id_profile`,\n" +
                "`name`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?);\n";
        String query2 = "select id_profile from profile";
        Statement st = con.createStatement();
        ResultSet a = st.executeQuery(query2);
        Integer maxv = 0;
        Vector<Integer> vec = new Vector<Integer>();
        while(a.next()){
            vec.add(a.getInt("id_profile"));
        }
        for(Integer i=0;i<vec.toArray().length;i++){
            if (vec.get(i) > maxv){
                maxv = vec.get(i);
            }
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, maxv + 1);
        ps.setString(2, prof.getName());
        Integer n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException
    {
        String query = "delete from profile where id_profile = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public Profile getProfile(int id) throws SQLException {
        String query = "select * from profile where id_profile = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        Profile pub = new Profile();
        ResultSet rs = ps.executeQuery();

        boolean check = false;
        while(rs.next()){
            check = true;
            pub.setName(rs.getString("name"));
            pub.setId_profile(rs.getInt("id_profile"));
        }
        if (check == true){
            return pub;
        }
        else{
            return null;
        }
    }

    @Override
    public void update(Profile prof) throws SQLException
    {
        String query = "update profile set name = ? where id_profile = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1,prof.getName());
        ps.setInt(2,prof.getId_profile());

        ps.executeUpdate();
        System.out.println("Profilul a fost schimbat cu succes");
    }
}
