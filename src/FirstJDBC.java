import java.sql.*;
class Hello{
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/s1","root","raj");
            Statement stmt=con.createStatement();


            PreparedStatement stmt1=con.prepareStatement("insert into stud values(?,?,?)");
            stmt1.setInt(1,21);
            stmt1.setString(2,"rajjj");
            stmt1.setString(3,"989568971");
            PreparedStatement stmt2=con.prepareStatement("update stud set name=? where rollno=?");
            stmt2.setString(1,"sono");
            stmt2.setInt(2,8);
            int i=stmt1.executeUpdate();
                System.out.println(i+"record updated successfully");
            int i1=stmt2.executeUpdate();
            System.out.println(i1+"record updated successfully");
            PreparedStatement stmt3=con.prepareStatement("delete from stud where rollno=?");
            stmt3.setInt(1,20);
            int i2=stmt3.executeUpdate();
            System.out.println(i2+"record updated successfully");
            ResultSet rs=stmt.executeQuery("select * from stud");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

            con.close();
        }catch(Exception e){System.out.println(e);}
    }
}
