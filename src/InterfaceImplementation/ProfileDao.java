package InterfaceImplementation;

import java.sql.*;
import java.util.*;
import Model.*;
public interface ProfileDao {
    public int add(Profile prof) throws SQLException;

    public void delete(int id) throws SQLException;

    public Profile getProfile(int id) throws SQLException;
    public void update(Profile prof) throws SQLException;

}
