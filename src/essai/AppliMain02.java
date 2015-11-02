package essai;

import entites.Soigneur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppliMain02 {

    public static void main(String[] args) {
        System.out.println("=================DEBUT=======================");

        //pour obtenir l'entityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centreSPAPU");
        EntityManager em = emf.createEntityManager();

        Soigneur sg01 = em.find(Soigneur.class, 1L);
        System.out.println("1) sg01 = " + sg01);
        sg01.setNom("VETO");
        System.out.println("2) après modif sg01 = " + sg01);

        EntityTransaction et = em.getTransaction(); // pour mettre dans la BDD
        et.begin();
        et.commit();

        Soigneur sg02 = em.find(Soigneur.class, 2L);
        System.out.println("3) après lecture sg02 = " + sg02);

        //JOptionPane.showMessageDialog(null, "pause");
        //modif dans la base
        em.refresh(sg02);
        System.out.println("4) après modif en base sg02 = " + sg02);

        //les animaux du soigneur id=1
        System.out.println("animaux de sg01 :" + sg01.getAnimaux());

        em.close();
        emf.close();
        System.out.println("=================FIn=======================");
    }

}
