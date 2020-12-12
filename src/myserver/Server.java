package myserver;

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
import java.util.ArrayList;

import com.javaex.ex02.DigitImpl;
import com.javaex.ex02.UpperImpl;

public class Server extends Thread{
	static ArrayList<Socket> list = new ArrayList<Socket>();
	static Socket socket;
	
	public Server(Socket socket) {
		this.socket = socket;
		list.add(socket);
	}
	
	public void run() {
		System.out.println("[클라이언트"+ socket.getPort()+"님이 연결됨]");
		
		try {
			//받기용 stream
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
		
			//보내기용 stream
			OutputStream os = socket.getOutputStream();
			
			
			while(true) {
				String str = br.readLine();
				System.out.println(str);
				
				for(int i = 0; i < list.size();i++) {
					
					os = list.get(i).getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
					BufferedWriter bw = new BufferedWriter(osw);
					bw.write(str + list.size());
					bw.newLine();
					bw.flush();
					
				
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("<서버시작>");
		System.out.println("======================================");
		
		ServerSocket serverSocket = new ServerSocket();
		
		serverSocket.bind(new InetSocketAddress("192.168.0.8", 10001));
		int count = 0;
		while(true) {
					
			Socket socket = serverSocket.accept();
			
			Thread thread = new Server(socket);
			thread.start();
			
			count++;
			System.out.println();
			if(count > 3) {
				break;
			}
		}
		System.out.println("꽉차서 꺼졌엉ㅎㅎ");

	}
}
