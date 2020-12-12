package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket();
		
		serverSocket.bind(new InetSocketAddress("192.168.0.8", 10001));
		
		System.out.println("<서버시작>");
		System.out.println("======================================");
		System.out.println("[연결 대기중]");
		
		Socket socket = serverSocket.accept();
		
		System.out.println("[클라이언트 연결됨]");
		//메세지 받기stream
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기 stream
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		while(true) {
			String msg  = br.readLine();
			if(msg == null) {
				break;
			}
			
			System.out.println(msg);
			
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		
		
		
		br.close();
		bw.close();
		System.out.println("=================\n<서버 종료>");
		serverSocket.close();
		

	}
}
