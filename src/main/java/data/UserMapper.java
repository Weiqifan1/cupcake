package data;

// import control.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 4, 2017 
 */
public class UserMapper {    
    // 2017-09-18
    public List<String> getAllUsers() throws SQLException{ //return list of strings
        String sql = "SELECT subject FROM opskrift.tasks";
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<String> users = new ArrayList();
        while(rs.next()){
            String username = rs.getString("subject");
            
            users.add(username);
        }
        return users;
    }
    public static void main(String[] args) throws SQLException {
        List<String> users = new UserMapper().getAllUsers();
        for (String user : users) {
            System.out.println(user);
        }
    }
}
