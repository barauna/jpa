import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Poco {
	@Id
	@GeneratedValue
	int id;


	String name;
	@ManyToOne
	Plataforma plataforma;
	
	public Poco(){}
	
	public Poco(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Plataforma getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
}