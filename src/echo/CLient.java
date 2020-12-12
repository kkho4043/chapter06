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
		
		System.out.println("<Ŭ���̾�Ʈ ����>");
		System.out.println("======================");
		System.out.println("[�����û��]");
		
		socket.connect(new InetSocketAddress("192.168.0.8", 10001));
		System.out.println("������ �����.");
		//�޼��� ������ stream
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		

		//�޼��� �ޱ� stream
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//��ĳ��
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("�޼����Է� :");
			String str = sc.nextLine();
			
			if("/q".equals(str)) { //str�� null�϶�.
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
		System.out.println("=================\n<Ŭ���̾�Ʈ ����>");
		socket.close();
	}
}
