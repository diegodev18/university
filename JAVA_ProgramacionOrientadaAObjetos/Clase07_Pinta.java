public class Clase07_Pinta {
    public static void main(String[] args) {
        int len = 30;
        String name = "Diego Sanchez";

        // System.out.println(Clase07_AnsiColors.PURPLE.TXT + Clase07_AnsiColors.WHITE.BG);
        // System.out.println(Clase07_Tabla.TOPLEFT + Clase07_Tabla.HORIZONTAL + Clase07_Tabla.HORIZONTAL + name);
        // System.out.println(Clase07_Tabla.HORIZONTAL + Clase07_Tabla.HORIZONTAL + Clase07_Tabla.TOPRIGHT);
        // System.out.println(Clase07_AnsiColors.RESET);

        System.out.print(Clase07_AnsiColors.WHITE.TXT);
        System.out.print(Clase07_Tabla.TOPLEFT);
        print_line((len - name.length() - 2) / 2, 'h');
        System.out.print(" " + name + " ");
        print_line((len - name.length() - 2) / 2, 'h');
        System.out.print(Clase07_Tabla.TOPRIGHT);
        for (int i = 0; i < 5; i++) {
            print_borders(len);
        }
        System.out.println();
        System.out.print(Clase07_Tabla.BOTTOMLEFT);
        print_line(31, 'h');
        System.out.print(Clase07_Tabla.BOTTOMRIGHT);
        System.out.println(Clase07_AnsiColors.RESET);
    }

    private static void print_line(int len, char position) {
        for (int i = 0; i < len; i++) {
            if (position == 'h') {
                System.out.print(Clase07_Tabla.HORIZONTAL);
            } else if (position == 'v') {
                System.out.print(Clase07_Tabla.VERTICAL);
            }
        }
    }

    private static void print_borders(int space_len) {
        System.out.println();
        System.out.print(Clase07_Tabla.VERTICAL);
        for (int i = 0; i < space_len; i++) {
            System.out.print(" ");
        }
        System.out.print(Clase07_Tabla.VERTICAL);
    }
}
