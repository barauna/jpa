import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Poco {
	@Id
	int id;
	String name;
	@ManyToOne
	Plataforma plataforma;
	
	public Poco(){}
	
	public Poco(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
}