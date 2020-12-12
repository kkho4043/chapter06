package myserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

public class TakeMsg extends Thread {
	Socket socket;

	public TakeMsg(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {
			while(true) {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String str = br.readLine();
				System.out.println(str);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
