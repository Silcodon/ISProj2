package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.NodeList;

import common.Publication;

/**
 * Servlet implementation class PublicationHandler
 */
@WebServlet("/Publications")
public class PublicationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicationHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Publication> mylist = new ArrayList<Publication>();
		String soapEndpointUrl = "http://localhost:8080/PublicationBeanWS/PublicationWebService";
        String soapAction = "";
        String method = "Getall";
        String param = "";
        mylist = callSoapWebService(soapEndpointUrl, soapAction, method,param);
        request.setAttribute("myListOfPubs", mylist);
		request.getRequestDispatcher("/display.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	
	
	//=========================================AUX SOAP WS===============================================================================
		private static void createSoapEnvelope(SOAPMessage soapMessage, String method, String param) throws SOAPException {
	        SOAPPart soapPart = soapMessage.getSOAPPart();

	        String myNamespace = "unk";
	        String myNamespaceURI = "http://unknown.namespace/";

	        // SOAP Envelope
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

	            /*
	            Constructed SOAP Request Message:
	            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:unk="http://unknown.namespace/">
			   		<soapenv:Header/>
			   			<soapenv:Body>
			      			<unk:Getall/>
			   			</soapenv:Body>
				</soapenv:Envelope>
	            */

	        // SOAP Body
	        SOAPBody soapBody = envelope.getBody();
	        SOAPElement soapBodyElem = soapBody.addChildElement(method, myNamespace);
	        if(method.equals("Getall")==false) {
	        	SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg0");
	            soapBodyElem1.addTextNode(param);
	        }
	    }
		
		

	    private static List<Publication> callSoapWebService(String soapEndpointUrl, String soapAction, String method, String param) {
	        List<Publication> publicationlist = null;
	    	try {
	            // Create SOAP Connection
	            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

	            // Send SOAP Message to SOAP Server
	            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction,method,param), soapEndpointUrl);
	           
	            publicationlist = parseSOAPMessagePublication(soapResponse);
	            
	            soapConnection.close();
	        } catch (Exception e) {
	            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
	            e.printStackTrace();
	        }
			return publicationlist;
	    }

	    
	    
	    private static SOAPMessage createSOAPRequest(String soapAction,String method,String param) throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();

	        createSoapEnvelope(soapMessage,method,param);

	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        headers.addHeader("SOAPAction", soapAction);

	        soapMessage.saveChanges();


	        return soapMessage;
	    }
	    
	    
	    
	    
	    
	    private static List<Publication> parseSOAPMessagePublication(SOAPMessage message) throws SOAPException {
	    	SOAPBody soapBody = message.getSOAPBody();
	    	List<Publication> listpub = new ArrayList<Publication>();
	    	NodeList nodespub;
	        String someMsgContent = null;
	    	NodeList nodesreturn = soapBody.getElementsByTagName("return");
	        // check if the node exists and get the value
	        for(int i=0;i<nodesreturn.getLength();i++) {
	 	       nodespub = nodesreturn.item(i).getChildNodes();
	 	       Publication pub = new Publication();
	 	       for(int j=0;j<nodespub.getLength();j++) {
	 	       		if(nodespub.item(j).getNodeName().equals("date")) {
	 	       			someMsgContent = nodespub != null ? nodespub.item(j).getTextContent() : "";
	 			        pub.setDate(someMsgContent);
	 	        	}
	 	        	if(nodespub.item(j).getNodeName().equals("name")) {
	 		        	someMsgContent = nodespub != null ? nodespub.item(j).getTextContent() : "";
	 			        pub.setName(someMsgContent);
	 	        	}
	 	        	if(nodespub.item(j).getNodeName().equals("type")) {
	 		        	someMsgContent = nodespub != null ? nodespub.item(j).getTextContent() : "";
	 			        pub.setType(someMsgContent);
	 	        	}
	 	        	
	 	        }
		        listpub.add(pub);
	         }
	        return listpub;
	    }

	}


