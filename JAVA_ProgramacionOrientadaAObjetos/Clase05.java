import java.util.Scanner;

public class Clase05 {
    public static void main(String args[]) {
        char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        int ex_plays = 0;
    
        while (true) {
            player = getPlayer(player);

            printGame(tablero);

            move(scanner, tablero, ex_plays, player);
    
            boolean winner = check_winner(tablero);
            if (winner) {
                printGame(tablero);
                break;
            } else if (ex_plays == 9) {
                printGame(tablero);
                System.out.println("Juego llegado al limite! NO hay ganador! EMPATE!");
                break;
            }
        }

        scanner.close();
    }

    private static void move(Scanner scanner, char[][] tablero, int ex_plays, char player) {
        while (true) {
            System.out.printf("\nTurno de \'%c\'\n", player);
            System.out.print("> Fila: ");
            int fila = scanner.nextInt();
            System.out.print("> Columna: ");
            int column = scanner.nextInt();
            System.out.println();

            try {
                if (tablero[fila - 1][column - 1] == ' ') {
                    tablero[fila - 1][column - 1] = player;
                    ex_plays += 1;
                    break;
                } else {
                    System.out.println("Turno no permitido, el lugar esta usado");
                    continue;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println("Lugar fuera del rango");
                continue;
            }
        }
    }

    private static char getPlayer(char player) {
        if (player == 'X') {
            return 'O';
        } else if (player == 'O') {
            return 'X';
        }
        return ' ';
    }

    private static void printGame(char[][] tablero) {
        System.out.println("Juego del Gato");
        printLine();
        System.out.println("");
        for(int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char chartodraw = tablero[i][j];
                System.out.printf("[%c]", chartodraw);
            }
            System.out.println(" |");
        }
        printLine();
    }

    private static void printLine() {
        for (int i = 0; i < 13; i++) {
            System.out.print("-");
        }
    }

    private static boolean check_winner(char[][] tablero) {
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]
                && tablero[i][0] != ' ' && tablero[i][1] != ' ' && tablero[i][2] != ' ') {
                System.out.printf("\nGanador \'%c\', felicidades", tablero[i][0]);
                return true;
            } else if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]
                    && tablero[0][i] != ' ' && tablero[1][i] != ' ' && tablero[2][i] != ' ') {
                System.out.printf("\nGanador \'%c\', felicidades", tablero[0][i]);
                return true;
            }
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] &&
            tablero[0][0] != ' ' && tablero[1][1] != ' ' && tablero[2][2] != ' ') {
            System.out.printf("Ganador \'%c\', felicidades\n", tablero[0][0]);
            return true;
        } else if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] &&
            tablero[0][2] != ' ' && tablero[1][1] != ' ' && tablero[2][0] != ' ') {
            System.out.printf("Ganador \'%c\', felicidades\n", tablero[0][2]);
            return true;
        }

        return false;
    }
}