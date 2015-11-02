package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;
    @Column(length = 55)
    private String race;
    private Integer age;

    //associations
    @ManyToMany(mappedBy = "animaux")
    private Collection<Soigneur> soigneurs;

    @ManyToOne
    private Centre centre;

    public Animal() {
        soigneurs = new ArrayList<>();

    }

    public Animal(String nom, String race, Integer age) {
        this();
        this.nom = nom;
        this.race = race;
        this.age = age;
    }

    public Animal(String nom, String race, Integer age, Collection<Soigneur> soigneurs, Centre centre) {
        this.nom = nom;
        this.race = race;
        this.age = age;
        this.soigneurs = soigneurs;
        this.centre = centre;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Collection<Soigneur> getSoigneurs() {
        return soigneurs;
    }

    public void setSoigneurs(Collection<Soigneur> soigneurs) {
        this.soigneurs = soigneurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Animal[ id=" + id + " ]";
    }

}
