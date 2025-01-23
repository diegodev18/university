import java.util.ArrayList;
import java.util.Scanner;

public class Tarea02 {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Como te llamas? ");
            String nombre = scanner.nextLine();
            System.out.println("Bienvenido " + nombre + "!\n");

            ArrayList<String> games_collection = new ArrayList<String>();
            games_collection.add("Super Mario Bros");
            games_collection.add("The Legend of Zelda");
            games_collection.add("Metroid");
            games_collection.add("Donkey Kong");
            games_collection.add("Kirby");
            games_collection.add("Star Fox");
            games_collection.add("F-Zero");
            games_collection.add("Pikmin");
            games_collection.add("Animal Crossing");
            games_collection.add("Splatoon");

            for (Integer i = 0; i < games_collection.size(); i++) {
                System.out.println(i + 1 + ". " + games_collection.get(i));
            }

            System.out.print("\n--- Menu ---\n1) Agregar juego\n2) Buscar juego\n3) Modificar juego\n4) Eliminar juego\n> ");
            Integer opcion = scanner.nextInt();

            String juego;
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del juego: ");
                    juego = scanner.nextLine();
                    games_collection.add(juego);
                    break;
                case 2:
                    System.out.print("Nombre del juego: ");
                    juego = scanner.nextLine();
                    if (games_collection.contains(juego)) {
                        System.out.println("El juego " + juego + " si esta en la coleccion!");
                    } else {
                        System.out.println("El juego " + juego + " no esta en la coleccion!");
                    }
                    break;
                case 3:
                    System.out.print("Nombre del juego: ");
                    juego = scanner.nextLine();
                    if (games_collection.contains(juego)) {
                        System.out.print("Nuevo nombre del juego: ");
                        String nuevo_juego = scanner.nextLine();
                        games_collection.set(games_collection.indexOf(juego), nuevo_juego);
                    } else {
                        System.out.println("El juego " + juego + " no esta en la coleccion!");
                    }
                    break;
                case 4:
                    System.out.print("Nombre del juego: ");
                    juego = scanner.nextLine();
                    if (games_collection.contains(juego)) {
                        games_collection.remove(juego);
                    } else {
                        System.out.println("El juego " + juego + " no esta en la coleccion!");
                    }
                    break;
                default:
                    break;
            }
            
            System.out.print("Quieres continuar? [S/n]: ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }
        }
        scanner.close();
    }
}
