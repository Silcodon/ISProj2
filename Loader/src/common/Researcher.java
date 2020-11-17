package common;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    private String introduction;
    
    @ManyToMany(targetEntity = Institution.class)
    private Set<Institution> institutions;
    @ManyToMany(targetEntity = Research.class)
    private Set<Research> researchs;
	
	
	public Researcher(){}
	
	public Researcher(String name, String intro)
	{
		this.personName = name;
		this.introduction = intro;
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


	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public Set<Institution> getInstitutionSet() {
	    return institutions;
	}
	   
	public void setInstitutionSet(Set<Institution> InstitutionSet) {
	    this.institutions = InstitutionSet;
	 }
	
	public Set<Research> getResearchSet() {
	    return researchs;
	}
	   
	public void setResearchSet(Set<Research> ResearchSet) {
	    this.researchs = ResearchSet;
	 }

    @Override
	public String toString()
	{
		return "Researcher " + id + ": " + personName + "\nAbout: " + introduction ;
	}

}
