/**
 * 
 */
package ie.gmit.project;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jamieosullivan
 *
 */
public class Menu {
	private static String file1;
	private static String file2;
	private static int shingleSize = 50;
	private static int userOption;

	public static void menuOptions() {
		
		/**
		 * displays Menu header
		 * Asks user for files
		 * creates new Launcher with selected files
		 */

		// Welcome Header
		System.out.println("========================================================");
		System.out.println(" Welcome to the Measuring Document Similarity Applicaton");
		System.out.println("=========================================================");

		// Presents user with option available
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to Enter Files\nPress 2 to Exit\n");
		userOption = scanner.nextInt();

		switch (userOption) {
		case 1:
			// Enter files names
			System.out.println("Enter file 1:");
			String file1 = scanner.next();
			System.out.println("Enter file 2:");
			String file2 = scanner.next();
			//Asks for shingle size
			System.out.println("Enter Shingle Size");
			int shingleSize = scanner.nextInt();
			System.out.println("File1 = " + file1 + "\nFile2 = " + file2 + "\nShingle Size = " + shingleSize);
			new Launcher().Launch(file1, file2);
			break;
		case 2:
			// Exit the Application
			System.out.println("Bye");
			break;
		default:
			System.out.println("Invalid input");
		}
	}

	/**
	 * @return the file1
	 */
	public static String getFile1() {
		return file1;
	}

	/**
	 * @param file1
	 *            the file1 to set
	 */
	public static void setFile1(String file1) {
		Menu.file1 = file1;
	}

	/**
	 * @return the file2
	 */
	public static String getFile2() {
		return file2;
	}

	/**
	 * @param file2
	 *            the file2 to set
	 */
	public static void setFile2(String file2) {
		Menu.file2 = file2;
	}

	/**
	 * @return the shingleSize
	 */
	public static int getShingleSize() {
		return shingleSize;
	}

	/**
	 * @param shingleSize
	 *            the shingleSize to set
	 */
	public static void setShingleSize(int shingleSize) {
		Menu.shingleSize = shingleSize;
	}

}
