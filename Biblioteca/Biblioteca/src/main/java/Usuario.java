
import java.util.ArrayList;
import java.util.List;


//@author juanj

public class Usuario {
    String nombre;
    int edad;
    String [] apellidos = new String[2];
    List<Libro> biblio = new ArrayList<>();
    
    public Usuario(){ //Metodo Constructor
        nombre = "David";
        edad = 30;
        apellidos[0] = "Perez";
        apellidos[1] = "Martinez";
    }
    public Usuario(String nombre, int edad, String apellido1, String apellido2){
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos[0] = apellido1;
        this.apellidos[1] = apellido2;
    }
    
    public void prestado(Libro libro){
        biblio.add(libro);
    }
}

