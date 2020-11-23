package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import common.Researcher;

/**
 * Session Bean implementation class ResearcherBean
 */
@Stateless
@LocalBean
@WebService
public class ResearcherBean implements ResearcherBeanLocal,ResearcherBeanRemote {

	@PersistenceContext(name = "Loader")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ResearcherBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Researcher> Getall(){
    	// Define query String
    	String jpql = "SELECT r FROM researcher r";
    	// Create a (typed) query
    	TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
    	// Query and get result
    	List<Researcher> mylist = typedQuery.getResultList();
    	return mylist;
    }
    
    @Override
    public List<Researcher> GetResearcherByNome(String nome){
		// Define query String
		String jpql = "SELECT r FROM researcher r where r.personName=:name";
		// Create a (typed) query
		TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
		// Set parameter
		typedQuery.setParameter("name", nome);
		// Query and get result
		List<Researcher> mylist = typedQuery.getResultList();
		return mylist;
    }
	
    @Override
    public List<Researcher> GetResearcherBySkill(String nome){
		// Define query String
		String jpql = "SELECT r FROM researcher r inner join researcher_skill s where s.id=:(SELECT s2.id FROM skill s2 where s2.nome=:name)";
		// Create a (typed) query
		TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class);
		// Set parameter
		typedQuery.setParameter("name", nome);
		// Query and get result
		List<Researcher> mylist = typedQuery.getResultList();
		return mylist;
    }
	
	
}
