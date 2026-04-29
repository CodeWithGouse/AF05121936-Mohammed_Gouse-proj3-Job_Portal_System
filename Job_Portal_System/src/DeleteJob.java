import java.sql.*;import java.util.Scanner;
public class DeleteJob {
    public static void execute(Scanner sc){
        try(Connection con=DBConnection.getConnection()){
            System.out.print("Job ID: ");int id=sc.nextInt();
            PreparedStatement ps=con.prepareStatement("DELETE FROM jobs WHERE job_id=?");
            ps.setInt(1,id);ps.executeUpdate();
            System.out.println("Deleted!");
        }catch(Exception ex){ex.printStackTrace();}
    }
}
