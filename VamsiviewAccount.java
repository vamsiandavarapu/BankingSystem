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
 * Servlet implementation class VamsiviewAccount
 */
@WebServlet("/VamsiviewAccount")
public class VamsiviewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VamsiviewAccount() {
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

        try {
            // Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

            // Fetch user account data from "accounts" table
            java.sql.Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery(
                    "SELECT first_name, last_name, email, account_type, mobile, dob FROM accounts");

            // Start HTML Page
            out.println("<html><head>");
            out.println("<title>Vamsi's International Bank - Accounts</title>");
            out.println("<style>");
            out.println("body{margin:0;font-family:Arial,sans-serif;background:#0d1b2a;color:white;}");
            out.println("header{background:#1b263b;padding:10px;text-align:center;color:#00d4ff;}");
            out.println("table{margin:30px auto;border-collapse:collapse;width:80%;}");
            out.println("table, th, td{border:1px solid #00d4ff;padding:10px;text-align:center;}");
            out.println("th{background:#1e3d59;color:#00d4ff;}");
            out.println("tr:nth-child(even){background:#13293d;}");
            out.println(".btn{padding:10px 20px;margin:5px;border:none;border-radius:5px;cursor:pointer;font-weight:bold;}");
            out.println(".btn-view{background:#00d4ff;color:#000;}");
            out.println(".btn-delete{background:#ff4d4d;color:white;}");
            out.println(".btn-update{background:#ffaa00;color:black;}");
            out.println("</style>");
            out.println("</head><body>");

            out.println("<header><h1>Vamsi's International Bank</h1></header>");
            out.println("<center><h2>Account Holders</h2></center>");

            // Table of accounts
            out.println("<table>");
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Account Type</th><th>Mobile</th><th>DOB</th></tr>");

            while (r.next()) {
                out.println("<tr>");
                out.println("<td>" + r.getString("first_name") + "</td>");
                out.println("<td>" + r.getString("last_name") + "</td>");
                out.println("<td>" + r.getString("email") + "</td>");
                out.println("<td>" + r.getString("account_type") + "</td>");
                out.println("<td>" + r.getString("mobile") + "</td>");
                out.println("<td>" + r.getString("dob") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            // Action buttons
            out.println("<center>");
            out.println("<form action='Bank.html' method='post'>"
                    + "<input type='submit' class='btn btn-update' value='Home'></form>");
            out.println("<form action='VamsiDeleteAccount' method='post'>"
                    + "<input type='submit' class='btn btn-delete' value='Delete'></form>");
            out.println("<form action='login.html'>"
                    + "<input type='submit' class='btn btn-view' value='Login'></form>");
            out.println("</center>");

            out.println("</body></html>");

            con.close();

        } catch (Exception e) {
            out.println("<h2 style='color:red;text-align:center;'>Error: " + e.getMessage() + "</h2>");
        }
    }
	}


