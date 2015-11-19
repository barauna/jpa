import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	private static EntityManager em = emf.createEntityManager();
 
	public static void main(String[] args) throws Exception {
		int max = getMaxId();
		save(new Item(max+1, "Barah"));
		find(1);
		find(4);
		em.close();
		emf.close();
	}

	private static int getMaxId() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stmt = con.createStatement();
		String SQL = "select max(id) as max from test";
		ResultSet result = stmt.executeQuery(SQL);
		int max = 0;
		while(result.next()) {
			max = result.getInt("max");
			System.out.println("max:" + max);
		}
		con.close();
		return max;
	}
	
	public static void save(Item item){
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	public static void find(int id){
		Item item = em.find(Item.class, id);
		System.out.println("...item encontrado...");
		System.out.println(item);
	}

}
