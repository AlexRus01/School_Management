package InterfaceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.*;
import java.util.*;
import java.sql.*;

public class AdressDaoImplementation implements AdressDao{
    static Connection con = Database.DbConnection.getConnection();

    @Override
    public int add(Address adresa)
    throws SQLException{
        String query = "INSERT INTO `alexbaza`.`address`\n" +
                "(`id_address`,\n" +
                "`city`,\n" +
                "`street`,\n" +
                "`number`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?);";
        PreparedStatement ps = con.prepareStatement(query);
        String query2 = "select id_address from address";
        Statement st = con.createStatement();
        ResultSet a = st.executeQuery(query2);

        Vector<Integer> Ids = new Vector<Integer>();

        while(a.next()){
            Ids.add(a.getInt(1));
        }
        Integer maxv = -1;
        for (int i=0;i<Ids.toArray().length;i++){
            if(Ids.get(i) > maxv){
                maxv = Ids.get(i);
            }
        }
        ps.setInt(1,maxv+1);
        ps.setString(2,adresa.getCity());
        ps.setString(3,adresa.getStreet());
        ps.setInt(4,adresa.getNumber());

        Integer n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException
    {
        String query = "delete from address where id_address = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }


    @Override
    public Address getAddress(int id) throws SQLException
    {
        String query = "select * from address where id_address = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        Address adresa = new Address();
        ResultSet rs = ps.executeQuery();

        boolean check = false;

        while(rs.next()){
            check = true;
            adresa.setId_address(rs.getInt("id_address"));
            adresa.setCity(rs.getString("city"));
            adresa.setStreet(rs.getString("street"));
            adresa.setNumber(rs.getInt("number"));
        }

        if (check == true){
            return adresa;
        }else{
            return null;
        }
    }

    @Override
    public void update(Address ad)
        throws SQLException
    {
        String query = "UPDATE address set street = ? where id_address = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, ad.getStreet());
        ps.setInt(2,ad.getId_address());

        ps.executeUpdate();
        System.out.println("Strada a fost schimbata cu succes");
    }


}
