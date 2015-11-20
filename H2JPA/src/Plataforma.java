import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(query = "SELECT p FROM Plataforma p", name = "principal")
public class Plataforma {

	@Id
	private int id;
	private String name;

	public Plataforma(){}
	
	public Plataforma(int id, String name){
		this.id = id;
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
	
	@Override
	public String toString(){
		return this.id + ":" + this.name;
		
	}
}
