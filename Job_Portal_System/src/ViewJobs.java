import java.sql.*;
public class ViewJobs {
    public static void execute(){
        try(Connection con=DBConnection.getConnection()){
            ResultSet rs=con.createStatement().executeQuery("SELECT * FROM jobs");
            while(rs.next()){
                System.out.println(rs.getInt("job_id")+" "+rs.getString("title")+" "+rs.getString("company"));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
}
