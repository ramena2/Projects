
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

import java.io.FileNotFoundException;

public class XMLParser {


	public static Document inputFile() throws FileNotFoundException {
		//Check the file, if it does not exist than it will call again.
		Document doc = null;
		
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter the name of your file");
			String filename = input.nextLine();
			
			
			
			File inputFile = new File(filename);
			
			boolean exit = false;//This means the program is going to run until is true
			
			//Create a DocumentBuilder to use a JDOM
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			//Create a Document from the txt file
			doc = dBuilder.parse(inputFile);
			
			return doc;

		} catch (FileNotFoundException e) {
			System.out.println("File not found, please check and enter the correct name of your file");
			System.out.println();
			inputFile();
		
		} catch (Exception e) {
			e.printStackTrace();
			inputFile();

			
		}
		return doc;
		
		
	}

	/***********************************************************************************/

	
	public static void main(String[] args) {

		try {
			
			inputFile();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
