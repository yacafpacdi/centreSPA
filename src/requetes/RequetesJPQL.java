package requetes;

import entites.Animal;
import entites.Soigneur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RequetesJPQL {

    public static void main(String[] args) {
        System.out.println("=================DEBUT=======================");

        //pour obtenir l'entityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centreSPAPU");
        EntityManager em = emf.createEntityManager();
        Outils<Soigneur> os = new Outils<>();
        Outils<Animal> oa = new Outils<>();

        System.out.println("1) tous les soigneurs");
        String req = "select s from Soigneur s";
        Query qr = em.createQuery(req);
        List<Soigneur> ls = qr.getResultList();
        os.afficher(ls);
        System.out.println(">>>>> date de naissance de ls(0) ");
        System.out.println(ls.get(0).getNaissance());

        String race = "chien";
        System.out.println("2) tous les animaux de race = " + race);
        req = "select a from Animal a where a.race = :raceParam";
        qr = em.createQuery(req);
        qr.setParameter("raceParam", race);
        List<Animal> la = qr.getResultList();
        oa.afficher(la);

        System.out.println("3) tous les soigneurs qui soignent un " + race);
        req = "select distinct a.soigneurs from Animal a where a.race= :raceParam"; // distinct pour éliminer les doublons
        qr = em.createQuery(req);
        qr.setParameter("raceParam", race);
        ls = qr.getResultList();
        os.afficher(ls);
        //System.out.println(">>>>> qr = " + qr + "\n");

        Integer age = 1;
        System.out.println("4) tous les animaux qui ont au moins  " + age + " ans");
        req = "select a from Animal a where a.age >= :ageParam";
        qr = em.createQuery(req);
        qr.setParameter("ageParam", age);
        //pagination
//        int debut = 2;
//        int qteParPage =2;
//        qr.setFirstResult(debut);//premier élément à afficher 
//        qr.setMaxResults(qteParPage);// nombre d'éléments dans la page
        la = qr.getResultList();
        oa.afficher(la);

        
        Long id = 3L;
        System.out.println("5) tous les animaux d'un soigneur id = "+id);
        System.out.println("5.1) avec un objet");
        Soigneur s01 = em.find(Soigneur.class, id);
        req = "select s.animaux from Soigneur s where s= :soigneurParam";
        qr = em.createQuery(req);
        qr.setParameter("soigneurParam", s01);
        la = qr.getResultList();
        oa.afficher(la);
        
        System.out.println("5.2) avec l'id");
        req = "select s.animaux from Soigneur s where s.id= :idParam";
        qr = em.createQuery(req);
        qr.setParameter("idParam", id);
        la = qr.getResultList();
        oa.afficher(la);
        
        int qte=1;
        System.out.println("6) tous les soigneurs qui soignent au moins " + qte+ " animaux");
        req = "select distinct s from Soigneur s where SIZE(s.animaux) >= :qteParam"; // distinct pour éliminer les doublons
        qr = em.createQuery(req);
        System.out.println(">>>>> qr = " + qr + "\n");
        qr.setParameter("qteParam", qte);
        ls = qr.getResultList();
        os.afficher(ls);
        
        id = 3L;
        System.out.println("7) tous les soigneurs qui travaillent le centre id =  " + id);
        req = "select a.soigneurs from Animal a where a.centre.id = :idParam"; // distinct pour éliminer les doublons
        qr = em.createQuery(req);
        System.out.println(">>>>> qr = " + qr + "\n");
        qr.setParameter("idParam", id);
        ls = qr.getResultList();
        os.afficher(ls);
        
        
        em.close();
        emf.close();
        System.out.println("=================FIN=======================");

    }

}
