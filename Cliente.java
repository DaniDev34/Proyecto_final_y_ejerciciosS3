public class Cliente extends Persona {
    private int prestados; // cuántos juegos tiene prestados (máx 2)

    public Cliente(String id, String nombre) {
        super(id, nombre);
        prestados = 0;
    }

    public int getPrestados() { return prestados; }

    public boolean puedePedir(int cantidad) {
        return prestados + cantidad <= 2;
    }

    public void sumarPrestados(int cantidad) {
        prestados = prestados + cantidad;
        if (prestados < 0) prestados = 0;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + getId() + " - " + getNombre() + " | Prestados: " + prestados);
    }
}