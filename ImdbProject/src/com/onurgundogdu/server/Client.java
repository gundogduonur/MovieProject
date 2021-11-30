package com.onurgundogdu.server;

import java.io.*;
import java.net.*;

public class Client {
	public Object run(String searchKey) {
		Object tempList = null;
		try (Socket socket = new Socket("localhost", 3566)) {
			
			System.out.println("Ready server.");
			
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(searchKey);
			
			tempList = objectInputStream.readObject();
			
			System.out.println("Received Message.");
			Thread.sleep(2000);
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
		return tempList;
		
	}
}
