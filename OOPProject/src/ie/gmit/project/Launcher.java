/**
 * 
 */
package ie.gmit.project;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jamieosullivan
 *
 */
public class Launcher {
	
	public void Launch(String f1, String f2) {
		int blockingQueueSize = 5;
		int shingleSize = 5;
		int k = 10;
		int poolSize = 100;
		
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>(blockingQueueSize);

		
		Thread t1 = new Thread(new DocumentParser(f1, q, shingleSize, k ), "T1");
		Thread t2 = new Thread(new DocumentParser(f2, q, shingleSize, k), "T2");
		Thread t3 = new Thread(new Consumer(q, k, poolSize), "T3");

		t1.start();
		t2.start();
		t3.start();
		
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	

}
