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


@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class ResearcherWebService implements ResearcherWebServiceImpl{
	
	
	
	@WebResult(name="GetallResponse", partName="GetallResponse")
    public List<Researcher> Getall() throws NamingException, IOException{
		Context context;
		try( InputStream input = new FileInputStream("jndi.properties")) {
			Properties jndiProperties = new Properties();
			jndiProperties.load(input);
			
			context=new InitialContext(jndiProperties);
		}
		ResearcherBean ejb = (ResearcherBean) context.lookup("ResearcherBeans/ResearcherBean");
    	List<Researcher> mylist = ejb.Getall();
    	return mylist;
    }
	
	
    @WebResult(name="GetResearcherByNomeResponse", partName="GetResearcherByNomeResponse")
    public List<Researcher> GetResearcherByNome(@WebParam(name="param_nome") String nome) throws NamingException, IOException{
    	Context context;
		try( InputStream input = new FileInputStream("jndi.properties")) {
			Properties jndiProperties = new Properties();
			jndiProperties.load(input);
			
			context=new InitialContext(jndiProperties);
		}
		ResearcherBean ejb = (ResearcherBean) context.lookup("ResearcherBeans/ResearcherBean");
		List<Researcher> mylist = ejb.GetResearcherByNome(nome);
		return mylist;
    }
    
    @WebResult(name="GetResearcherBySkillResponse", partName="GetResearcherBySkillResponse")
    public List<Researcher> GetResearcherBySkill(@WebParam(name="param_nome") String nome) throws NamingException, IOException{
    	Context context;
		try( InputStream input = new FileInputStream("jndi.properties")) {
			Properties jndiProperties = new Properties();
			jndiProperties.load(input);
			
			context=new InitialContext(jndiProperties);
		}
		ResearcherBean ejb = (ResearcherBean) context.lookup("ResearcherBeans/ResearcherBean");
		List<Researcher> mylist = ejb.GetResearcherBySkill(nome);
		return mylist;
    }

 
}


 
	

