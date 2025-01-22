import java.util.Scanner;

public class Tarea01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Cual es tu nombre? ");
        String nombre = scanner.nextLine();
        System.out.println("Bienvenido " + nombre + "\n");
        
        boolean continuar = true;
        while (continuar) {
    
            System.out.println("Piensa en dos numeros!");
            System.out.print("Primer numero: ");
            Double number1 = scanner.nextDouble();
            System.out.print("Segundo numero: ");
            Double number2 = scanner.nextDouble();
    
            System.out.print("\n--- Menu ---\n1) Suma\n2) Resta\n3) Multiplicacion\n4) Division\nOpcion: ");
            Integer operation = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\n");

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
                        System.out.println("Operacion no permitida!");
                    }
                    break;
            
                default:
                    break;
            }

            System.out.println("Numero mayor: " + Math.max(number1, number2));

            Integer lowNumber = Math.min(number1.intValue(), number2.intValue());
            System.out.println("El numero menor es: " + lowNumber + " y el area del circulo es: " + lowNumber * 3.1416);

            System.out.print("\nIngresa una letra: ");
            String letter = scanner.nextLine();

            switch (letter.toLowerCase()) {
                case "a":
                case "e":
                case "i":
                case "o":
                case "u":
                    System.out.println("La letra " + letter + " es una vocal");
                    break;
            
                default:
                    System.out.println("La letra " + letter + " es una consonante");
                    break;
            }

            System.out.print("\nDeseas realizar otra operacion?  [S/n]: ");
            String opt = scanner.nextLine();
            if (opt.toLowerCase().equals("s")) {
                continuar = true;
            } else {
                continuar = false;
            }

            System.out.print("\n");
        }

        scanner.close();
    }
}