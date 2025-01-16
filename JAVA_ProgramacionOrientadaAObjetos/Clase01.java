package JAVA_ProgramacionOrientadaAObjetos;

public class Clase01 {
    public static void main(String[] args) {
        int numero = 10;
        int edad = 15;
        double decimal = 20.5;
        char character = 'A';
        String cadena = "Hola Mundo";
        boolean bandera = true;
        int MAYORIA_DE_EDAD = 18; // Constante -> No se puede modificar -> Mayusculas

        // Estrucutra de control

        /**
         * > Mayor que
         * < Menor que
         * >= Mayor o igual
         * <= Menor o igual
         * == Igual
         * =! Diferente
         * 
         */

        if (edad <= MAYORIA_DE_EDAD) {
            System.out.println("Eres menor de edad");
        } else {
            System.out.println("Eres mayor de edad");
        }
    }
}