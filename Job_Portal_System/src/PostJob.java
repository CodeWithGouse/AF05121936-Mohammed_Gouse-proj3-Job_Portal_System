import java.sql.*;import java.util.Scanner;
public class PostJob {
    public static void execute(Scanner sc){
        try(Connection con=DBConnection.getConnection()){
            System.out.print("Title: ");String t=sc.next();
            System.out.print("Company: ");String c=sc.next();
            System.out.print("Location: ");String l=sc.next();
            System.out.print("Salary: ");double s=sc.nextDouble();
            PreparedStatement ps=con.prepareStatement("INSERT INTO jobs(title,company,location,salary) VALUES(?,?,?,?)");
            ps.setString(1,t);ps.setString(2,c);ps.setString(3,l);ps.setDouble(4,s);
            ps.executeUpdate();System.out.println("Job Posted");
        }catch(Exception ex){ex.printStackTrace();}
    }
}
