import java.util.ArrayList;
import java.util.Arrays;

public class Clase04_01 {
    public static void main(String args[]) {
        String[] my_array = {"Juan", "Pedro", "Maria"};
        ArrayList<String> my_list = new ArrayList<>(Arrays.asList(my_array));
        System.out.println(buscarElemento(my_list, "Pedro"));
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
