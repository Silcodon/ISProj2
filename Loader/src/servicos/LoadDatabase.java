package servicos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

import common.Institution;
import common.Publication;
import common.Researcher;
import common.Skill;

public class LoadDatabase {
	public static void main(String[] args) {
		  
		
		
			
		   EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Loader" );
		   EntityManager entitymanager = emfactory.createEntityManager( );
		   entitymanager.getTransaction( ).begin( );
		   
		   
		   
		   //Get Institute Entity
		   Set<Researcher> myset = new HashSet<Researcher>();
		   Set<Institution> myset2 = new HashSet<Institution>();
		   Set<Publication> myset3 = new HashSet<Publication>();
		   Set<Skill> myset4 = new HashSet<Skill>();
		   
		   Institution inst1 = new Institution();
		   inst1.setName("Universidade de Coimbra");
		   inst1.setLocation("Coimbra");
		   inst1.setDepartment("Ensino");
		   
		   
		   Institution inst2 = new Institution();
		   inst2.setName("Universidade de Lisboa");
		   inst2.setLocation("Lisboa");
		   inst2.setDepartment("Investigação");
		   
		   Institution inst3 = new Institution();
		   inst3.setName("Universidade do Porto");
		   inst3.setLocation("Porto");
		   inst3.setDepartment("Desporto");
		   
		   
		  
		   
		   Researcher res1  = new Researcher();
		   res1.setPersonName("Manuel Afonso");
		   res1.setReads(2);
		   res1.setCitations(3);
		   
		   res1.setInstitutionSet(inst1);
		   inst1.addResearcher(res1);
		   
		   
		   
		   Researcher res2  = new Researcher();
		   res2.setPersonName("Henrique Ribeiro");
		   res2.setReads(4);
		   res2.setCitations(1);
		   res2.setInstitutionSet(inst1);
		   inst1.addResearcher(res2);
		   
		   Researcher res3  = new Researcher();
		   res3.setPersonName("Joaquim Garcia");
		   res3.setReads(5);
		   res3.setCitations(6);
		   
		   res3.setInstitutionSet(inst2);
		   inst2.addResearcher(res3);
		   
		   Researcher res4  = new Researcher();
		   res4.setPersonName("Antonio Ribeiro");
		   res4.setReads(1);
		   res4.setCitations(3);
		   res4.setInstitutionSet(inst2);
		   inst2.addResearcher(res4);
		   
		   Researcher res5  = new Researcher();
		   res5.setPersonName("Nuno Lopes");
		   res5.setReads(3);
		   res5.setCitations(2);
		   res5.setInstitutionSet(inst3);
		   inst3.addResearcher(res5);
		   
		   Publication pub1 = new Publication();
		   pub1.setName("O estudo bom");
		   
		   
		   myset2.add(inst1);
		   myset2.add(inst2);
		   myset2.add(inst3);
		   myset.add(res1);
		   myset.add(res2);
		   myset.add(res3);
		   myset.add(res4);
		   myset.add(res5);
		   
		   if(myset2 != null) {
			   
			   for (Institution st : myset2){
				   entitymanager.persist(st);
			   }
		   }
		  
		   //Get Publication Entity
		   if(myset3 != null) {
			   for (Publication st : myset3){
				   entitymanager.persist(st);
			   }
			   
		   }
  
		   //Get Researcher Entity
		   
		   if(myset != null) {
			   for (Researcher st : myset){

				   entitymanager.persist(st);
				}
		   }
		   
		   
		   //Get Skill Entity
		   
		   if(myset4 != null) {
			   for (Skill st : myset4){
				   entitymanager.persist(st);
				}
		   }
		   entitymanager.getTransaction( ).commit( );
		   entitymanager.close( );
		   emfactory.close( );
		   }

}
