import java.util.Scanner;

public class Diego01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double PI = 3.1416;


        System.out.println("Diego Ronaldo Sanchez Pichardo\n");

        System.out.print("Dame un numero: ");
        Double number1 = scanner.nextDouble();

        if (number1 > 7) {
            System.out.println("El numero " + number1 + " es mayor a 7");
        }

        for (Integer i = 1; i <= 10; i++) {
            System.out.println(number1 + " x " + i + " = " + (number1 * i));
        }

        System.out.println("El area del circulo es: " + PI * Math.pow(number1, 2) + "\n");

        System.out.print("Dame una letra: ");
        String letter = scanner.next();

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

        scanner.close();
    }
}
