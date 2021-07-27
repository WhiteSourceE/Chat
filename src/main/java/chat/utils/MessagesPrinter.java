package chat.utils;

import chat.ChatData;
import chat.ChatMsg;
import chat.ChatRoom;

import java.io.PrintWriter;

public class MessagesPrinter {
    public void printMessages(PrintWriter writer, ChatData chatData, String chatName){
        ChatRoom chat = chatData.getChat(chatName);
        ChatMsg[] chatMsgs = chat.getMsgs();
        for (ChatMsg msg :
                chatMsgs) {
            writer.println(msg.getMsg());
        }
    }
}
