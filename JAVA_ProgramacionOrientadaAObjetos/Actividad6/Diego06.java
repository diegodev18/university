import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Diego06 {

    public static void main(String[] args) {
        /*
         * System.out.println("* Se hace un tiro un dado y se obtiene la suma.");
         * System.out.
         * println("* Se registran 200 tiros y cuantas veces se obtiene cada suma.");
         * System.out
         * .println("* Al final se deberan mostrar cuantas veces se obtuvo cada suma y su porcentaje graficado."
         * );
         * System.out.println();
         * System.out.println(AnsiColors.RED.BG + AnsiColors.WHITE.TXT +
         * "===== MEJORAS =====" + AnsiColors.RESET);
         * System.out
         * .println(AnsiColors.RED.BG + AnsiColors.WHITE.TXT +
         * "[ ] Solicitar cuantas veces se tirarán los dados."
         * + AnsiColors.RESET);
         * System.out.println(
         * AnsiColors.RED.BG + AnsiColors.WHITE.TXT +
         * "[ ] Mostrar al final cuantas veces se tiraron los dados."
         * + AnsiColors.RESET);
         * System.out.println(AnsiColors.RED.BG + AnsiColors.WHITE.TXT
         * + "[ ] Agregarle Formato (puede ser color y presentacion)" +
         * AnsiColors.RESET);
         * System.out.println(AnsiColors.RED.BG + AnsiColors.WHITE.TXT
         * +
         * "[ ] Mostrar caracteres tipo grafica de barras horizontal despues de escribir el porcentaje."
         * + AnsiColors.RESET);
         * System.out.println(AnsiColors.RED.BG + AnsiColors.WHITE.TXT
         * + "[ ] Presentar el porcentaje con 2 decimales."
         * + AnsiColors.RESET);
         */

        ArrayList<int[]> resultados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        LimpiarPantalla();

        System.out.println(AnsiColors.BLUE.TXT
                + "Bienvenido al programa de tirar dados.\nEn este programa, podras simular el lanzamiento de un dado, las veces que quieras para ver cuantas veces sale cada número."
                + AnsiColors.RESET + "\n");

        // Inicializar el ArrayList con los números del 1 al 6 y sus conteos en 0
        for (int i = 1; i <= 6; i++) {
            resultados.add(new int[] { i, 0 });
        }

        String mensaje = AnsiColors.YELLOW.TXT + "¿Cuántas veces quieres tirar los dados? " + AnsiColors.RESET
        + AnsiColors.WHITE.BG;
        int cantidadTiros = ObtenerNumero(sc, mensaje);
        System.out.print(AnsiColors.RESET);

        // Realizar 200 tiros
        System.out.println(AnsiColors.RED.TXT + "\nTirando dados...\n" + AnsiColors.RESET);
        for (int i = 0; i < cantidadTiros; i++) {
            int resultado = TirarDado();
            resultados.get(resultado - 1)[1]++;
        }

        // Mostrar resultados
        final int barraLength = 100;
        for (int[] resultado : resultados) {
            int numero = resultado[0];
            int conteo = resultado[1];
            String conteoFormateado = String.format("%03d", conteo);
            double porcentaje = (conteo / ((float) cantidadTiros)) * 100;
            String porcentajeFormateado = String.format("%05.2f", porcentaje);
            int barras = (int) ((conteo / (double) cantidadTiros) * barraLength);
            System.out.println(
                    "Número " + AnsiColors.BLUE.TXT + numero + AnsiColors.RESET +
                            " salió " + AnsiColors.PURPLE.TXT + conteoFormateado + AnsiColors.RESET +
                            " veces (" + AnsiColors.CYAN.TXT + porcentajeFormateado + "%) " + AnsiColors.BLUE.TXT +
                            AnsiColors.GREEN.BG + " ".repeat(barras) + AnsiColors.RESET);
        }

        System.out.println("\n" + AnsiColors.GREEN.TXT + "Se han tirado los dados un total de " + cantidadTiros
                + " veces." + AnsiColors.RESET + "\n");

        sc.close();
    }

    private static int TirarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Genera un número entre 1 y 6
    }

    private static int ObtenerNumero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println(AnsiColors.RESET + AnsiColors.RED.TXT + "Por favor, ingrese un número válido." + AnsiColors.RESET);
                sc.nextLine();
            }
        }

    }

    private static void LimpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
