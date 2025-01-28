public class Clase06 {
    public static void main(String[] args) {
        /* char arreglo[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        } */

        String cadena = "Martes de tacos";
        
        System.out.println(cadena);
        System.out.println("Verifica si termina en s -> " + cadena.trim().endsWith("s"));
        System.out.println("Buscar de -> " + cadena.contains("de"));
        System.out.println("Limpia espacios extra -> " + cadena.trim());
        System.out.println("Remplazar s por _ -> " + cadena.replace("s", "_"));
        System.out.println("Compara -> " + cadena.equals("Martes de tacos"));
        System.out.println("Compara -> " + cadena.equalsIgnoreCase("martes de tacos"));
        System.out.println("Subcadena -> " + cadena.substring(7));
        System.out.println("Subcadena -> " + cadena.substring(7, 12));
        System.out.println("Tamaño -> " + cadena.length());
        System.out.println("Mayusculas -> " + cadena.toUpperCase());
        System.out.println("Minusculas -> " + cadena.toLowerCase());
        System.out.println("Caracter en la posicion 5 -> " + cadena.charAt(5));
        System.out.println("Posicion de la letra e -> " + cadena.indexOf("e"));
        System.out.println("Posicion de la letra e -> " + cadena.lastIndexOf("e"));
    }
}
