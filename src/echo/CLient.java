package echo;

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

public class CLient {
	public static void main(String[] args)throws IOException {
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("======================");
		System.out.println("[연결요청중]");
		
		socket.connect(new InetSocketAddress("192.168.0.8", 10001));
		System.out.println("서버에 연결됨.");
		//메세지 보내기 stream
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		

		//메세지 받기 stream
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("메세지입력 :");
			String str = sc.nextLine();
			
			if("/q".equals(str)) { //str이 null일때.
				break;
			}
			bw.write(str);
			bw.newLine();
			bw.flush();
			
			String reMsg = br.readLine();
			System.out.println("server:["+reMsg+"]");
		}
		
		
		br.close();
		bw.close();
		System.out.println("=================\n<클라이언트 종료>");
		socket.close();
	}
}
