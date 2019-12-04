package edu.ilstu;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		ArrayList<Line> termsList = new ArrayList<>();

		String exportName;
		String termsLine;
		

        try (BufferedReader br = new BufferedReader(new FileReader("Terms.csv"))) {
        	br.readLine();
            while ((termsLine = br.readLine()) != null) {
            	Line lines = new Line();
            	
                // use comma as separator
                String[] readTxt = termsLine.split(",");

                for (int i = 0; i < readTxt.length;i++) {
                	if (!readTxt[i].equals("")) {
                		if (i == 0)
                			lines.setCui1(readTxt[i]);
                	if (i == 1)
            			lines.setName1(readTxt[i]);
                	termsList.add(lines);
            			lines = new Line();
            		
                }
                }
               

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		ArrayList<Line> myList = new ArrayList<>();

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
				  System.out.println(myList);
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
	
	public static void readInFile(String fileName) {
		String text = "";
		String finalText ="";
		ArrayList<String> readin = new ArrayList<>();
		
		
        String line = "";
        ArrayList<Line> myList =new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("relationships3.csv"))) {
        	br.readLine();
            while ((line = br.readLine()) != null) {
            	Line lines = new Line();
            	
                // use comma as separator
                String[] readTxt = line.split(",");

                for (int i = 0; i < readTxt.length;i++) {
                	if (!readTxt[i].equals(""))
                		if (i == 0)
                			lines.setCui1(readTxt[i]);
                	if (i == 1)
            			lines.setRelationship(readTxt[i]);
                	if (i == 2)
            			lines.setCui2(readTxt[i]);
                	if (i == 3) {
            			lines.setName2(readTxt[i]);
            			myList.add(lines);
            			lines = new Line();
            		
                	}
                }
               

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    
		
	System.out.println(myList);	 
	
      
		
		
		
		
	}
		

	
	public static void writeToFile(String outFileName) throws IOException {
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
