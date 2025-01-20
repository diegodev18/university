import java.util.Scanner;

public class Clase03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Cual es tu nombre? ");
        String nombre = scanner.nextLine();
        System.out.println("Bienvenido " + nombre + "\n");
        
        boolean continuar = true;
        while (continuar) {
    
            System.out.println("Piensa en dos numeros!");
            System.out.print("Primer numero: ");
            Integer number1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Segundo numero: ");
            Integer number2 = Integer.parseInt(scanner.nextLine());
    
            System.out.print("\n--- Menu ---\n1) Suma\n2) Resta\n3) Multiplicacion\n4) Division\nOpcion: ");
            Integer operation = Integer.parseInt(scanner.nextLine());

            System.err.println("");

            if (operation == 1) { // Suma
                System.out.printf("Resultado de la suma %d + %d = %d\n", number1, number2, number1 + number2);
            } else if (operation == 2) { // Resta
                System.out.printf("Resultado de la resta %d - %d = %d\n", number1, number2, number1 - number2);
            } else if (operation == 3) { // Multiplicacion
                System.out.printf("Resultado de la mutiplicacion %d * %d = %d\n", number1, number2, number1 * number2);
            } else if (operation == 4 && number1 != 0 && number2 != 0) { // Division
                System.out.printf("Resultado de la division %d / %d = %d\n", number1, number2, number1 / number2);
            } else {
                System.out.println("Operacion no permitida!");
            }

            System.out.print("\nDeseas realizar otra operacion?  [S/n]: ");
            String opt = scanner.nextLine().toLowerCase();
            if (opt.toLowerCase().equals("s")) {
                continuar = true;
            } else {
                continuar = false;
            }

            System.out.println("");
        }

        scanner.close();
    }
}