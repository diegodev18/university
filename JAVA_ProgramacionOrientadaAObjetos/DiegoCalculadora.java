import java.util.Scanner;

public class DiegoCalculadora {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            get_and_print_name(scanner);
            
            boolean continuar;
            do {
                System.out.println("Piensa en dos numeros!");
                Double number1 = get_double(scanner, "Primer numero: ");
                Double number2 = get_double(scanner, "Segundo numero: ");
        
                int operation = get_int(scanner, "\n--- Menu ---\n1) Suma\n2) Resta\n3) Multiplicacion\n4) Division\nOpcion: ");
                scanner.nextLine();
    
                System.out.print("\n");
    
                make_operation(operation, number1, number2);
    
                System.out.print("\nDeseas realizar otra operacion?  [S/n]: ");
                String opt = scanner.nextLine();
                continuar = opt.toLowerCase().equals("s");

                clear_screen();
            } while (continuar);

            System.out.println("Adios, gracias por usar la calculadora!");
        }
    }

    private static void get_and_print_name(Scanner scanner) {
        System.out.print("Cual es tu nombre? ");
        String nombre = scanner.nextLine();
        System.out.println("Bienvenido " + nombre + "\n");
    }

    private static double get_double(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            try {
                return scanner.nextDouble();
            } catch (Exception e) {
                clear_screen();
                System.out.println("Por favor ingrese un numero valido!");
                scanner.nextLine();
            }
        }
    }

    private static int get_int(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            try {
                return scanner.nextInt();
            } catch (Exception e) {
                clear_screen();
                System.out.println("Por favor ingrese un numero valido!");
                scanner.nextLine();
            }
        }
    }

    private static void make_operation(int operation, double  number1, double number2) {
        switch (operation) {
            case 1:
                System.out.println("Resultado de la suma " + number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case 2:
                System.out.println("Resultado de la resta " + number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case 3:
                System.out.println("Resultado de la mutiplicacion " + number1 + " * " + number2 + " = " + (number1 * number2));
                break;
            case 4:
                if (number1 != 0 && number2 != 0) {
                    System.out.println("Resultado de la division " + number1 + " / " + number2 + " = " + (number1 / number2));
                } else {
                    System.out.println("Operacion no permitida! Un numero es igual a \'0\'");
                }
                break;
            default:
                break;
        }
    }

    private static void clear_screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}