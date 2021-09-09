package com.apisero;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String id = request.getParameter("id");
		String address = request.getParameter("address");
	
		try {
			PrintWriter out = response.getWriter();
			Connection con = CreateConnection.getJDBCConnection();
			PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?,?)");
			st.setString(1,firstname);
			st.setString(2,lastname);
			st.setString(3,id);
			st.setString(4,address);
			int rowCount = st.executeUpdate();
			if(rowCount > 0) {
				out.println("\n\nData Inserted Successfully\n");
			}
			else {
				out.println("\n\nUnable To Inserted Data\n");
			}
			st.close();
			con.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
