package ie.gmit.project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class DocumentParser implements Runnable {

	private BlockingQueue<Shingle> queue;
	private String file;
	private int shingleSize, k;
	private Deque<String> buffer = new LinkedList<>();
	private int docID;
	
	

	

	/**
	 * @param queue
	 * @param file
	 * @param shingleSize
	 * @param k
	 * @param docID
	 */
	public DocumentParser(BlockingQueue<Shingle> queue, String file, int shingleSize, int k, int docID) {
		super();
		this.queue = queue;
		this.file = file;
		this.shingleSize = shingleSize;
		this.k = k;
		this.docID = docID;
	}

	/*public DocumentParser(String file, BlockingQueue<Shingle> q, int shingleSize, int k) {
		this.queue = q;
		// InputStringReader
	}*/
	
	
	




	public DocumentParser(String f1, BlockingQueue<Shingle> q, int shingleSize2, int k2) {
		// TODO Auto-generated constructor stub
	}

	/*public void run() {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String line = null;

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

	}//run*/
	
	public void parse() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				String lineLower = line.toLowerCase();
				String[] words = lineLower.split("\\s+");
				Shingle s = getNextShingle(); 
				queue.put(s); // blocking call
			}
		}
		flushBuffer();
		br.close();
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
			return (new Shingle(docID, sb.toString().hashCode()));
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
					queue.put(new Poison(docID, hashCode()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}// Flush buffer

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}// Document Parser
