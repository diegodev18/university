package Actividad4;

public class TiposDeTexto {
    public static void H1(String texto, int espacios) {
        System.out.println(
            Colores.BLUE.TXT +
            Tabla.HORIZONTAL.repeat(espacios) +
            " " + texto + " " +
            Tabla.HORIZONTAL.repeat(espacios) +
            Colores.RESET
        );
    }

    public static void H2(String texto, int espacios) {
        System.out.println(
            Colores.GREEN.TXT +
            Tabla.HORIZONTAL.repeat(espacios) +
            " " + texto + " " +
            Tabla.HORIZONTAL.repeat(espacios) +
            Colores.RESET
        );
    }

    public static void H3(String texto, int espacios) {
        System.out.println(
            Colores.YELLOW.TXT +
            Tabla.HORIZONTAL.repeat(espacios) +
            " " + texto + " " +
            Tabla.HORIZONTAL.repeat(espacios) +
            Colores.RESET
        );
    }

    public static void LI(String texto, int id) {
        System.out.println(
            Colores.PURPLE.TXT +
            id + ".- " +
            Colores.RESET +
            texto
        );
    }

    public static void INPUT(String texto) {
        System.out.print(
            Colores.CYAN.TXT +
            texto +
            Colores.RESET
        );
    }
}
