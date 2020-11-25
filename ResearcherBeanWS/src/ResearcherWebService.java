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

import common.Researcher;
import ejb.ResearcherBean;
import ejb.ResearcherBeanLocal;
import ejb.ResearcherBeanRemote;


@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class ResearcherWebService implements ResearcherWebServiceImpl{
	
	
	
	@WebResult(name="GetallResponse", partName="GetallResponse")
    public List<Researcher> Getall() throws NamingException, IOException{
		Context context;
		List<Researcher> mylist = null;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			
			context=new InitialContext(jndiProperties);
			ResearcherBeanRemote ejb = (ResearcherBeanRemote) context.lookup("ResearcherBeanEAR/ResearcherBeans/ResearcherBean!ejb.ResearcherBeanRemote");
			
	    	 mylist = ejb.Getall();
	    	
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		return mylist;
		
    }
	
	
    @WebResult(name="GetResearcherByNomeResponse", partName="GetResearcherByNomeResponse")
    public List<Researcher> GetResearcherByNome(@WebParam(name="param_nome") String nome) throws NamingException, IOException{
    	Context context;
		List<Researcher> mylist = null;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			context=new InitialContext(jndiProperties);
			ResearcherBeanRemote ejb = (ResearcherBeanRemote) context.lookup("ResearcherBeanEAR/ResearcherBeans/ResearcherBean!ejb.ResearcherBeanRemote");
			
			mylist = ejb.GetResearcherByNome(nome);
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		return mylist;
    }
    
    @WebResult(name="GetResearcherBySkillResponse", partName="GetResearcherBySkillResponse")
    public List<Researcher> GetResearcherBySkill(@WebParam(name="param_nome") String nome) throws NamingException, IOException{
    	Context context;
		List<Researcher> mylist = null;
		Properties jndiProperties = new Properties();

		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");

		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");

		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		
		try {
			context=new InitialContext(jndiProperties);
			ResearcherBeanRemote ejb = (ResearcherBeanRemote) context.lookup("ResearcherBeanEAR/ResearcherBeans/ResearcherBean!ejb.ResearcherBeanRemote");
			mylist = ejb.GetResearcherBySkill(nome);
		}catch (NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}
		
		return mylist;
    }

 
}


 
	

