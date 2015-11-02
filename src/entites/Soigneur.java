package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class Soigneur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;
    @Column(length = 100, name = "PRENOM_SOIGNEUR")
    private String prenom;
    @Column(length = 3)
    private String civilite;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date naissance;

    //pour traduire les associations 
    // utiliser les dépendances : pour les collections, le fetch est en lazy par defaut
    @ManyToMany
    private Collection<Animal> animaux; //mettre obligatoirement Collection et non pas List ou ArrayList

    @Embedded
    private Adresse adresse;

    public Soigneur() {
        animaux = new ArrayList<>();
    }

    public Soigneur(String nom, String prenom, String civilite, Date naissance) {
        this(); // on intègre ce qu'il y a dans le constructeur par défaut
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.naissance = naissance;
    }

    //chaque soigneur soigne plusieurs animaux
    public Collection<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Collection<Animal> animaux) {
        this.animaux = animaux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soigneur)) {
            return false;
        }
        Soigneur other = (Soigneur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom + "(" + id + ")";
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

}
