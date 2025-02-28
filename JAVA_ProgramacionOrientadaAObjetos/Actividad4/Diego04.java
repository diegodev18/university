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
            opcion = Menu.MainMenu();
            if (opcion == 5) break;

            System.out.println();

            switch (opcion) {
                case 1:
                    Menu.Agregar();
                    break;

                case 2:
                    ListaElementos(videojuegos);
                    break;
                
                case 3:
                    Menu.Actualizar();
                    break;
                
                case 4:
                    Menu.Eliminar();
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

    private static int ObtenerNumero(String mensaje, boolean limpiar) {
        while (true) {
            try {
                System.out.print(mensaje);
                int num = sc.nextInt();
                if (limpiar) sc.nextLine();
                return num;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.nextLine();
            }
        }
    }

    private class Menu {
        public static int MainMenu() {
            int opcion;
            TiposDeTexto.H1("Menu", 10);
            System.out.println("1.- Nuevo videojuego\n2.- Listar videojuegos\n3.- Actualizar nombre de videojuego\n4.- Eliminar videojuego\n5.- Salir");
            opcion = ObtenerNumero("Opcion > ", false);
            sc.nextLine();
            return opcion;
        }

        public static void Agregar() {
            TiposDeTexto.H2("Agregar videojuego", 4);
            System.out.print("Nombre del videojuego > ");
            String nombre = sc.nextLine();
            NuevoVideojuego(nombre, contador++);
            System.out.println("Videojuego agregado: " + nombre + " con ID " + (contador - 1));
        }

        public static void Actualizar() {
            TiposDeTexto.H2("Actualizar nombre de videojuego", 8);
            ListaElementos(videojuegos);
            int id = ObtenerNumero("ID del videojuego a actualizar > ", true);
            String anteriorNombre = videojuegos.get(id - 1).getNombre();
            System.out.print("Nuevo nombre > ");
            videojuegos.get(id - 1).setNombre(sc.nextLine());
            System.out.println("Nombre actualizado de " + anteriorNombre + " a " + videojuegos.get(id - 1).getNombre());
        }

        public static void Eliminar() {
            TiposDeTexto.H2("Eliminar videojuego", 8);
            ListaElementos(videojuegos);
            int id = ObtenerNumero("ID del videojuego a eliminar > ", true);
            String nombre4 = videojuegos.get(id - 1).getNombre();
            videojuegos.remove(id - 1);
            System.out.println("Videojuego " + nombre4 + " eliminado");     
        }
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
