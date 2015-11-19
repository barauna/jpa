import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST")
public class Item {

	@Id
	private int id;
	private String name;

	public Item(){}
	
	public Item(int id, String name){
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
