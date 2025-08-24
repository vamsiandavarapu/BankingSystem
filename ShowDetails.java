package BankUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDetails
 */
@WebServlet("/ShowDetails")
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT * FROM accounts WHERE email='" + email + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='ISO-8859-1'>");
                out.println("<title>Account Details</title>");
                out.println("<style>");
                out.println("body{margin:0;font-family:Arial,sans-serif;background-image:url('https://i.pinimg.com/originals/72/c0/55/72c05566763a3d799eae1928879e6f78.jpg');background-size:cover;color:white;}");
                out.println("header{background-color:rgba(31,40,51,1);color:rgba(102,252,241,0.8);text-align:center;padding:10px;}");
                out.println(".content{margin-left:8%;padding:20px;text-align:center;}");
                out.println(".card{background-color:rgba(0,0,0,0.6);padding:20px;border-radius:10px;display:inline-block;}");
                out.println("input[type=submit]{padding:10px 20px;border:none;border-radius:4px;background-color:rgba(102,252,241,0.8);color:black;font-weight:bold;cursor:pointer;}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<header><h1>Vamsi's International Bank</h1></header>");
                out.println("<div class='content'>");
                out.println("<h2>Welcome, " + rs.getString("first_name") + "!</h2>");
                out.println("<div class='card'>");
                out.println("<p><b>Name:</b> " + rs.getString("last_name") + "</p>");
                out.println("<p><b>Email:</b> " + rs.getString("email") + "</p>");
                out.println("</div>");
                out.println("<br><form action='Login.html'><input type='submit' value='Logout'></form>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } else {
                response.sendRedirect("Login.html"); // redirect back if wrong credentials
            }

            con.close();
        } catch(Exception e) {
            out.println("<h3 style='color:red;text-align:center;'>Error: " + e.getMessage() + "</h3>");
        }
	}
	

}
