package BankUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VamsiDeleteAccount
 */
@WebServlet("/VamsiDeleteAccount")
public class VamsiDeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VamsiDeleteAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset='ISO-8859-1'>");
	        out.println("<title>Vamsi's International Bank</title>");
	        out.println("<style>");
	        out.println("body{margin:0;font-family: Arial, sans-serif;background-image: url('https://i.pinimg.com/originals/72/c0/55/72c05566763a3d799eae1928879e6f78.jpg');background-size: cover;background-position: center;background-repeat: no-repeat;background-attachment: fixed;color: white;}");
	        out.println("header{background-color:rgba(31, 40, 51, 1);color:rgba(102, 252, 241, 0.8);text-align:center;padding:10px;}");
	        out.println("nav{padding:10px;background-color:rgba(11, 12, 16, 1);width:100%;}");
	        out.println("nav a{display:inline-block;margin:5px;padding:12px 50px;font-size:10px;font-weight:bold;text-decoration:none;color:rgba(102, 252, 241, 0.9);background-color: rgba(31,40,51,0.9);border:2px solid rgba(102,252,241,0.6);border-radius:4px;transition: all 0.3s ease;cursor:pointer;}");
	        out.println("nav a:hover{color:white;}");
	        out.println("aside{background-color:rgba(11,12,16,1);width:6%;height:200%;position:fixed;padding-top:20px;}");
	        out.println("aside a{padding:10px 15px;text-decoration:none;color:rgba(102,252,241,0.8);line-height:1.6;}");
	        out.println("footer{text-align:center;bottom:0px;width:100%;position:fixed;background-color:rgba(11,12,16,1);}");
	        out.println(".content{margin-left:8%;padding:20px;text-align:center;}");
	        out.println("input[type=text]{padding:8px;width:250px;border-radius:4px;border:none;}");
	        out.println("input[type=submit]{padding:10px 20px;border:none;border-radius:4px;background-color:rgba(102,252,241,0.8);color:black;font-weight:bold;cursor:pointer;}");
	        out.println("input[type=submit]:hover{background-color:white;}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<header><h1>Vamsi's International Bank</h1></header>");
	        out.println("<nav>");
	        out.println("<a href='Home.html'>Home</a>");
	        out.println("<a href='Login.html'>Login</a>");
	        out.println("<a href='Gallery.html'>Gallery</a>");
	        out.println("<a href='Services.html'>Services</a>");
	        out.println("<a href='FAQ.html'>FAQ</a>");
	        out.println("<a href='createaccount.html'>Apply for Account</a>");
	        out.println("</nav>");
	        out.println("<aside>");
	        out.println("<a href='Donations.html'>Donations</a><br>");
	        out.println("<a href='Loans.html'>Loans</a>");
	        out.println("</aside>");
	        out.println("<div class='content'>");
	        out.println("<h2>Delete Your Account</h2>");
	        out.println("<form action='VamsiDeleteAccount' method='post'>");
	        out.println("Enter Email: <input type='text' name='email' required><br><br>");
	        out.println("<input type='submit' value='Delete Account'>");
	        out.println("</form>");
	        out.println("</div>");
	        out.println("<footer>");
	        out.println("<p>Contact us: <a href='mailto:BankManager@gmail.com'>BankManager@gmail.com</a> / +91 8309639943</p>");
	        out.println("</footer>");
	        out.println("</body>");
	        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String email = request.getParameter("email");

	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

	            PreparedStatement ps = con.prepareStatement("DELETE FROM accounts WHERE email = ?");
	            ps.setString(1, email);

	            int rows = ps.executeUpdate();

	            // Display the same page with deletion result
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<meta charset='ISO-8859-1'>");
	            out.println("<title>Vamsi's International Bank</title>");
	            out.println("<style>");
	            out.println("body{margin:0;font-family: Arial, sans-serif;background-image: url('https://i.pinimg.com/originals/72/c0/55/72c05566763a3d799eae1928879e6f78.jpg');background-size: cover;background-position: center;background-repeat: no-repeat;background-attachment: fixed;color: white;}");
	            out.println("header{background-color:rgba(31, 40, 51, 1);color:rgba(102, 252, 241, 0.8);text-align:center;padding:10px;}");
	            out.println("nav{padding:10px;background-color:rgba(11, 12, 16, 1);width:100%;}");
	            out.println("nav a{display:inline-block;margin:5px;padding:12px 50px;font-size:10px;font-weight:bold;text-decoration:none;color:rgba(102, 252, 241, 0.9);background-color: rgba(31,40,51,0.9);border:2px solid rgba(102,252,241,0.6);border-radius:4px;transition: all 0.3s ease;cursor:pointer;}");
	            out.println("nav a:hover{color:white;}");
	            out.println("aside{background-color:rgba(11,12,16,1);width:6%;height:200%;position:fixed;padding-top:20px;}");
	            out.println("aside a{padding:10px 15px;text-decoration:none;color:rgba(102,252,241,0.8);line-height:1.6;}");
	            out.println("footer{text-align:center;bottom:0px;width:100%;position:fixed;background-color:rgba(11,12,16,1);}");
	            out.println(".content{margin-left:8%;padding:20px;text-align:center;}");
	            out.println("</style>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<header><h1>Vamsi's International Bank</h1></header>");
	            out.println("<nav>");
	            out.println("<a href='Home.html'>Home</a>");
	            out.println("<a href='Login.html'>Login</a>");
	            out.println("<a href='Gallery.html'>Gallery</a>");
	            out.println("<a href='Services.html'>Services</a>");
	            out.println("<a href='FAQ.html'>FAQ</a>");
	            out.println("<a href='createaccount.html'>Apply for Account</a>");
	            out.println("</nav>");
	            out.println("<aside>");
	            out.println("<a href='Donations.html'>Donations</a><br>");
	            out.println("<a href='Loans.html'>Loans</a>");
	            out.println("</aside>");
	            out.println("<div class='content'>");
	            if (rows > 0) {
	                out.println("<h2> Account with email <b>" + email + "</b> deleted successfully!</h2>");
	            } else {
	                out.println("<h2> No account found with email <b>" + email + "</b>.</h2>");
	            }
	            out.println("<br><form action='VamsiDeleteAccount'><input type='submit' value='Back'></form>");
	            out.println("</div>");
	            out.println("<footer>");
	            out.println("<p>Contact us: <a href='mailto:BankManager@gmail.com'>BankManager@gmail.com</a> / +91 8309639943</p>");
	            out.println("</footer>");
	            out.println("</body>");
	            out.println("</html>");

	            con.close();

	        } catch (Exception e) {
	            out.println("<h3 style='color:red; text-align:center;'>Error: " + e.getMessage() + "</h3>");
	        }
	}

}
