import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.NamingException;

import common.Researcher;

@WebService
public interface ResearcherWebServiceImpl {
	@WebMethod
	public List<Researcher> Getall() throws NamingException, IOException;

	@WebMethod
	public List<Researcher> GetResearcherByNome(String nome) throws NamingException, IOException;

	@WebMethod
	public List<Researcher> GetResearcherBySkill(String nome) throws NamingException, IOException;
	
}
