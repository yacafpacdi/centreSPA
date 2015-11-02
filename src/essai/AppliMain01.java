package essai;

import entites.Adresse;
import entites.Animal;
import entites.Centre;
import entites.Soigneur;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppliMain01 {

    public static void main(String[] args) {
        System.out.println("=================DEBUT=======================");

        //pour obtenir l'entityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centreSPAPU");

        EntityManager em = emf.createEntityManager();

        //jeu de tests
        Date d01 = new GregorianCalendar(1987, 4, 15, 10, 33, 22).getTime();
        Soigneur s01 = new Soigneur("nom 01", "prenom 01", "M", d01);

        Date d02 = new GregorianCalendar(1988, 8, 27).getTime();
        Soigneur s02 = new Soigneur("nom 02", "prenom 02", "F", d02);

        Date d03 = new GregorianCalendar(1989, 8, 27).getTime();
        Soigneur s03 = new Soigneur("nom 03", "prenom 03", "M", d02);

        Animal a01 = new Animal("titi", "canari", 4);
        Animal a02 = new Animal("toto", "pigeon", 2);
        Animal a03 = new Animal("tata", "chien", 5);
        Animal a04 = new Animal("pif", "chien", 3);
        Animal a05 = new Animal("hercule", "chien", 6);
        Animal a06 = new Animal("miou", "chat", 7);

        Centre c01 = new Centre("Centre 3 étoiles", 150);
        Centre c02 = new Centre("Centre du parc", 200);
        Centre c03 = new Centre("Centre de gravité", 75);

        Adresse adr01 = new Adresse("23bis", "rue des plages", "Paris", "75000");

        //associations
        s01.getAnimaux().add(a01);
        s01.getAnimaux().add(a02);
        s02.getAnimaux().add(a01);
        s02.getAnimaux().add(a03);
        s03.getAnimaux().add(a03);

        a01.setCentre(c03);
        a02.setCentre(c03);
        a03.setCentre(c01);
        a04.setCentre(c02);
        a05.setCentre(c03);
        a06.setCentre(c01);
        c01.setAdresse(adr01);

        //direction secondaire (animal-->soigneur) donc non répercuté dans la BDD à cause du mappedby dans la classe Animal
        a06.getSoigneurs().add(s02);
        System.out.println("1) après création : s01 = " + s01);

        //gestion des entites
        em.persist(a01);
        em.persist(a02);
        em.persist(a03);
        em.persist(a04);
        em.persist(s01); // l'entityManager met l'objet s01 dans le contexte de persistence (un sac)
        em.persist(s02);
        em.persist(s03);
        em.persist(a06);
        em.persist(c01);
        em.persist(c02);
        em.persist(c03);

        EntityTransaction et = em.getTransaction(); // pour mettre dans la BDD
        et.begin();
        et.commit();

        em.close();
        emf.close();
        System.out.println("=================FIN=======================");
    }

}
