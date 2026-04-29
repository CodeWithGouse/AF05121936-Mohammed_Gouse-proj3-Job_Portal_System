import java.sql.*;import java.util.Scanner;
public class SearchJobs {
    public static void execute(Scanner sc){
        try(Connection con=DBConnection.getConnection()){
            System.out.print("Keyword: ");String k=sc.next();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM jobs WHERE title LIKE ? OR location LIKE ?");
            ps.setString(1,"%"+k+"%");ps.setString(2,"%"+k+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("title")+" "+rs.getString("location"));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
}
