import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws IOException{
		
		System.out.println("Do POST or GET?");
		System.out.println("Type 'P' for POST");
		System.out.println("Type 'G' for GET");
		
		Scanner inputScanner = new Scanner(System.in);
		String choice = inputScanner.next();
		
		InetAddress inet = InetAddress.getLocalHost();
		
		Socket s = new Socket(inet, 2001);
		
		OutputStream o = s.getOutputStream();
		PrintWriter p = new PrintWriter(o);
		
		InputStream in = s.getInputStream();
		Scanner sc = new Scanner(in);
		
		if(choice.equals("P")){
			p.println("POST myServlet");
			p.println("name=Robin&address=Athlone");
			p.flush();
		}else if(choice.equals("G")){
			p.println("./test.txt");
			p.flush();
		}
		
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}
}
