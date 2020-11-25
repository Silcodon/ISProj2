package common;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;


@Entity(name = "Institution")
@Table(name = "institution")
public class Institution implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
   @GeneratedValue( strategy= GenerationType.IDENTITY ) 	
   
   private long id;
   private String name;
   private String location;
   private String department;
   
   @OneToMany(targetEntity = Researcher.class,fetch=FetchType.EAGER)
   private Set<Researcher> researchers = new HashSet<Researcher>();
   
   public Institution() {
	   
   }
   
   public Institution(String name, String location, String department) {
	   this.setName(name);
	   this.setLocation(location);
	   this.setDepartment(department);
   }

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public void addResearcher(Researcher x) {
		this.researchers.add(x);
	}
	public Set<Researcher> getResearcherSet() {
	      return researchers;
	   }
	   
	   public void setResearcherSet(Set<Researcher> ResearcherSet) {
	      this.researchers = ResearcherSet;
	   }

   
}

