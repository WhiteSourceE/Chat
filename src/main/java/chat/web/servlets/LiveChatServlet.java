package chat.web.servlets;

import chat.utils.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LiveChatServlet
 */
@WebServlet("/LiveChat")
public class LiveChatServlet extends AbstractChatServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   if (!assertUserPresent(req, resp)) {
			return;
		}
	   req.getRequestDispatcher("/LiveChat.jsp").forward(req, resp);
   }

}
