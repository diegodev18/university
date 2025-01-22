import java.util.ArrayList;

public class Clase04 {
    public static void main(String args[]) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Luis");
        nombres.add("Daniel");
        nombres.add("Aranza");
        nombres.add("Cuasimodo");
        System.out.println("Los alumnos son: " + nombres);

        // Read
        System.out.println("Luis esta en el arreglo? " + nombres.contains("Luis"));
        System.out.println("Luis esta en => " + nombres.indexOf("Luis"));

        // Update
        int indice = nombres.indexOf("Luis");
        nombres.set(indice, "Luis Angel");
        System.out.println("Los alumnos son: " + nombres);

        // Delete
        System.out.println("Eliminando elemento 0...");
        nombres.remove(0);
        System.out.println("Los alumnos son: " + nombres);
        
    }
}
