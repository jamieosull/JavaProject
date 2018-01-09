/**
 * 
 */
package ie.gmit.project;

import java.io.*;
import java.util.*;

/**
 * @author jamieosullivan
 *
 */
public class Menu extends Runner {
	
	
	@SuppressWarnings("resource")
	public static void menuOptions() {
		Scanner scanner = new Scanner(System.in);
		
		String file1String = null;
	    String file2String = null;
	    
	 // File variables
    	File file1 = new File(file1String);
    	File file2 = new File(file2String);
    	
    	

    	System.out.println("========================================================");
    	System.out.println(" Welcome to the Measuring Document Similarity Applicaton");
    	System.out.println("=========================================================");

    	//DelBelloGallico.txt
    	System.out.println("Please enter the filename of file 1 (.txt): ");
     	file1String = ("Files/" + scanner.next() +".txt");
	
     	//WarAndPace-LeoTolstoy.txt
     	System.out.println("Please enter the filename of file 2: ");
    	file2String = ("Files/" + scanner.next() +".txt");

   
   
		
		

	}
}
