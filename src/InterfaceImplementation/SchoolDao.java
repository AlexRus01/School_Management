package InterfaceImplementation;
import Model.School;
import java.sql.*;
import java.util.*;
public interface SchoolDao {
    public int add(School school) throws SQLException;

    public void delete(Integer id) throws SQLException;

    public School getSchool(int id) throws SQLException;

    public void update(School scol) throws SQLException;
}
