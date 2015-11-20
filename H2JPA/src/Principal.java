import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Principal {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	private static EntityManager em = emf.createEntityManager();
 
	public static void main(String[] args) throws Exception {
		inicializaPlataformas();
		inicializarPocos();
		update(1, "Cidade Vitória");
		Plataforma p = find(1);
		em.refresh(p);
		System.out.println(p.pocos.get(0).getName());
		listarPlataformas();
		em.close();
		emf.close();
	}

	private static void inicializarPocos() {
		int id = 0;
		em.getTransaction().begin();
		while(id < 4){
			Poco p = new Poco("1-JUB-" + (++id));
			p.setPlataforma(find(1));
			em.persist(p);
		}
		em.getTransaction().commit();
		
	}

	private static void listarPlataformas() {
		TypedQuery<Plataforma> query = em.createNamedQuery("principal", Plataforma.class);
		List<Plataforma> lista = query.getResultList();
		for (Plataforma plataforma : lista) {
			System.out.println(plataforma);
		}
	}

	private static void inicializaPlataformas() throws ClassNotFoundException, SQLException {
		int id = 0;
		while (id < 10) {
			save(new Plataforma(++id, "P-" + id));
		}
	}

	public static void save(Plataforma item){
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	public static Plataforma find(int id){
		Plataforma plataforma = em.find(Plataforma.class, id);
		if (plataforma != null) {
			System.out.print("plataforma encontrada: ");
		}
		System.out.println(plataforma);
		return plataforma;
	}
	
	public static void update(int id, String novoNome){
		em.getTransaction().begin();
		Plataforma plataforma = find(id);
		plataforma.setName(novoNome);
		em.getTransaction().commit();
	}
	
	public static void delete(int id){
		Plataforma plataforma = find(id);
		if (plataforma != null){
			em.getTransaction().begin();
			em.remove(plataforma);
			em.getTransaction().commit();
		}
	}

}
