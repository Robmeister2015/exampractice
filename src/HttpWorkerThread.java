import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


public class HttpWorkerThread extends Thread{

	BlockingQueue<Socket> queue;
	
	String[] firstSplit
	
	public HttpWorkerThread(BlockingQueue<Socket> b){
		this.queue = b;
	}
	
	public void run(){
		Socket s;
		while(true){
			try {
			s = queue.take();
			
			InputStream in = s.getInputStream();
			Scanner sc = new Scanner(in);
			
			OutputStream o = s.getOutputStream();
			PrintWriter p = new PrintWriter(o);
			
			String request = sc.next();
			
			if(request.contains("GET")){
				
			}
			} catch (InterruptedException | IOException e) {
				System.out.println("Queue failure!");
				e.printStackTrace();
			}
			
			
		}
	}
}
