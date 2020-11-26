package ejb;

import java.util.List;

import javax.ejb.Local;

import common.Institution;

@Local
public interface InstitutionBeanLocal {

	List<Institution> Getall();

	List<Institution> GetInstitutionByNome(String nome);

	List<Institution> GetInstitutionByResearcher(String nome);

}
