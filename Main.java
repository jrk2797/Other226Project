package edu.ilstu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    Scanner scanInput = new Scanner(System.in);
		String text = "";
		int column = 0;
		String switchInput;
		String userInput;
		String exportName;

		do {
			System.out.println("Please enter in 'A' to read a file.");
			System.out.println("Or enter 'R' to enter a relationship name.");
			System.out.println("Or enter 'T' to enter a medical term and export all information pertaining to it.");
			System.out.println("Or enter in 'E' to exit the program");
			System.out.println(": ");
			switchInput = scanInput.nextLine();
			
			switch(switchInput) {
			  
			  case "a":
			  case "A": 
				  System.out.println("Please enter the name of the file you want to read in");
				  userInput = scanInput.nextLine();
				  readInFile(userInput);
			    break;
			  case "t":
			  case "T":
				  System.out.println("Please enter in a medical term");
				  break;
			  case "r":
			  case "R":
				  System.out.println("Please enter in the name of a relationship you want to export");
				  userInput = scanInput.nextLine();
			    // code block
			    break;
			  case "E":
			  case "e":
				  System.out.println("Exiting Program");
				  System.exit(0);
			  default:
			    System.out.println("Invalid Input");
			    break;
			}

		}while (true);
		
	} 
		
	public void readInFile(String fileName) {
		String text = "";
		try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			while (scanner.hasNextLine()) {
				scanner.useDelimiter(",");
				text = scanner.next();
				System.out.print(text + ",");	
			}	
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
	
		}
		
	}
	
	public void writeToFile(String outFileName) throws IOException {
			    FileWriter fileWriter = new FileWriter(outFileName);
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print("STR");
			    printWriter.print(",");
			    printWriter.print("Relationship");
			    printWriter.print(",");
			    printWriter.print("STR2");
			    printWriter.print(",");
			    
			    printWriter.close();
			
	
	}
	  
	  
}
