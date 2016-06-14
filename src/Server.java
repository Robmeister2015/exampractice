import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Server {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Socket s;
		ServerSocket ss = new ServerSocket(2001);
		BlockingQueue<Socket> blockingQueue = new ArrayBlockingQueue<Socket>(10);
		
		for(int i = 0; i < 2; i ++){
			
			HttpWorkerThread w = new HttpWorkerThread(blockingQueue);
			w.start();
			
		}
		
		while(true){
			s = ss.accept();
			blockingQueue.put(s);
		}
	}
}
