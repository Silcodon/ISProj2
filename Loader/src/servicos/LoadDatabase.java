package servicos;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import common.Institution;
import common.Research;
import common.Researcher;
import common.Skill;

public class LoadDatabase {
	public static void main(String[] args) {
		   
		   EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Loader" );
		   EntityManager entitymanager = emfactory.createEntityManager( );
		   entitymanager.getTransaction( ).begin( );
		   
		   
		   //Get Institute Entity
		   Set<Institution> myset2 = GetInstitutionInfo.get();
		   for (Institution st : myset2){
			   entitymanager.persist(st);
		   }
		   
		   
		   //Get Research Entity
		   Set<Research> myset3 = GetResearchInfo.get();
		   for (Research st : myset3){
			   entitymanager.persist(st);
		   }
		   
		   
		   //Get Researcher Entity
		   Set<Researcher> myset = GetResearcherInfo.get();
		   for (Researcher st : myset){
			   entitymanager.persist(st);
			}
		   
		   
		   //Get Skill Entity
		   Set<Skill> myset4 = GetSkillInfo.get();
		   for (Skill st : myset4){
			   entitymanager.persist(st);
			}

		   entitymanager.getTransaction( ).commit( );
		   entitymanager.close( );
		   emfactory.close( );
		   }

}
