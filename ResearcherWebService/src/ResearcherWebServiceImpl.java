import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import common.Researcher;

@WebService
public interface ResearcherWebServiceImpl {
	@WebMethod
	public List<Researcher> Getall();

	@WebMethod
	public List<Researcher> GetResearcherByNome(String nome);

	@WebMethod
	public List<Researcher> GetResearcherBySkill(String nome);
	
}
