import java.sql.*;import java.util.Scanner;
public class RegisterUser {
    public static void execute(Scanner sc){
        try(Connection con=DBConnection.getConnection()){
            System.out.print("Name: ");String n=sc.next();
            System.out.print("Email: ");String e=sc.next();
            System.out.print("Password: ");String p=sc.next();
            System.out.print("Role: ");String r=sc.next();
            PreparedStatement ps=con.prepareStatement("INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)");
            ps.setString(1,n);ps.setString(2,e);ps.setString(3,p);ps.setString(4,r);
            ps.executeUpdate();System.out.println("Registered!");
        }catch(Exception ex){ex.printStackTrace();}
    }
}
