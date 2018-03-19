package mum.wap.game.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class Solver
 */
@WebServlet("/Solver")
public class Solver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameService gameService;
    /**
     * Default constructor. 
     */
    public Solver() {
        // TODO Auto-generated constructor stub
    		gameService = new GameService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int guessMe = (Integer.parseInt(request.getParameter("guessMe")));
		gameService.setNumberToGuess(guessMe);
		JSONObject results = gameService.solveIt();
	
		PrintWriter out = response.getWriter();
		out.print(results);
		out.flush();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
