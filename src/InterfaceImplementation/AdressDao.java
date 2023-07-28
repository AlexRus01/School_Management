package InterfaceImplementation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.*;
import java.util.*;

public interface AdressDao {
    public int add(Address adress)
        throws SQLException;

    public void delete(int id)
        throws SQLException;

    public Address getAddress(int id) throws SQLException;

    public void update(Address ad)
        throws SQLException;


}
