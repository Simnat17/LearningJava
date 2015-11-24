package music;

import javax.persistence.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
    
    	// creazione connessione...e db
    	EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("$objectdb/db/points.odb");
            EntityManager em = emf.createEntityManager();
            
            // inizio transazione
            em.getTransaction().begin();
            
            
            //creazione lista canzoni di prova
            List<Song> songs = new ArrayList<Song>();
            songs.add(new Song("Façade of reality",511));
            songs.add(new Song("Fear of the dark",440));
            songs.add(new Song("Come mai",259));
            
            //associo gli oggetti alla connessione
    		for (Song s : songs) {
    			em.persist(s);;
    		}
            // commit :D
            em.getTransaction().commit();

    		// 3 query
    		Query q1 = em.createQuery("SELECT COUNT(s) FROM Song s");
    		System.out.println("Canzoni totali: "+q1.getSingleResult());
    		
    		Query q2 = em.createQuery("SELECT AVG(length) FROM Song s");
    		System.out.println("Lunghezza media: "+q2.getSingleResult());
    		
    		TypedQuery<Song> q3 = em.createQuery("Select s FROM Song s",Song.class);
    		List <Song> results = q3.getResultList();
    		
    		for (Song s : results){
    			System.out.println(s);
    		}
    		
    		
    		
            
            // chiusura connessione
            em.close();
    		emf.close();
    }
}
