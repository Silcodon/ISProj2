
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import common.Institution;
import ejb.InstitutionBean;
import ejb.InstitutionBeanRemote;


@Path("/InstitutionWebService")
public class InstitutionWebService {
	
	@GET
	@Path("/teste")
	@Produces(MediaType.APPLICATION_JSON )
	public Institution teste() {
		Institution person = new Institution();
		person.setName("Universidade");
		person.setLocation("Coimbra");
		person.setDepartment("Departamento de Informatica");
		return person;
	}
	
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON )
	public List<Institution> Getall() {
		List<Institution> mylist = null;
		Context context;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			
			context=new InitialContext(jndiProperties);
			InstitutionBeanRemote ejb = (InstitutionBeanRemote) context.lookup("InstitutionEAR/InstitutionBeans/InstitutionBean!ejb.InstitutionBeanRemote");
			
	    	 mylist = ejb.Getall();
	    	
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		
		return mylist;
	
	}
	
	@GET
	@Path("/getbyname")
	@Produces(MediaType.APPLICATION_JSON )
	public List<Institution> GetInstitutionByName(@QueryParam("name") String value) {
		List<Institution> mylist = null;
		Context context;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			
			context=new InitialContext(jndiProperties);
			InstitutionBeanRemote ejb = (InstitutionBeanRemote) context.lookup("InstitutionEAR/InstitutionBeans/InstitutionBean!ejb.InstitutionBeanRemote");
			
	    	 mylist = ejb.GetInstitutionByNome(value);
	    	
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		
		return mylist;
	}
	
	
	@GET
	@Path("/getbyresearcher")
	@Produces(MediaType.APPLICATION_JSON )
	public List<Institution> GetInstitutionByResearcher(@QueryParam("name") String value) {
		List<Institution> mylist = null;
		Context context;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			
			context=new InitialContext(jndiProperties);
			InstitutionBeanRemote ejb = (InstitutionBeanRemote) context.lookup("InstitutionEAR/InstitutionBeans/InstitutionBean!ejb.InstitutionBeanRemote");
			
	    	 mylist = ejb.GetInstitutionByResearcher(value);
	    	
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		
		return mylist;
	}

}
