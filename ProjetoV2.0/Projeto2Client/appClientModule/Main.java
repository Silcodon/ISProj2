import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;


import common.Researcher;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name ="John Smith";
		try {
			URL url = new URL("http://localhost:8080/ResearcherBeanWS/ResearcherWebService?wsdl");
			QName qname = new QName("",
					"ResearcherWebServiceService");

			Service service = Service.create(url, qname);
			ResearcherWebServiceImpl ws = service.getPort(ResearcherWebServiceImpl.class);
			List<Researcher> all = ws.Getall();
			System.out.println("Researcher is " + all.get(0));


		} catch (Exception e) {
			System.out.println("Exception: "+ e);
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}