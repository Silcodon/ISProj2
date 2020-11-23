import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import common.Researcher;
import ejb.ResearcherBean;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class ResearcherWebService implements ResearcherWebServiceImpl{
	@Inject
	ResearcherBean ejb;
	
	
	@WebResult(name="GetallResponse", partName="GetallResponse")
    public List<Researcher> Getall(){
    	List<Researcher> mylist = ejb.Getall();
    	return mylist;
    }
	
	
    @WebResult(name="GetResearcherByNomeResponse", partName="GetResearcherByNomeResponse")
    public List<Researcher> GetResearcherByNome(@WebParam(name="param_nome") String nome){
		List<Researcher> mylist = ejb.GetResearcherByNome(nome);
		return mylist;
    }
    
    @WebResult(name="GetResearcherBySkillResponse", partName="GetResearcherBySkillResponse")
    public List<Researcher> GetResearcherBySkill(@WebParam(name="param_nome") String nome){
		List<Researcher> mylist = ejb.GetResearcherBySkill(nome);
		return mylist;
    }

 
}


 
	

