package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import common.Institution;

/**
 * Session Bean implementation class PublicationBean
 */
@Stateless
@LocalBean
public class InstitutionBean implements InstitutionBeanRemote, InstitutionBeanLocal {

	@PersistenceContext(name = "Loader")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public InstitutionBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public List<Institution> Getall(){
    	// Define query String
    	String jpql = "SELECT r FROM Institution r";
    	// Create a (typed) query
    	TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class);
    	// Query and get result
    	List<Institution> mylist = typedQuery.getResultList();
    	return mylist;
    }
    
	
	@Override
    public List<Institution> GetInstitutionByNome(String nome){
		// Define query String
		String jpql = "SELECT r FROM Institution r where r.name=:name";
		// Create a (typed) query
		TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class);
		// Set parameter
		typedQuery.setParameter("name", nome);
		// Query and get result
		List<Institution> mylist = typedQuery.getResultList();
		return mylist;
    }
	
	@Override
    public List<Institution> GetInstitutionByResearcher(String nome){
		// Define query String
		String jpql = "SELECT i FROM Institution i, Researcher r where r.personName=:name and r.institution=i.id";
		// Create a (typed) query
		TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class);
		// Set parameter
		typedQuery.setParameter("name", nome);
		// Query and get result
		List<Institution> mylist = typedQuery.getResultList();
		return mylist;
    }

}
