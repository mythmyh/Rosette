package com.chen.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.URLDecoder;

@ServerEndpoint("/websocketTest")
public class WebSocketTest {
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {

		// Print the client message for testing purposes
		// System.out.println("Received: " + message);

		// Send the first message to the client
		message = URLDecoder.decode(message, "utf-8");


		session.getBasicRemote().sendText(message);

		try {
			Juicy jx = new Juicy(session);
			jx.transformer();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Send 3 messages to the client every 5 seconds
		// int sentMessages = 7;
		// while (sentMessages < 13) {
		// Thread.sleep(5000);
		// session.getBasicRemote().sendText("<div data-id=\""+
		// sentMessages+"\">"+sentMessages+"</div");
		// sentMessages++;
		// }

	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected+1");
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
}