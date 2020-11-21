package common;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity(name = "Researcher")
@Table(name = "researcher")
public class Researcher implements Serializable {
	private static final long serialVersionUID = 1L;
	// we use this generation type to match that of SQLWriteStudents
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	private String personName;
	private int reads;
	private int citations;
    
    @ManyToOne(targetEntity = Institution.class)
    private Set<Institution> institutions;
    @ManyToMany(targetEntity = Publication.class)
    private Set<Publication> publications;
    @ManyToMany(targetEntity = Skill.class)
    private Set<Skill> skills;
	
	
	
	public Researcher(){}
	
	public Researcher(String name, int reads, int citations)
	{
		this.personName = name;
		this.setReads(reads);
		this.setCitations(citations);
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getPersonName() {
        return personName;
    }
	
    public void setPersonName(String value) {
        this.personName = value;
    }


	
	public Set<Institution> getInstitutionSet() {
	    return institutions;
	}
	   
	public void setInstitutionSet(Set<Institution> InstitutionSet) {
	    this.institutions = InstitutionSet;
	 }
	
	public Set<Publication> getResearchSet() {
	    return publications;
	}
	   
	public void setResearchSet(Set<Publication> PublicationSet) {
	    this.publications = PublicationSet;
	 }

	public Set<Skill> getSkillSet() {
	    return skills;
	}
	   
	public void setSkillSet(Set<Skill> SkillSet) {
	    this.skills = SkillSet;
	 }
	

	public int getCitations() {
		return citations;
	}

	public void setCitations(int citations) {
		this.citations = citations;
	}

	public int getReads() {
		return reads;
	}

	public void setReads(int reads) {
		this.reads = reads;
	}
    @Override
	public String toString()
	{
		return "Researcher " + id + ": " + personName + "\n";
	}


}
