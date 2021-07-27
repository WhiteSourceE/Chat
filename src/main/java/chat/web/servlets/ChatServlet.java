package chat.web.servlets;

import chat.ChatData;
import chat.ChatMsg;
import chat.ChatRoom;
import chat.utils.Constants;
import chat.utils.MessagesPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/Chat")
public class ChatServlet extends AbstractChatServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!assertUserPresent(req, resp)) {
			return;
		}
		String name=(String)getAttrib(req, "chat");
		if (name==null) {
			name=(String)getAttrib(req, "name");
		}
		if (name==null) {
			req.getRequestDispatcher("/Chat.jsp")
			.forward(req, resp);
			return;
		}
		if(!getChatData().hasChat(name)) {
			req.getRequestDispatcher("/Chat.jsp").forward(req, resp);
			return;
		}
		
		req.setAttribute("chat", name);
		PrintWriter writer = resp.getWriter();
		ChatData chatData = getChatData();
		new MessagesPrinter().printMessages(writer,chatData,name);
		//req.getRequestDispatcher("/Chat.jsp").forward(req, resp);
		return;
	}
}
