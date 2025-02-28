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

            TiposDeTexto.INPUT("Presione ENTER para continuar...");
            sc.nextLine();
            LimpiarPantalla();
        }

        sc.close();
    }

    private static void ListaElementos(List<Videojuego> videojuegos) {
        TiposDeTexto.H3("Elementos", 10);
        for (Videojuego elemento : videojuegos) {
            TiposDeTexto.LI(elemento.getNombre(), elemento.getId());
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
                TiposDeTexto.INPUT(mensaje);
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
            String[] opciones = {
                "Nuevo videojuego",
                "Listar videojuegos",
                "Actualizar videojuego",
                "Eliminar videojuego",
                "Salir"
            };
            TiposDeTexto.H1("Menu", 10);
            for (int i = 0; i < opciones.length; i++) {
                TiposDeTexto.LI(opciones[i], i + 1);
            }
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
            TiposDeTexto.INPUT("Nuevo nombre > ");
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
}
