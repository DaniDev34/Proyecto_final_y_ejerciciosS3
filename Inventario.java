import java.util.ArrayList;

public class Inventario {
    private ArrayList<Videojuego> juegos; // otro arraylist para tener una lista de videojuegos en el inventario

    public Inventario() {
        juegos = new ArrayList<>();
    }

    public void agregar(Videojuego v) {
        juegos.add(v);
    }

    public Videojuego buscar(String id) {
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getId().equals(id)) {
                return juegos.get(i);
            }
        }
        return null;
    }

    public void mostrar() {
        if (juegos.size() == 0) {
            System.out.println("Inventario vacío.");
            return;
        }
        for (int i = 0; i < juegos.size(); i++) {
            juegos.get(i).mostrarInfo();
        }
    }
}