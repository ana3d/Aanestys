package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Vote;
import dao.Dao;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Add.doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Add.doPost()");
		String jsp = "/vote.jsp";
		Dao db = new Dao();
		Vote vote = new Vote();

		String subject = request.getParameter("subject");

		vote.setSubject(subject);
		vote.setCount(0);
		vote.setVote_no(0);
		vote.setVote_yes(0);

		try {

			if (vote.getSubject().length() > 1) {
				db.lisaaAanestys(vote);
			}

			RequestDispatcher dp = getServletContext()
					.getRequestDispatcher(jsp);
			dp.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
