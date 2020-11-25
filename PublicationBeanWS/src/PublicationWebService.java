import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.Publication;
import ejb.PublicationBean;
import ejb.PublicationBeanLocal;
import ejb.PublicationBeanRemote;


@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class PublicationWebService implements PublicationWebServiceImpl{
	
	
	
	@WebResult(name="GetallResponse", partName="GetallResponse")
    public List<Publication> Getall() throws NamingException, IOException{
		Context context;
		List<Publication> mylist = null;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			
			context=new InitialContext(jndiProperties);
			PublicationBeanRemote ejb = (PublicationBeanRemote) context.lookup("PublicationEAR/PublicationBeans/PublicationBean!ejb.PublicationBeanRemote");
			
	    	 mylist = ejb.Getall();
	    	
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		return mylist;
		
    }
	
	
    @WebResult(name="GetPublicationByNomeResponse", partName="GetPublicationByNomeResponse")
    public List<Publication> GetPublicationByNome(@WebParam(name="param_nome") String nome) throws NamingException, IOException{
    	Context context;
		List<Publication> mylist = null;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			context=new InitialContext(jndiProperties);
			PublicationBeanRemote ejb = (PublicationBeanRemote) context.lookup("PublicationEAR/PublicationBeans/PublicationBean!ejb.PublicationBeanRemote");
			
			mylist = ejb.GetPublicationByNome(nome);
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		return mylist;
    }
    
    @WebResult(name="GetPublicationBySkillResponse", partName="GetPublicationBySkillResponse")
    public List<Publication> GetPublicationByResearcher(@WebParam(name="param_nome") String nome) throws NamingException, IOException{
    	Context context;
		List<Publication> mylist = null;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			context=new InitialContext(jndiProperties);
			PublicationBeanRemote ejb = (PublicationBeanRemote) context.lookup("PublicationEAR/PublicationBeans/PublicationBean!ejb.PublicationBeanRemote");
			mylist = ejb.GetPublicationByResearcher(nome);
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		return mylist;
    }

 
}


 
	

