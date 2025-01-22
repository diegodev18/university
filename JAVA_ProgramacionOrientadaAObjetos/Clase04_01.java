import java.util.ArrayList;

public class Clase04_01 {
    public static void main(String args[]) {
        String my_array = {"Pedro", "Pablo", "Picazo", "Polo", "Pilo"};
        System.out.println(buscarElemento(my_array, "Pedro"));
    }

    public static int buscarElemento(ArrayList<String> lista, String texto) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elemento => " + lista.get(i));
            if (lista.get(i).toLowerCase().equals(texto.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}
