package utilities;

import java.sql.*;

public class SQLConnect {
    public static Connection connect() throws SQLException {
        Connection conn = null;
        // db parameters
        String url = "jdbc:sqlite:C:\\Users\\nadezda_gavronova\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
        // create a connection to the database
        return conn = DriverManager.getConnection(url);
    }


    public static void main(String[] args) throws SQLException {
        Connection connection = connect();
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM Artist");
//
//        while (rs.next()) {
//            //Display values
//            System.out.print("ID: " + rs.getInt("ArtistId"));
//            System.out.print(", Name: " + rs.getString("Name"));
//            System.out.println("\n");

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer \n" +
                "ORDER BY CustomerId  \n" +
                "DESC LIMIT 1;");

        while (rs.next()) {
            //Display values
            System.out.print("CustomerId: " + rs.getInt("CustomerId"));
            System.out.print(", Name: " + rs.getString("FirstName"));
            System.out.print(", Surname: " + rs.getString("LastName"));
            System.out.println("\n");
        }
    }

}
