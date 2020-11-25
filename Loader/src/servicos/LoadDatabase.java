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
		   
		   
		   
		   Researcher res2  = new Researcher();
		   res2.setPersonName("Henrique Ribeiro");
		   res2.setReads(4);
		   res2.setCitations(1);
		   res2.setInstitutionSet(inst1);
		   
		   Researcher res3  = new Researcher();
		   res3.setPersonName("Joaquim Garcia");
		   res3.setReads(5);
		   res3.setCitations(6);
		   
		   res3.setInstitutionSet(inst2);
		   
		   Researcher res4  = new Researcher();
		   res4.setPersonName("Antonio Ribeiro");
		   res4.setReads(1);
		   res4.setCitations(3);
		   res4.setInstitutionSet(inst2);
		   
		   Researcher res5  = new Researcher();
		   res5.setPersonName("Nuno Lopes");
		   res5.setReads(3);
		   res5.setCitations(2);
		   res5.setInstitutionSet(inst3);
		   
		   Publication pub1 = new Publication();
		   pub1.setName("O estudo Volume II");
		   pub1.setType("Book");
		   pub1.setDate("November 2016");
		   res1.addPublication(pub1);
		   res5.addPublication(pub1);
		   
		   Publication pub2 = new Publication();
		   pub2.setName("O futuro da tecnologia");
		   pub2.setType("Conference Paper");
		   pub2.setDate("May 2009");
		   res3.addPublication(pub2);
		   res4.addPublication(pub2);
		   
		   Publication pub3 = new Publication();
		   pub3.setName("O passado da tecnologia");
		   pub3.setType("Conference Paper");
		   pub3.setDate("June 2019");
		   res3.addPublication(pub3);
		   res4.addPublication(pub3);
		   
		   Publication pub4 = new Publication();
		   pub4.setName("Ice Age");
		   pub4.setType("Article");
		   pub4.setDate("November 2011");
		   res2.addPublication(pub4);
		   res1.addPublication(pub4);
		   
		   Publication pub5 = new Publication();
		   pub5.setName("Hibernate para totós");
		   pub5.setType("Book");
		   pub5.setDate("January 2011");
		   res5.addPublication(pub5);
		   res2.addPublication(pub5);
		   
		   Publication pub6 = new Publication();
		   pub6.setName("JPA para totós");
		   pub6.setType("Book");
		   pub6.setDate("May 2013");
		   res1.addPublication(pub6);
		   res2.addPublication(pub6);
		   
		   Publication pub7 = new Publication();
		   pub7.setName("JavaBeans para totós");
		   pub7.setType("Book");
		   pub7.setDate("January 2015");
		   res1.addPublication(pub7);
		   res3.addPublication(pub7);
		   
		   Publication pub8 = new Publication();
		   pub8.setName("WebServices para totós");
		   pub8.setType("Book");
		   pub8.setDate("February 2013");
		   res1.addPublication(pub8);
		   res4.addPublication(pub8);
		   
		   Publication pub9 = new Publication();
		   pub9.setName("REST para totós");
		   pub9.setType("Book");
		   pub9.setDate("January 2012");
		   res2.addPublication(pub9);
		   res3.addPublication(pub9);
		   res5.addPublication(pub9);
		   
		   Publication pub10 = new Publication();
		   pub10.setName("JMS para totós");
		   pub10.setType("Book");
		   pub10.setDate("March 2014");
		   res2.addPublication(pub10);
		   res4.addPublication(pub10);
		   
		   Publication pub11 = new Publication();
		   pub11.setName("CDI para totós");
		   pub11.setType("Book");
		   pub11.setDate("December 2018");
		   res3.addPublication(pub11);
		   res5.addPublication(pub11);
		   
		   Publication pub12 = new Publication();
		   pub12.setName("XML para totós");
		   pub12.setType("Book");
		   pub12.setDate("June 2019");
		   res4.addPublication(pub12);
		   res5.addPublication(pub12);
		   
		   
		   Skill skill1 = new Skill();
		   skill1.setNome("Psychology"); 
		   
		   Skill skill2 = new Skill();
		   skill2.setNome("Technology");
		   
		   Skill skill3 = new Skill();
		   skill3.setNome("Java Programming");
		   
		   Skill skill4 = new Skill();
		   skill4.setNome("Geology");
		   
		   Skill skill5 = new Skill();
		   skill5.setNome("Sociology");
		   
		   
		   res1.addSkill(skill1);
		   res2.addSkill(skill4);
		   res2.addSkill(skill2);
		   res3.addSkill(skill5);
		   res3.addSkill(skill2);
		   res4.addSkill(skill5);
		   res4.addSkill(skill2);
		   res5.addSkill(skill3);
		   res5.addSkill(skill2);
		   
		   myset2.add(inst1);
		   myset2.add(inst2);
		   myset2.add(inst3);
		   
		   myset.add(res1);
		   myset.add(res2);
		   myset.add(res3);
		   myset.add(res4);
		   myset.add(res5);
		   
		   myset3.add(pub1);
		   myset3.add(pub2);
		   myset3.add(pub3);
		   myset3.add(pub4);
		   myset3.add(pub5);
		   myset3.add(pub6);
		   myset3.add(pub7);
		   myset3.add(pub8);
		   myset3.add(pub9);
		   myset3.add(pub10);
		   myset3.add(pub11);
		   myset3.add(pub12);
		   
		   
		   myset4.add(skill1);
		   myset4.add(skill2);
		   myset4.add(skill3);
		   myset4.add(skill4);
		   myset4.add(skill5);
		   
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
