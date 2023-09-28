package database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet
{

    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.postgresql.jdbc.Driver";
        final String DB_URL="jdbc:postgresql://localhost/servlet-jsp";

        //  Database credentials
        final String USER = "developer";
        final String PASS = "dev";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<h1 align = \"center\">" + title + "</h1>\n");
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");

            // Open a connection
             conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
             stmt = conn.createStatement();
            String sql;
            sql = "SELECT \"ID\", \"AGE\", \"FIRST\", \"LAST\" FROM \"SERVLET\".\"Employees\"";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                out.println("ID: " + id + ", Age: " + age + ", First: " + first + ", Last: " + last +"<br>");
              
            }
            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if(stmt!=null)
                    stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                    conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
    }

}
