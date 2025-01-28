public class Clase06_02 {
    public static void main(String[] args) {
        String[] colors = { "\033[33m", "\033[0m", "\033[31m" };

        System.out.println("-".repeat(6) + colors[2] + " Tabla de pitagoras (del 0 al 10): " + colors[1] + "-".repeat(5));

        System.out.print(colors[0] + "X ");
        for (int i = 0; i <= 10; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println(colors[1]);

        for (int i = 0; i <= 10; i++) {
            System.out.print(colors[0] + i + " ".repeat(i < 10 ? 2 : 1) + colors[1]);
            for (int j = 0; j <= 10; j++) {
                System.out.print(" " + (i * j) + " ".repeat((i * j) < 10 ? 2 : 1));
            }
            System.out.println();
        }

        System.out.println("-".repeat(47));
    }
}
