package BankUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/VamsiCreate")
public class VamsiCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VamsiCreate() {
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

	        String fname = request.getParameter("firstname");
	        
	        String lname = request.getParameter("lastname");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String accountType = request.getParameter("account");
	        String mob=request.getParameter("phone");
	        String dob=request.getParameter("dob");
	        
	        try {
	         
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	      
	            

	      
	            java.sql.Statement stmt = con.createStatement();

	     
	            String query = "INSERT INTO accounts (first_name, last_name, email, password, account_type, mobile, dob, created_at) " +
                        "VALUES ('" + fname + "',+'" + lname + "', '" + email + "', '" + password + "', '" + accountType + "', '" + mob + "', TO_DATE('" + dob + "', 'YYYY-MM-DD'), SYSDATE)";
	            
	            int result = stmt.executeUpdate(query);

	            if (result > 0) {
	                
	                     out.println("<!DOCTYPE html>");
	                     out.println("<html>");
	                     out.println("<head>");
	                     out.println("<title>Vamsi's International Bank</title>");
	                     out.println("<style>");
	                     out.println("body{margin:0;font-family:Arial,sans-serif;background-image:url('https://i.pinimg.com/originals/72/c0/55/72c05566763a3d799eae1928879e6f78.jpg');background-size:cover;background-position:center;background-attachment:fixed;color:white;}");
	                     out.println("header{background-color:rgba(31,40,51,1);color:rgba(102,252,241,0.8);text-align:center;padding:10px;}");
	                     out.println("nav{padding:10px;background-color:rgba(11,12,16,1);}");
	                     out.println("nav a{display:inline-block;margin:5px;padding:12px 50px;font-size:10px;font-weight:bold;text-decoration:none;color:rgba(102,252,241,0.9);background-color:rgba(31,40,51,0.9);border:2px solid rgba(102,252,241,0.6);border-radius:4px;transition:0.3s;}");
	                     out.println("nav a:hover{color:white;}");
	                     out.println("aside{background-color:rgba(11,12,16,1);width:6%;height:200%;position:fixed;padding-top:20px;}");
	                     out.println("aside a{padding:10px 15px;text-decoration:none;color:rgba(102,252,241,0.8);display:block;}");
	                     out.println("footer{text-align:center;bottom:0;width:100%;position:fixed;background-color:rgba(11,12,16,1);padding:5px;}");
	                     out.println(".center-box{text-align:center;margin-top:100px;background:rgba(0,0,0,0.6);padding:30px;border-radius:10px;display:inline-block;}");
	                     out.println(".center-box h2{color:#00ffcc;}");
	                     out.println(".center-box form{margin:10px;}");
	                     out.println(".center-box input{padding:10px 20px;border:none;border-radius:5px;background:#00d4ff;color:black;font-weight:bold;cursor:pointer;}");
	                     out.println(".center-box input:hover{background:#00aacc;}");
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
	                     out.println("<a href='Donations.html'>Donations</a>");
	                     out.println("<a href='Loans.html'>Loans</a>");
	                     out.println("</aside>");

	                   
	                     out.println("<div style='display:flex;justify-content:center;align-items:center;'>");
	                     out.println("<div class='center-box'>");
	                     out.println("<h2>Account Created Successfully!</h2>");
	                     out.println("<form action='VamsiviewAccount' method='post'><input type='submit' value='View'></form>");
	                     out.println("<form action='VamsiDeleteAccount' method='get'><input type='submit' value='Delete'></form>");
	                     out.println("<form action='VamsiLogin.html'><input type='submit' value='Login'></form>");
	                     out.println("</div>");
	                     out.println("</div>");

	                     out.println("<footer><p>Contact us: <a href='mailto:BankManager@gmail.com'>BankManager@gmail.com</a> / +91 8309639943</p></footer>");
	                     out.println("</body>");
	                     out.println("</html>");
	            } else {
	                out.println("<h2>Failed to create account.</h2>");
	            }

	            con.close();
	        } 
	catch (SQLException e) {
	    if (e.getErrorCode() == 1) { 
	        out.println("<h2>Error: Email or Phone already exists. Please use a different one.</h2>");
	    } else {
	        out.println("<h2>Error: " + e.getMessage() + "</h2>");
	    }
	}
	        catch (Exception e) {
	            out.println("<h2>Error: " + e.getMessage() + "</h2>");
	            e.printStackTrace(out);
	        }

	    }
}


