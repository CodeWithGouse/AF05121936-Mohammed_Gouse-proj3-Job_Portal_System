import java.sql.*;import java.util.Scanner;
public class ApplyJob {
    public static void execute(Scanner sc,int uid){
        try(Connection con=DBConnection.getConnection()){
            System.out.print("Job ID: ");int jid=sc.nextInt();
            PreparedStatement ps=con.prepareStatement("INSERT INTO applications(user_id,job_id,status) VALUES(?,?,?)");
            ps.setInt(1,uid);ps.setInt(2,jid);ps.setString(3,"Applied");
            ps.executeUpdate();System.out.println("Applied!");
        }catch(Exception ex){ex.printStackTrace();}
    }
}
