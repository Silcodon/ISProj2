package ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.transaction.Transactional;

import common.Researcher;

@Remote
public interface ResearcherBeanRemote {
	
	List<Researcher> Getall();

	List<Researcher> GetResearcherByNome(String nome);

	List<Researcher> GetResearcherBySkill(String nome);
}
