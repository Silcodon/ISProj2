import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.soap.*;


import common.Researcher;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
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
				
			}
			
			
			//PUBLICATIONS
			if(option==1) {
				String soapEndpointUrl = "http://localhost:8080/ResearcherBeanWS/ResearcherWebService";

			}
			
			
			
			
			
			//INSTITUTIONS
			if(option==2) {
				boolean done_inst  = false;
				while(!done_inst) {
					System.out.println("****************REST WS****************");
					System.out.println("Pesquisa uma instituição por: ");
					System.out.println("(0) Todas ");
					System.out.println("(1) Nome ");
					System.out.println("(2) Researcher ");
					System.out.println("(3) Exit ");
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
	
	

}