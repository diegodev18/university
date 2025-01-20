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

        int dia = 1;
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;

            case 2:
                System.out.println("Martes");
                break;

            case 3:
                System.out.println("Miercoles");
                break;
        
            default:
                break;
        }

        // Ciclos
        // For -> Conocemos el numero de iteraciones
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // While -> No conocemos el numero de iteraciones
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
        // Do While -> Se ejecuta al menos una vez
        int j = 0;
        do {
            System.out.println(j);
            j++;
        } while (j < 10);
    }
}