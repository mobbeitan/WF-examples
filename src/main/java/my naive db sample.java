import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class SQLInjectionExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db");
            String var = request.getParameter("username");

            String query = "SELECT * FROM users WHERE username = '" + user + "';";
            Statement stmt = con.createStatement();


            
            String queryss = "string" + var;
            String querys = "string" + var + "string";
            String.format("string = '%s';", var);
            "SELECT * FROM users WHERE username = '".concat(var).concat("';");

            stmt.executeQuery(query);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}