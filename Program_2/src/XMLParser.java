
import java.io.File;
import java.util.Scanner;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 *  * Student: Raul A. Mena
 * Professor: Dr. Roach
 * Course CS3331
 * Institution: University of Texas at El Paso
 * Due Date: 09/13/2019 extension to 09/16/2019 before noon.
 * Program_2
 * 
 * Modify Date:
 * 09/14/2019 Create class XMLParser
 * 09/14/2019 Create method commandLine()
 * 09/14/2019 Create method printShowS() and printShowG()
 * 09/14/2019 Create method ChangeStudent() and ChangeGrade()
 * 09/14/2019 Create method WriteXMLFile()
 * 09/14/2019 Adjust if statements for the command Next and for the command Previous
 * 09/14/2019 Adjust an if statement for the command Exit
 * 
 * Description: The program is going to take a file input, reads 
 * the xml and identifies the content. Include a set of commands
 * to show the currrent content, change parameter, write file name,
 * select next element content or previous element content, and 
 * exit command.
 * 
 * 
 */

public class XMLParser {
	
	
	public static String commandLine() {
		//CommandLine interface
		
		Scanner scnr = new Scanner(System.in);//user response

		System.out.println();
		System.out.println();
		System.out.println("Command line interface will work to the following commands, "
				+ "by using their abbreviation to a single character");
		System.out.println();
		
		System.out.println("Show : print the contents of the current element");
		System.out.println("Change : paramenter value change the  <param> of the current element to value");
		System.out.println("Write : filename write the DOM object to an XML text file");
		System.out.println("Next : output the contents of the next element");
		System.out.println("Previous : output the contents of the previous element");
		System.out.println("Exit : quit the program");

		System.out.println();
		System.out.println("Ex: if you enter");
		System.out.println("              C GPA 2.1");
		System.out.println("The program should respond with:");
		System.out.println("Student: Name=Jose,Rank=Freshman,GPA=2.1");
		System.out.println();
		System.out.println();

		System.out.println("Enter command");
		String input = scnr.nextLine();//input commands
		System.out.println(input);
		
		
		
		return input;
	}
	
	
	
	
	
	

	/********************************* Command Show ******************************************************/
	
	public static void printShowS(Element eElement, Node nNode) {
		//Show current element
		System.out.println("\nCurrent Element : " + nNode.getNodeName());
		
		System.out.println("Student name : " 
				+ eElement.getElementsByTagName("Name").item(0).getTextContent());
		
		System.out.println("Rank : " 
				+ eElement
				.getElementsByTagName("Rank")
				.item(0)
				.getTextContent());
		
		
		System.out.println("GPA : " 
				+ eElement
				.getElementsByTagName("GPA")
				.item(0)
				.getTextContent());
		System.out.println();	
	}
	
	
	
	public static void printShowG(Element eElement, Node nNode) {
		//Show current element
		System.out.println("\nCurrent Element : " + nNode.getNodeName());
		
		System.out.println("Student name : " 
				+ eElement.getElementsByTagName("Name").item(0).getTextContent());
		
		System.out.println("Assignement : " 
				+ eElement
				.getElementsByTagName("Assignment")
				.item(0)
				.getTextContent());
		
		
		System.out.println("Value : " 
				+ eElement
				.getElementsByTagName("Value")
				.item(0)
				.getTextContent());
		
		System.out.println("Letter Grade : " 
				+ eElement
				.getElementsByTagName("LetterGrade")
				.item(0)
				.getTextContent());
		
		System.out.println();
	}
	
	/********************************* Command Change **************************************************/
	
	
	public static void ChangeStudent(Element eElement,String[] cml) {
		//Command Change for the element Student
		
		if(cml[1].equals("Name")) {
			eElement.getElementsByTagName("Name").item(0).setTextContent(cml[2]);
			
			System.out.println("Student name : " 
					+ eElement.getElementsByTagName("Name").item(0).getTextContent());
			System.out.println();
			
		} else if(cml[1].equals("Rank")) {
			eElement.getElementsByTagName("Rank").item(0).setTextContent(cml[2]);
			System.out.println("Rank : " 
					+ eElement
					.getElementsByTagName("Rank")
					.item(0)
					.getTextContent());
			
		} else if(cml[1].equals("GPA")) {
			eElement.getElementsByTagName("GPA").item(0).setTextContent(cml[2]);
			System.out.println("GPA : " 
					+ eElement
					.getElementsByTagName("GPA")
					.item(0)
					.getTextContent());
		}
	
	}
	
	public static void ChangeGrade(Element eElement,String[] cml) {
		//Command Change for the element Grade
		
		if(cml[1].equals("Name")) {
			eElement.getElementsByTagName("Name").item(0).setTextContent(cml[2]);
			
			System.out.println("Student name : " 
					+ eElement.getElementsByTagName("Name").item(0).getTextContent());
			System.out.println();
			
		} else if(cml[1].equals("Assignment")) {
			eElement.getElementsByTagName("Assignment").item(0).setTextContent(cml[2]);
			System.out.println("Rank : " 
					+ eElement
					.getElementsByTagName("Assignment")
					.item(0)
					.getTextContent());
			
		} else if(cml[1].equals("Value")) {
			eElement.getElementsByTagName("Value").item(0).setTextContent(cml[2]);
			System.out.println("GPA : " 
					+ eElement
					.getElementsByTagName("Value")
					.item(0)
					.getTextContent());
		} else if(cml[1].equals("LetterGrade")) {
			eElement.getElementsByTagName("LetterGrade").item(0).setTextContent(cml[2]);
			System.out.println("GPA : " 
					+ eElement
					.getElementsByTagName("LetterGrade")
					.item(0)
					.getTextContent());
		}
	
	}
	
