package myserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class CLient1 {
	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket();
			
			System.out.println("<Ŭ���̾�Ʈ ����>");
			System.out.println("======================");
			System.out.println("[�����û��]");
			
			socket.connect(new InetSocketAddress("192.168.0.8", 10001));
			System.out.println("������ �����.");
			

			TakeMsg tm = new TakeMsg(socket);
			SendMsg sm = new SendMsg(socket);
			
			sm.start();
			
			
			tm.start();
			
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
