package entites;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String num;
    private String rue;
    private String ville;
    private String cp;

    public Adresse() {
    }

    public Adresse(String num, String rue, String ville, String cp) {
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    
    
    
    @Override
    public String toString() {
        return num +" "+ rue +" "+ ville +" "+ cp +" ";
    }
   

    
    
}
