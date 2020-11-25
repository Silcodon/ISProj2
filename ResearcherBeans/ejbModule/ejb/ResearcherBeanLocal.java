package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.transaction.Transactional;

import common.Researcher;

@Local
public interface ResearcherBeanLocal {
	
	List<Researcher> Getall();

	List<Researcher> GetResearcherByNome(String nome);

	List<Researcher> GetResearcherBySkill(String nome);

}
