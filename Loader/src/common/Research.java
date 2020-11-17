package common;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity(name = "Research")
@Table(name = "research")
public class Research implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 	
	private long id;
	private String name;
	private String type;
   	private String date;
   	private String description;
   
   	@ManyToMany(targetEntity=Researcher.class)
   	private Set<Researcher> researchers;
   	
   	public Research() {
   		
   	}
   	
   	public Research(String name, String type, String date, String description) {
   		this.name=name;
   		this.type=type;
   		this.date=date;
   		this.description=description;
   	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Researcher> getResearcherSet() {
	      return researchers;
	   }
	   
	   public void setResearcherSet(Set<Researcher> ResearcherSet) {
	      this.researchers = ResearcherSet;
	   }

}
