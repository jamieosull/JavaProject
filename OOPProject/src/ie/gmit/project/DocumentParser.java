package ie.gmit.project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class DocumentParser implements Runnable {

	private BlockingQueue<Shingle> queue;
	private String file;
	private int shingleSize, k;
	private Deque<String> buffer = new LinkedList<>();
	private int doc1;
	private int doc2;

	/*public DocumentParser(String file, BlockingQueue<Shingle> q, int shingleSize, int k) {
		this.queue = q;
		// InputStringReader
	}*/
	

	/**
	 * @param queue
	 * @param file
	 * @param shingleSize
	 * @param k
	 */
	public DocumentParser(BlockingQueue<Shingle> queue, String file, int shingleSize, int k) {
		super();
		this.queue = queue;
		this.file = file;
		this.shingleSize = shingleSize;
		this.k = k;
	}


	public void run() {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String line = "";

		try {
			while ((line = br.readLine()) != null) {
				String uLine = line.toUpperCase();
				String[] words = uLine.split(" "); // Can also take a regexpression
				addWordsToBuffer(words);
				Shingle s = getNextShingle();
				queue.put(s); // Blocking method. Add is not a blocking method

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flushBuffer();
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addWordsToBuffer(String[] words) {

		for (String s : words) {
			buffer.add(s);

		}

	}

	private Shingle getNextShingle() {
		StringBuffer sb = new StringBuffer();
		int counter = 0;
		while (counter < shingleSize) {
			if (buffer.peek() != null) {
				sb.append(buffer.poll());
				counter++;
			} // if
		} // while
		if (sb.length() > 0) {
			return (new Shingle(doc1, doc2, sb.toString().hashCode()));
		} // if
		else {
			return (null);
		} // else if

	}// getNextShingle

	private void flushBuffer() {
		while (buffer.size() > 0) {
			Shingle s = getNextShingle();
			if (s != null) {
				try {
					queue.put(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					queue.put(new Poison(doc1, doc2, 0));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}// Flush buffer

}// Document Parser
