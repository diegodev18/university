import java.util.ArrayList;
import java.util.Scanner;

public class Diego05 {
    static private Integer ancho = 78;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nuevoTexto = new ArrayList<String>();
        Integer nuevoTextoSize;

        System.out.print("Introduce el texto a centrar: ");
        String texto = sc.nextLine();
        nuevoTextoSize = ObtenerTextoArray(texto, nuevoTexto);
        System.out.println();

        LineaSuperior();
        CentraTexto("Programacion Orientada a Objetos");
        LineaMedia();
        LineaEspacios();
        LineaEspacios();
        for (int i = 0; i < nuevoTextoSize; i++) {
            CentraTexto(nuevoTexto.get(i));
        }
        LineaEspacios();
        LineaEspacios();
        LineaInferior();

        sc.close();
    }

    private static Integer ObtenerTextoArray(String texto, ArrayList<String> nuevoTexto) {
        int limite = ancho - 2;
        int last = 0;
        int nuevoTextoSize = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (i % limite == 0) {
                int end = Math.min(limite + i, texto.length());
                String substring = texto.substring(i, end);
                nuevoTexto.add(substring);
                last = i;
                nuevoTextoSize += 1;
            } else if (i == texto.length()) {
                String substring = texto.substring(last, texto.length());
                nuevoTexto.add(substring);
                nuevoTextoSize += 1;
                break;
            }
        }
        return nuevoTextoSize;
    }

    private static void CentraTexto(String texto) {
        Float nuevoAncho = (float) (ancho - texto.length()) / 2;
        int padding = nuevoAncho.intValue();
        if (nuevoAncho - padding > 0) padding += 1;
        System.out.println(Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.VERTICAL + Colores.RESET + " ".repeat(nuevoAncho.intValue()) + texto + " ".repeat(padding) + Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.VERTICAL + Colores.RESET);
    }

    private static void LineaSuperior() {
        System.out.print(Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.TOPLEFT);
        for (int i = 0; i < ancho; i++) {
            System.out.print(Tabla.HORIZONTAL);
        }
        System.out.println(Tabla.TOPRIGHT + Colores.RESET);
    }

    private static void LineaMedia() {
        System.out.print(Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.MIDDLELEFT);
        for (int i = 0; i < ancho; i++) {
            System.out.print(Tabla.HORIZONTAL);
        }
        System.out.println(Tabla.MIDDLERIGHT + Colores.RESET);
    }

    private static void LineaEspacios() {
        System.out.print(Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.VERTICAL + Colores.RESET);
        for (int i = 0; i < ancho; i++) {
            System.out.print(" ");
        }
        System.out.println(Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.VERTICAL + Colores.RESET);
    }

    private static void LineaInferior() {
        System.out.print(Colores.GREEN.BG + Colores.WHITE.TXT + Tabla.BOTTOMLEFT);
        for (int i = 0; i < ancho; i++) {
            System.out.print(Tabla.HORIZONTAL);
        }
        System.out.println(Tabla.BOTTOMRIGHT + Colores.RESET);
    }

}
