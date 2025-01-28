public class Clase06_01 {
    public static void main(String[] args) {
        String[][] sala1 = {
            { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9" },
            { "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9" },
            { "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9" },
        };

        for (int f = 0; f < sala1.length; f++) {

            for (int j = 0; j < sala1[f].length; j++) {
                System.out.print(sala1[f][j] + " ");
            }

            System.out.println();
        }
    }
}
