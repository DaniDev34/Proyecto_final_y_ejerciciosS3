public class Videojuego {
    private String id;
    private String titulo;
    private int disponibles;

    public Videojuego(String id, String titulo, int disponibles) {
        this.id = id;
        this.titulo = titulo;
        this.disponibles = disponibles;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getDisponibles() { return disponibles; }

    public boolean hayDisponibles() { // valida si hay disponibilidad de juegos
        return disponibles > 0;
    }

    public void prestar() {
        if (disponibles > 0) {
            disponibles--;
        }
    }

    public void devolver() { // para aumentar la cantidad disponible de juegos cuando se hacen devoluciones 
        disponibles++;
    }

    public void mostrarInfo() {
        System.out.println("Juego: " + id + " | " + titulo + " | Disponibles: " + disponibles);
    }
}