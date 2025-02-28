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

        LimpiarPantalla();

        while (true) {
            opcion = Menu();
            if (opcion == 5) break;

            System.out.println();

            int id = 0;
            switch (opcion) {
                case 1:
                    TiposDeTexto.H2("Agregar videojuego", 4);
                    System.out.print("Nombre del videojuego > ");
                    String nombre = sc.nextLine();
                    NuevoVideojuego(nombre, contador++);
                    System.out.println("Videojuego agregado: " + nombre + " con ID " + (contador - 1));
                    break;

                case 2:
                    ListaElementos(videojuegos);
                    break;
                
                case 3:
                    TiposDeTexto.H2("Actualizar nombre de videojuego", 8);
                    ListaElementos(videojuegos);
                    System.out.print("ID del videojuego a actualizar > ");
                    id = sc.nextInt();
                    sc.nextLine();
                    String anteriorNombre = videojuegos.get(id - 1).getNombre();
                    System.out.print("Nuevo nombre > ");
                    videojuegos.get(id - 1).setNombre(sc.nextLine());
                    System.out.println("Nombre actualizado de " + anteriorNombre + " a " + videojuegos.get(id - 1).getNombre());
                    break;
                
                case 4:
                    TiposDeTexto.H2("Eliminar videojuego", 8);
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
        TiposDeTexto.H1("Menu", 10);
        System.out.print("1.- Nuevo videojuego\n2.- Listar videojuegos\n3.- Actualizar nombre de videojuego\n4.- Eliminar videojuego\n5.- Salir\nOpcion > ");
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    private static void ListaElementos(List<Videojuego> videojuegos) {
        TiposDeTexto.H3("Elementos", 10);
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

    private class TiposDeTexto {
        public static void H1(String texto, int espacios) {
            System.out.println(
                Colores.BLUE.TXT +
                "=".repeat(espacios) +
                " " + texto + " " +
                "=".repeat(espacios) +
                Colores.RESET
            );
        }

        public static void H2(String texto, int espacios) {
            System.out.println(
                Colores.GREEN.TXT +
                "=".repeat(espacios) +
                " " + texto + " " +
                "=".repeat(espacios) +
                Colores.RESET
            );
        }

        public static void H3(String texto, int espacios) {
            System.out.println(
                Colores.YELLOW.TXT +
                "=".repeat(espacios) +
                " " + texto + " " +
                "=".repeat(espacios) +
                Colores.RESET
            );
        }
    }
}
