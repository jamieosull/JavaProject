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

		// Welcome Header
		System.out.println("========================================================");
		System.out.println(" Welcome to the Measuring Document Similarity Applicaton");
		System.out.println("=========================================================");

		// Presents user with option available
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to enter Files\nPress 2 to quit\n");
		userOption = scanner.nextInt();

		switch (userOption) {
		case 1:
			// Enter files
			System.out.println("Enter file 1:");
			String file1 = scanner.next();
			System.out.println("Enter file 2:");
			String file2 = scanner.next();
			
			new Launcher().Launch(file1, file2);

			System.out.println("Enter Shingle Size");
			int shingleSize = scanner.nextInt();
			System.out.println("File1 = " + file1 + "\nFile2 = " + file2 + "\nShingle Size = " + shingleSize);
			break;
		case 2:
			// Exit the Application
			System.out.println("Quit");
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

	public static String getInputString(String input) {
		Scanner scanner = new Scanner(System.in);
		String output = "";

		System.out.println(input);
		output = setFileName(scanner.next());
		return output;
	}

	// take in the int for menu choice
	public static int getInputInt(String input) {
		Scanner scanner = new Scanner(System.in);
		int output;

		System.out.println(input);
		output = scanner.nextInt();

		return output;
	}// getStringInput
		// add the .txt extension if not there already

	private static String setFileName(String fileName) {
		// TODO Auto-generated method stub
		String txt = ".txt";
		if (!fileName.contains(txt)) {
			return fileName + txt;
		}

		return fileName;
	}

}
