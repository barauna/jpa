import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) throws Exception {
		int max = getMaxId();
		getJPA(max);
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
	
	public static void getJPA(int max){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Teste t = new Teste();
		t.setId(max+1);
		t.setName("Leoanrdo"+(max+1));
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
