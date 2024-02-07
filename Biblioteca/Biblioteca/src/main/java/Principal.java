
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@author juanj
public class Principal {

    public static void main(String[] args) {

        /*    Usuario user1 = new Usuario();
        System.out.println(user1.nombre);
        System.out.println(user1.edad);
        
        Usuario user = new Usuario("Jose",40,"Sanchez","Gonzalez");
        System.out.println(user.nombre);
        System.out.println(user.edad); */
        Scanner sc = new Scanner(System.in);
        List<Libro> biblioteca = new ArrayList<>();
        List<Libro> resultados = new ArrayList<>();

        anadirLibro(biblioteca, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605);
        anadirLibro(biblioteca, "Hamlet", "William Shakespeare", 1603);
        anadirLibro(biblioteca, "El Hobbit", "J. R. R. Tokien", 1937);
        anadirLibro(biblioteca, "Frankestein", "Mary Shelley", 1818);
        anadirLibro(biblioteca, "Orgullo y Prejuicio", "Jane Austen", 1913);
        anadirLibro(biblioteca, "Mujercita", "Louisa", 1868);

        anadirLibro(biblioteca, "La vuelta al mundo en 80 días", "Julio Verne", 1872);
        anadirLibro(biblioteca, "Veinte Mil leguas de viaje submarino", "Julio Verne", 1605);
        anadirLibro(biblioteca, "Harry Potter y la Piedra Filosofal", "J. K. Rowling", 1997);
        anadirLibro(biblioteca, "El Imperio Final", "Brandon Sanderson", 2018);
        anadirLibro(biblioteca, "Estudio en Escarlata", "Arthur Conan Doyle", 1887);

        System.out.println("Bienvenido a la bilbioteca municipal. Por favor, identifiquese.");
        System.out.println("Nombre: ");
        String nombreUsuario = sc.nextLine();
        System.out.println("Primer Apellido : ");
        String apellido1Usuario = sc.nextLine();
        System.out.println("Segundo Apellido : ");
        String apellido2Usuario = sc.nextLine();
        System.out.println("Edad: ");
        int edad;
        while (true) {
            try {
                edad = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Valor no válido. Por favor, escriba un número.");
            }
        }

        Usuario user = new Usuario(nombreUsuario, edad, apellido1Usuario, apellido2Usuario);

        System.out.println("Hola " + user.nombre);
        System.out.println("Estos son los libros que tenemos disponibles: ");
        for(int i = 0;i < biblioteca.size(); i++){
            System.out.println("");
            System.out.println(i+1 + ".");
            System.out.println(biblioteca.get(i).titulo);
            System.out.println(biblioteca.get(i).autor);
            System.out.println(biblioteca.get(i).anyo);
        }
        System.out.println("¿Que libro deseas?");
        String busqueda = sc.nextLine();
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).titulo.contains(busqueda)) {
                resultados.add(biblioteca.get(i));
            }
        }
        System.out.println("Estas son las coincidencias: ");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("");
            System.out.println(i + 1 + ".");
            System.out.println(resultados.get(i).titulo);
            System.out.println(resultados.get(i).autor);
            System.out.println(resultados.get(i).anyo);
        }
        System.out.println("¿Que libro quieres coger prestado?");
        int elegido;
        while (true) {
            try {
                elegido = Integer.parseInt(sc.nextLine());
                if ((elegido - 1) >= resultados.size() || elegido < 0) {
                    System.out.println("Valor no válido. Por favor, escriba un número.");
                } else {
                    break;
                }
                break;
            } catch (Exception e) {
                System.out.println("Valor no válido. Por favor, escriba un número.");
            }
        }

        user.prestado(resultados.get(elegido-1));

        for (int i = 0; i < user.biblio.size(); i++) {
            System.out.println("");
            //System.out.println(i+1 + ".");
            System.out.println(user.biblio.get(i).titulo);
            System.out.println(user.biblio.get(i).autor);
            System.out.println(user.biblio.get(i).anyo);
        }
        sc.close();
    }

    static void anadirLibro(List<Libro> biblioteca, String titulo, String autor, int anyo) {
        Libro libro = new Libro(titulo, autor, anyo);
        biblioteca.add(libro);

    }

}
