package com.apisero;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
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
			PreparedStatement st = con.prepareStatement("update employee set FirstName = ? , LastName = ? , Address = ? where EmpId = ?");
			st.setString(1,firstname);
			st.setString(2,lastname);
			st.setString(3,address);
			st.setString(4,id);
			int rowCount = st.executeUpdate();
			if(rowCount > 0) {
				out.println("\n\nData Updated Successfully\n");
			}
			else {
				out.println("\n\nUnable To Update Data\n");
			}
			st.close();
			con.close();
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
