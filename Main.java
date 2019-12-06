import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;




public class Main {
	
	static ArrayList<String> alreadyRead = new ArrayList<>();
	
	public static ArrayList<Line> readInFile(String fileName) {
		String text = "";
		String finalText ="";
		
		
        String line = "";
        ArrayList<Line> myList =new ArrayList<>();
        
        ArrayList<String> readin = new ArrayList<>();
		if (alreadyRead.contains(fileName)) {
			System.out.println("You've already read in this file.");
			return myList;
		}
		alreadyRead.add(fileName);
        int counter = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
                counter++;
                
            }
           System.out.println(counter + " Lines read in");
        } catch (IOException e) {
           System.out.println("Invalid File");
        }

    
	return myList;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    Scanner scanInput = new Scanner(System.in);
		String text = "";
		int column = 0;
		String switchInput;
		String userInput;
		ArrayList<Line> termsList = new ArrayList<>();
		ArrayList<Line> allThings = new ArrayList<>();

		String exportName;
		String termsLine;
		

        try (BufferedReader br = new BufferedReader(new FileReader("Terms.csv"))) {
        	br.readLine();
            while ((termsLine = br.readLine()) != null) {
            	Line lines = new Line();
            	
                // use comma as separator
                String[] readTxt = termsLine.split(",");
                System.out.println(readTxt[0]);
                System.out.println(readTxt[1]);

                for (int i = 0; i < readTxt.length;i++) {
                	if (!readTxt[i].equals("")) {
                		if (i == 0)
                			lines.setCui1(readTxt[i]);
                	if (i == 1) {
            			lines.setName1(readTxt[i]);
                	termsList.add(lines);
            			lines = new Line();
                	}
            		
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
			String outputfile = "";
			switch(switchInput) {
			  
			  case "a":
			  case "A": 
				  System.out.println("Please enter the name of the file you want to read in");
				  userInput = scanInput.nextLine();
				 allThings.addAll(readInFile(userInput));
				 for (Line term:  allThings) {
					 if (term.getName1().equals(""))
						 for (Line term2: termsList) {
							 if (term.getCui1().equals(term2.getCui1()))
								 term.setName1(term2.getName1());
						 }
				 }
				 
				  System.out.println(allThings);
			    break;
			  case "t":
			  case "T":
				  System.out.println("Please enter in a medical term");
				  userInput = scanInput.nextLine();
				  System.out.println("Please enter file name to save data");
				  outputfile = scanInput.nextLine();
				  try {
					writeToFile(outputfile, allThings, userInput, "T");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
				  
				  
				  break;
			  case "r":
			  case "R":
				  System.out.println("Please enter in the name of a relationship you want to export");
				  userInput = scanInput.nextLine();
				  System.out.println("Please enter file name to save data");
				  outputfile = scanInput.nextLine();
				  try {
					writeToFile(outputfile, allThings, userInput, "R");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	public static void writeToFile(String outFileName, ArrayList<Line> allThings, String userInput, String string) throws IOException {
			    FileWriter fileWriter = new FileWriter(outFileName);
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print("STR");
			    printWriter.print(",");
			    printWriter.print("Relationship");
			    printWriter.print(",");
			    printWriter.print("STR2");
			    printWriter.print("\n");
			    for (Line aTerm: allThings) {
			    	if(string.equals("R")) {
					  if (aTerm.getRelationship().equals(userInput)) {
						  printWriter.print(aTerm.getName1() +  ", "  + aTerm.getRelationship() + ", " + aTerm.getName2());
						  
					  }
			    	}
			    	else if (string.equals("T")) {
			    		 if (aTerm.getName1().equals(userInput) || aTerm.getName1().equals(userInput)) {
							  printWriter.print(aTerm.getName1() +  ", "  + aTerm.getRelationship() + ", " + aTerm.getName2());
							  
						  }
			    	}
			    	printWriter.print("\n");
			    }
			    printWriter.close();
			
	
	}
}
