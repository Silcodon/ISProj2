package ejb;

import java.util.List;

import javax.ejb.Remote;

import common.Institution;

@Remote
public interface InstitutionBeanRemote {
	
	List<Institution> Getall();
	
	List<Institution> GetInstitutionByNome(String nome);

	List<Institution> GetInstitutionByResearcher(String nome);
}
