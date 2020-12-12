package myserver;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMsg extends Thread{
	Socket socket;
	Scanner sc = new Scanner(System.in);
	
	public SendMsg(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(ow);
			while(true) {
				bw.write(sc.nextLine());
				bw.newLine();
				bw.flush();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
