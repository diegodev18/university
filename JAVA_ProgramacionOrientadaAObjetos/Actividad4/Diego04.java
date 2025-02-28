package Actividad4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diego04 {
    private static List<Videojuego> videojuegos = new ArrayList<>();
    private static int contador = 1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NuevoVideojuego("Fortnite", contador++);
        NuevoVideojuego("Minecraft", contador++);
        NuevoVideojuego("Among Us", contador++);
        int opcion = 0;

        while (true) {
            opcion = Menu();
            if (opcion == 5) break;

            int id = 0;
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del videojuego > ");
                    String nombre = sc.nextLine();
                    NuevoVideojuego(nombre, contador++);
                    System.out.println("Videojuego agregado: " + nombre);
                    break;

                case 2:
                    ListaElementos(videojuegos);
                    break;
                
                case 3:
                    ListaElementos(videojuegos);
                    System.out.print("ID del videojuego a actualizar > ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Videojuego videojuego = videojuegos.get(id - 1);
                    System.out.print("Nuevo nombre > ");
                    videojuegos.get(id - 1).setNombre(sc.nextLine());
                    System.out.println("Nombre actualizado de " + videojuego.getNombre() + " a " + videojuegos.get(id - 1).getNombre());
                    break;
                
                case 4:
                    ListaElementos(videojuegos);
                    System.out.print("ID del videojuego a eliminar > ");
                    id = sc.nextInt();
                    sc.nextLine();
                    String nombre4 = videojuegos.get(id - 1).getNombre();
                    videojuegos.remove(id - 1);
                    System.out.println("Videojuego " + nombre4 + " eliminado");                 
                    break;
            
                default:
                    break;
            }

            System.out.print("Presione ENTER para continuar...");
            sc.nextLine();
            LimpiarPantalla();
        }

        sc.close();
    }

    private static int Menu() {
        int opcion;
        System.out.print("1.- Nuevo videojuego\n2.- Listar videojuegos\n3.- Actualizar nombre de videojuego\n4.- Eliminar videojuego\n5.- Salir\nOpcion > ");
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    private static void ListaElementos(List<Videojuego> videojuegos) {
        System.out.println(" ==== Elementos ====");
        for (Videojuego elemento : videojuegos) {
            System.out.println(elemento.getId() + ".- " + elemento.getNombre());
        }
    }

    private static void NuevoVideojuego(String nombre, int id) {
        Videojuego elemento = new Videojuego(nombre, id);
        videojuegos.add(elemento);
    }

    private static void LimpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
