package Actividad4;

public class Videojuego {
    final int id;
    String nombre;

    public Videojuego(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
