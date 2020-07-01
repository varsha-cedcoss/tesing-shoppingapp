package walmartIntegration.utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
	
	private static String locator;
	private static String selector;
	
	public static String getLocator(){
		return locator;
	}
	
	public static void setLocator(String loc){
		locator=loc;
	}
	
	public static String getSelector(){
		return selector;
	}
	
	public static void setSelector(String sel){
		selector=sel;
	}
	
	public static void findElementInXML(String page, String element) {
       try {
           File inputFile = new File(System.getProperty("user.dir") + "/src/main/resources/ObjectRepository.xml");
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder;

           dBuilder = dbFactory.newDocumentBuilder();

           Document doc = dBuilder.parse(inputFile);
           doc.getDocumentElement().normalize();

           XPath xPath =  XPathFactory.newInstance().newXPath();

           String expression = "/Application/Page[@name='" +page+ "']/Element[@name='" +element+ "']";	        
           NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
              doc, XPathConstants.NODESET);

           for (int i = 0; i < nodeList.getLength(); i++) {
              Node nNode = nodeList.item(i);
                            
              if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;                         
                 setLocator(eElement.getAttribute("locator"));
                 setSelector(eElement.getAttribute("selector"));                 
              }
           }
        } catch (ParserConfigurationException e) {
           e.printStackTrace();
        } catch (SAXException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } catch (XPathExpressionException e) {
           e.printStackTrace();
        }

	}
	
	
	public static By getElementLocator(String page, String element) {
		findElementInXML(page, element);
		
		switch(getLocator().toUpperCase()) {		
		case "ID":
			return By.id(getSelector());
		case "CLASS":
			return By.className(getSelector());
		case "TAG":
			return By.tagName(getSelector());
		case "LINKTEXT":
			return By.linkText(getSelector());
		case "PARTIALLINKTEXT":
			return By.partialLinkText(getSelector());
		case "NAME":
			return By.name(getSelector());
		case "XPATH":
			return By.xpath(getSelector());
		case "CSS":
			return By.cssSelector(getSelector());
		default:
			System.out.println("Incorrect locator found for Element: " +element+ " on Page: " +page);
			throw new InvalidArgumentException("Incorrect locator found");
		}		
	}
}
