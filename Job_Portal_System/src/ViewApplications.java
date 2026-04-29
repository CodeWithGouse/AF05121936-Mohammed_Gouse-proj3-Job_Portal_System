import java.sql.*;
public class ViewApplications {
    public static void execute(int uid){
        try(Connection con=DBConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM applications WHERE user_id=?");
            ps.setInt(1,uid);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("Job ID: "+rs.getInt("job_id"));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
}
