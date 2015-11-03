package requetes;

import java.util.List;


public class Outils<T> {
    
    public void afficher(List<T> list){
        for (T t : list) {
            System.out.println(t);
            
        }
        
    }
    
}
