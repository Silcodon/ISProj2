import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.soap.*;
import org.w3c.dom.Node;
import common.Publication;
import common.Researcher;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		PrintStream oldErr = System.err;
		PrintStream newErr = new PrintStream(new ByteArrayOutputStream());
		System.setErr(newErr);
		boolean done  = false;
		while(!done) {
			System.out.println("****************Web Services****************");
			System.out.println("Escolha uma opcao: ");
			System.out.println("(0) Researchers ");
			System.out.println("(1) Publications ");
			System.out.println("(2) Institutions ");
			System.out.println("(3) Exit ");
			System.out.println("\n");

			int option = lerInt(0, 4);
			
			
			//RESEARCHERS
			if(option==0) {
				boolean done_researcher  = false;
				while(!done_researcher) {
					String soapEndpointUrl = "http://localhost:8080/ResearcherBeanWS/ResearcherWebService";
			        String soapAction = "";
					System.out.println("****************SOAP Researcher WS****************");
					System.out.println("Pesquisa um researcher por: ");
					System.out.println("(0) Todas ");
					System.out.println("(1) Nome ");
					System.out.println("(2) Skill ");
					System.out.println("(3) Back ");
					System.out.println("\n");

					int option_researcher = lerInt(0, 4);
					//TODAS AS PUBS
					if(option_researcher==0) {
				        String method = "Getall";
				        String param = "";
				        callSoapWebService(soapEndpointUrl, soapAction, method,param);
					}
					//PUBS POR NOME
					if(option_researcher==1) {
						System.out.print("Introduza o nome do researcher: ");
						String param = scan.nextLine();
						String method = "GetResearcherByNome";
				        callSoapWebService(soapEndpointUrl, soapAction, method,param);
					}
					//PUBS POR RESEARCHER
					if(option_researcher==2) {
						System.out.print("Introduza o skill: ");
						String param = scan.nextLine();
						String method = "GetResearcherBySkill";
				        callSoapWebService(soapEndpointUrl, soapAction, method,param);
					}
					//SAIR
					if(option_researcher==3) {
						done_researcher=true;
					}
				}
			}
			
			
			//PUBLICATIONS
			if(option==1) {	
				boolean done_pub  = false;
				while(!done_pub) {
					String soapEndpointUrl = "http://localhost:8080/PublicationBeanWS/PublicationWebService";
			        String soapAction = "";
					System.out.println("****************SOAP Publications WS****************");
					System.out.println("Pesquisa uma publicacao por: ");
					System.out.println("(0) Todas ");
					System.out.println("(1) Nome ");
					System.out.println("(2) Researcher ");
					System.out.println("(3) Back ");
					System.out.println("\n");

					int option_pub = lerInt(0, 4);
					//TODAS AS PUBS
					if(option_pub==0) {
				        String method = "Getall";
				        String param = "";
				        callSoapWebService(soapEndpointUrl, soapAction, method,param);
					}
					//PUBS POR NOME
					if(option_pub==1) {
						System.out.print("Introduza o nome da publicacao: ");
						String param = scan.nextLine();
						String method = "GetPublicationByNome";
				        callSoapWebService(soapEndpointUrl, soapAction, method,param);
					}
					//PUBS POR RESEARCHER
					if(option_pub==2) {
						System.out.print("Introduza o nome do researcher: ");
						String param = scan.nextLine();
						String method = "GetPublicationByResearcher";
				        callSoapWebService(soapEndpointUrl, soapAction, method,param);
					}
					//SAIR
					if(option_pub==3) {
						done_pub=true;
					}
				}
			}
			
			
			
			
			
			//INSTITUTIONS
			if(option==2) {
				boolean done_inst  = false;
				while(!done_inst) {
					System.out.println("****************REST Institutions WS****************");
					System.out.println("Pesquisa uma instituição por: ");
					System.out.println("(0) Todas ");
					System.out.println("(1) Nome ");
					System.out.println("(2) Researcher ");
					System.out.println("(3) Back ");
					System.out.println("\n");

					int option_inst = lerInt(0, 4);
					//TODAS AS INSTS
					if(option_inst==0) {
						GetAllInst();
					}
					//INST POR NOME
					if(option_inst==1) {
						System.out.print("Introduza o nome da instituicao: ");
						String nome = scan.nextLine();
						GetInstByName(nome);
					}
					//INST POR RESEARCHER
					if(option_inst==2) {
						System.out.print("Introduza o nome do researcher: ");
						String nome = scan.nextLine();
						GetInstByResearcher(nome);
					}
					//SAIR
					if(option_inst==3) {
						done_inst=true;
					}
				}
			}
			
			
			
			
			
			//EXIT
			if(option==3) {
				System.out.println("You have successfully exited the Application.");
                done = true;
			}
			
		}
		
		System.setErr(oldErr);
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
	
	
	//LER INT DE STDIN
	public static int lerInt(int init, int fin ) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		boolean aux = true;
		System.out.print("Introduza a opcao: ");
		while (aux) {
			if (scan.hasNextInt()) {
				num = scan.nextInt();
				if (num>=init && num< fin) {
					aux = false;
				}
				else {
					System.out.print("Invalid option. Try again: ");
				}
			}
			else {
				System.out.print("Invalid option. Try again: ");
				scan.next();
			}
		}
		return num;
	}
	
	
	
	//===================================AUX REST WS=======================================================================================
	
	
	//CHAMAR Getall DO REST WEB SERVICE
	//Imprime a informacao de todas as instituicoes
	public static void GetAllInst() {
		int j;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/InstitutionBeanRestWS/rest/InstitutionWebService/getall");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();
		JSONArray arr = new JSONArray(value);
        for (int i = 0; i < arr.length(); i++) {
        	 JSONObject object = arr.getJSONObject(i);
        	 j=i+1;
        	 System.out.println("Instituto " + j + ":");
        	 System.out.println("Nome: " + object.getString("name"));
        	 System.out.println("Localizacao: " + object.getString("location"));
        	 System.out.println("Departamento: " + object.getString("department"));
        	 System.out.print("\n");
        }
	}
	
	
	
	//CHAMAR GetInstByName DO REST WEB SERVICE
	//@param name -> nome da instituicao a pesquisar
	//Imprime a informação da instituicao
	public static void GetInstByName(String name) {
		int j;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/InstitutionBeanRestWS/rest/InstitutionWebService/getbyname");
		target = target.queryParam("name", name);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();
		JSONArray arr = new JSONArray(value);
        for (int i = 0; i < arr.length(); i++) {
        	 JSONObject object = arr.getJSONObject(i);
        	 j=i+1;
        	 System.out.println("Instituto " + j + ":");
        	 System.out.println("Nome: " + object.getString("name"));
        	 System.out.println("Localizacao: " + object.getString("location"));
        	 System.out.println("Departamento: " + object.getString("department"));
        	 System.out.print("\n");
        }
	}
	
	
	
	//CHAMAR GetInstByResearcher DO REST WEB SERVICE
	//@param name -> nome do researcher a ir buscar
	//Imprime a informação da instituicao do researcher
	public static void GetInstByResearcher(String name) {
		int j;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/InstitutionBeanRestWS/rest/InstitutionWebService/getbyresearcher");
		target = target.queryParam("name", name);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();
		JSONArray arr = new JSONArray(value);
        for (int i = 0; i < arr.length(); i++) {
        	 JSONObject object = arr.getJSONObject(i);
        	 j=i+1;
        	 System.out.println("Instituto " + j + ":");
        	 System.out.println("Nome: " + object.getString("name"));
        	 System.out.println("Localizacao: " + object.getString("location"));
        	 System.out.println("Departamento: " + object.getString("department"));
        	 System.out.print("\n");
        }
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
	
	

    private static void callSoapWebService(String soapEndpointUrl, String soapAction, String method, String param) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction,method,param), soapEndpointUrl);
            
            if(soapEndpointUrl.equals("http://localhost:8080/ResearcherBeanWS/ResearcherWebService")) {
            	System.out.println();
                parseSOAPMessageResearcher(soapResponse);
            }
            else if(soapEndpointUrl.equals("http://localhost:8080/PublicationBeanWS/PublicationWebService")) {
            	System.out.println();
            	parseSOAPMessagePublication(soapResponse);
            }
            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
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
    
    
    
    private static void parseSOAPMessageResearcher(SOAPMessage message) throws SOAPException {
    	SOAPBody soapBody = message.getSOAPBody();
    	NodeList nodesperson;
        String someMsgContent = null;
        String PersonName = null;
        String Citations = null;
        String Id = null;
        String Reads = null;
        String InstName = null;
        String InstLocation = null;
        String InstDepartment = null;
        ArrayList<String> skillsString = new ArrayList<String>();
        int k;
    	// find your node based on tag name
        NodeList nodesreturn = soapBody.getElementsByTagName("return");
        // check if the node exists and get the value
        for(int i=0;i<nodesreturn.getLength();i++) {
	        nodesperson = nodesreturn.item(i).getChildNodes();
	        System.out.println("Pessoa " + (i + 1));
	        k=0;
	        for(int j=0;j<nodesperson.getLength();j++) {
	        	if(nodesperson.item(j).getNodeName().equals("citations")) {
		        	someMsgContent = nodesperson != null ? nodesperson.item(j).getTextContent() : "";
			        Citations= someMsgContent;
	        	}
	        	if(nodesperson.item(j).getNodeName().equals("id")) {
		        	someMsgContent = nodesperson != null ? nodesperson.item(j).getTextContent() : "";
			        Id = someMsgContent;
	        	}
	        	if(nodesperson.item(j).getNodeName().equals("institutionSet")) {
	        		NodeList insts = nodesperson.item(j).getChildNodes();
	        		for(int index=0;index<insts.getLength();index++) {
	        			if(insts.item(index).getNodeName().equals("department")){
	        				someMsgContent = insts != null ? insts.item(index).getTextContent() : "";
	        				InstDepartment=someMsgContent;
	        			}
	        			if(insts.item(index).getNodeName().equals("location")){
	        				someMsgContent = insts != null ? insts.item(index).getTextContent() : "";
	        				InstLocation=someMsgContent;
	        			}
	        			if(insts.item(index).getNodeName().equals("name")){
	        				someMsgContent = insts != null ? insts.item(index).getTextContent() : "";
	        				InstName=someMsgContent;
	        			}
	        		}
	        	}
	        	if(nodesperson.item(j).getNodeName().equals("personName")) {
		        	someMsgContent = nodesperson != null ? nodesperson.item(j).getTextContent() : "";
			        PersonName= someMsgContent;
	        	}
	        	if(nodesperson.item(j).getNodeName().equals("reads")) {
		        	someMsgContent = nodesperson != null ? nodesperson.item(j).getTextContent() : "";
			        Reads = someMsgContent;
	        	}
	        	if(nodesperson.item(j).getNodeName().equals("skillSet")) {
	        		NodeList skills = nodesperson.item(j).getChildNodes();
	        		someMsgContent = skills != null ? skills.item(0).getTextContent() : "";
	    		    skillsString.add(someMsgContent);
	        	}
	        	
	        }
    		System.out.println("Id: " + Id);
    		System.out.println("PersonName: " + PersonName);
    		System.out.println("Citations: " + Citations);
    		System.out.println("Reads: " + Reads);
			for(k=0; k<skillsString.size();k++) {
				System.out.println("Skill " + k + ": " + skillsString.get(k));
			}
			System.out.println();
    		System.out.println("Institution ");
			System.out.println("Name: " + InstName);
			System.out.println("Location: " + InstLocation);
			System.out.println("Department: " + InstDepartment);
	        System.out.println("\n\n");
	        skillsString.clear();
	        
	        
	        
        }
    }
    
    
    
    private static void parseSOAPMessagePublication(SOAPMessage message) throws SOAPException {
    	SOAPBody soapBody = message.getSOAPBody();
    	NodeList nodespub;
        String someMsgContent = null;
    	NodeList nodesreturn = soapBody.getElementsByTagName("return");
        // check if the node exists and get the value
        for(int i=0;i<nodesreturn.getLength();i++) {
 	       nodespub = nodesreturn.item(i).getChildNodes();
 	       System.out.println("Publicacao " + (i + 1));
 	       for(int j=0;j<nodespub.getLength();j++) {
 	       		if(nodespub.item(j).getNodeName().equals("date")) {
 	       			System.out.print("Date: ");
 	       			someMsgContent = nodespub != null ? nodespub.item(j).getTextContent() : "";
 			        System.out.println(someMsgContent);
 	        	}
 	        	if(nodespub.item(j).getNodeName().equals("name")) {
 	       			System.out.print("Name: ");
 		        	someMsgContent = nodespub != null ? nodespub.item(j).getTextContent() : "";
 			        System.out.println(someMsgContent);
 	        	}
 	        	if(nodespub.item(j).getNodeName().equals("type")) {
 	       			System.out.print("Type: ");
 		        	someMsgContent = nodespub != null ? nodespub.item(j).getTextContent() : "";
 			        System.out.println(someMsgContent);
 	        	}
 	        	
 	        }
	        System.out.println("\n\n");
         }
    }

}