	/********************************* Command Write **************************************************/
	
	
	public static void WriteXMLFile(Document doc) {
		//Command Write
		try {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("Test.xml"));
        transformer.transform(source, result);
        
        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
        
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	
	}
	

	/***********************************************************************************/

	
	public static void main(String[] args) {

		try {
			File inputFile = new File("input.txt");
			
			boolean exit = false;//This means the program is going to run until is true
			
			//Create a DocumentBuilder to use a JDOM
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			//Create a Document from the txt file
			Document doc = dBuilder.parse(inputFile);
			
			//Extract the root element
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			
			NodeList std = doc.getElementsByTagName("Student");//Insert element with student
			NodeList grd = doc.getElementsByTagName("Grade");//Insert element with Grade
			System.out.println("----------------------------");

			
			String[] cml = commandLine().split(" ");//store the command , parameter , change

			int counterStudent = 0;
			int counterGrade = 0;
			boolean anotherElement = false;//This is to determine if the user move to another element
			
			

			//Stores the nodelist of the elements that have the "Student" in Nodes and Elements			
			Node nNode = std.item(counterStudent);
			Element student = (Element) nNode;
			
			//Stores the nodelist of the elements that have the "Grade" in Nodes and Elements
			Node nNode2 = grd.item(counterGrade);
			Element grade = (Element) nNode2;
			
			

			while (!exit) {//If user enters command E or e they will not continue in the loop
				//Fixed it cannot get out from the loop
				if (counterStudent < std.getLength()) {
					nNode = std.item(counterStudent);//select element
					student = (Element) nNode;//create the subelements

				}
				else if (counterGrade < grd.getLength()) {
					//Move from element Student to element Grade
					nNode2 = grd.item(counterGrade);
					grade = (Element) nNode2;
					counterGrade++;
				}
				
				
				if (nNode.getNodeName().contentEquals("Student") || nNode2.getNodeName().contentEquals("Grade") ) {		
						//Command will continue until it exits						
						if (cml[0].equals("S") || cml[0].equals("s")) {
							//Command Show
							
							if(counterStudent < std.getLength() && !anotherElement) {
								printShowS(student, nNode);

							} else {
								printShowG(grade, nNode);
								

							}
							
						
						} else if(cml[0].equals("C") || cml[0].equals("c")) {
							//Command Change
							System.out.println("\nCurrent Element : " + nNode.getNodeName());
							//Command to change an element attribute
							//Find the attribute
							if(counterStudent < std.getLength() && !anotherElement) {
								ChangeStudent(student, cml);

							} else {
								ChangeGrade(grade, cml);
								

							}
							
		
							
							
						} else if (cml[0].equals("W") || cml[0].equals("w")) {//FIX ME
							//Command Write
							WriteXMLFile(doc);
						
						} 
						
						
						
						else if (cml[0].equals("N") || cml[0].equals("n")) {
							//Command Next
							if (counterStudent < std.getLength() && counterStudent + 1 < std.getLength()) {
								
								Node temp = std.item(counterStudent + 1);//select element
								Element tempNext = (Element) temp;//create the subelements
								printShowS(tempNext, temp);//Prints the next element
								counterStudent++;//move to the next element
							}
							else if (counterStudent + 1 >= std.getLength() && counterGrade < grd.getLength()){
								
								anotherElement = true;
								Node temp = grd.item(counterGrade);//select element
								Element tempNext = (Element) temp;//create the subelements
								printShowG(tempNext, temp);//Prints the next element
								counterGrade++;//Move to the next element
							}
							else {
								System.out.println("No more elements press P to go back");
							}
						}
						
						
						
						else if(cml[0].equals("P") || cml[0].equals("p")) {
							//Command Previous
								if(counterStudent - 1 >= 0 && counterStudent < std.getLength() && !anotherElement) {
									counterStudent--;;									
									Node temp = std.item(counterStudent);//select element
									Element tempPrev = (Element) temp;//create the subelements
									printShowS(tempPrev, temp);//Prints the next element
								
								} else if(anotherElement) {
									
									if((counterGrade - 1) >= 0) {
										counterGrade--;//Move to the next element
										Node temp = grd.item(counterGrade);//select element
										Element tempPrev = (Element) temp;//create the subelements
										printShowG(tempPrev, temp);//Prints the next element
									}
									else if (counterGrade - 1 < 0){
										anotherElement = false;
										Node temp = std.item(counterStudent);//select element
										Element tempPrev = (Element) temp;//create the subelements
										printShowS(tempPrev, temp);//Prints the next element

									}
									

								}
								else {
									System.out.println("try command N or P to keep moving");
								}
								
						
						}
						
						else if (cml[0].contentEquals("E") || cml[0].contentEquals("e")) {
							//Command to exit
							exit = true;
						}
						
					
				}
				
				if (!exit) {
					//Call the command line again
					cml = commandLine().split(" ");

				}

			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
