package chat.utils;

import chat.ChatMsg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeletedMessagePrinter {
    public void print(ChatMsg message, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.append(message.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
