package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Second
 */
@WebServlet("/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Second() {
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
		//Getting and displaying values of context int parameters to console.
		ServletContext context = this.getServletContext();
		System.out.println("Now we are in Second servlet....."
				+ "\nValue of applications context parameter viz. bestJavaInstitute is "+context.getInitParameter("bestJavaInstitute"));
		PrintWriter out = response.getWriter();//Here we are using this object to write the response 
		//to client's browser. Please note that this is not at all a way to display output in the real
		//world application we are doing this only for serve the purpose of learning the concept of attributes.
		//In real world application various view technologies viz jsp etc. are used to display data to user which we learn
		//in coming lectures.
		String requestAttribute = (String) request.getAttribute("requestAttribute");  //getting attribute from request scope
        out.println("<br />Value of request attribute is "+requestAttribute);  // Prints : Value of context attribute is RequestAttribute   
        ServletContext sc = getServletContext();
        String contextAttribute = (String) sc.getAttribute("contextAttribute");  //getting attribute from context scope
        out.println("<br /><br />Value of context attribute is "+contextAttribute);  // Prints : Value of context attribute is ContextAttribute  
        HttpSession session = request.getSession();
        String sessionAttribute = (String) session.getAttribute("sessionAttribute");  //getting attribute from session scope
        out.println("<br /><br />Value of session attribute is "+sessionAttribute);  // Prints : Value of context attribute is SessionAttribute   
	}

}
