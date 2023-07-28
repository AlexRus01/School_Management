package InterfaceImplementation;

import Model.Subject;

import java.sql.SQLException;
import java.util.*;

public interface SubjectDao {
    public int add(Subject sub)
        throws SQLException;


    public void delete(int id)
        throws  SQLException;

    public Subject getSubject(int id)
        throws SQLException;


    public void update(Subject emp)
        throws  SQLException;


}
