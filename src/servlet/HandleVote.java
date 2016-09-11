package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class HandleVote
 */
@WebServlet("/HandleVote")
public class HandleVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleVote() {
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
		System.out.println("HandleVote.doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HandleVote.doPost()");

		Dao db = new Dao();

		String vote_type = request.getParameter("type");
		String Svote_id = request.getParameter("id");
		int vote_id = Integer.parseInt(Svote_id);

		try {

			db.updateVote(vote_id, vote_type);

		} catch (Exception e) {
			// TODO: handle exception
		}

		String jsp = "/vote.jsp";

		RequestDispatcher dp = getServletContext().getRequestDispatcher(jsp);
		dp.forward(request, response);

	}

}
