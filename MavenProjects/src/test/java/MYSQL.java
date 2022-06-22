import java.sql.*;

public class MYSQL {
    public static void main(String[] args) throws SQLException {
        //1)-create a connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root");

        //2)-Create a Statement
        Statement stmt = con.createStatement();
        //String insert = "insert into student1 values(66,'Daniel',61);"; // insert command
        //String update = "update student1 set Marks=50 where ID=66;";  //update command
        //String delete = "delete from student1 where Id=15;";  //Delete command
        String select = "select * from cites;";  // select command

        //3)-Execute Query
        //stmt.execute(insert);
        //stmt.execute(update);
        //stmt.execute(delete);

        //3.1)- execute Query and store data into variable
        ResultSet rs = stmt.executeQuery(select);

        while (rs.next()){
            int id = rs.getInt("ID");
            String Name = rs.getString("Name");
            String CountryCode =rs.getString("CountryCode");
            String District =rs.getString("District");
            String Population =rs.getString("Population");
            System.out.println(id+ " " + Name+" "+CountryCode + " "+ District + " " + Population );
        }


        //4)-Close connection
        con.close();

        System.out.println("Query executed......");


    }
}
