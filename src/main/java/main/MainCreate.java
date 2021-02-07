package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Novela;
import entities.Personaje;

/**
 * Ejemplo crear objetos en operación OneToOne
 * @author Alan
 */
public class MainCreate {

	public static void main(String[] args) {

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("crearspring");
		EntityManager manager = managerFactory.createEntityManager();
		
		// Creamos nuevos objetos
		Novela novela = new Novela();
		novela.setAnotacion("anotado");
		novela.setCategoriaIdFk(null);
		novela.setDescripciong("Buena");
		novela.setDescripcionp("Buena");
		novela.setImagen("www");
		novela.setNombre("nom");
		novela.setNotas("dd");
		novela.setPrecio(44);
		novela.setVotos(33);
		
		

		

		// Guardar nuevos usuarios (método persist())
		try{
			// Se inicia una transacción
			manager.getTransaction().begin();   
			// Se persisten los objetos
			manager.persist(novela); 
			// Se realiza commit para hacer efectivas las inserciones
			manager.getTransaction().commit();    
		}catch(Exception ex){
			ex.printStackTrace();
			manager.getTransaction().rollback();   
		}finally{
			manager.close();
			managerFactory.close();
		}
	}

}
