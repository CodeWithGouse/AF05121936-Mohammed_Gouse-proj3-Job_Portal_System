import java.sql.*;import java.util.Scanner;
public class LoginUser {
    public static int login(Scanner sc){
        try(Connection con=DBConnection.getConnection()){
            System.out.print("Email: ");String e=sc.next();
            System.out.print("Password: ");String p=sc.next();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1,e);ps.setString(2,p);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){System.out.println("Login Success");return rs.getInt("user_id");}
        }catch(Exception ex){ex.printStackTrace();}
        return -1;
    }
}
