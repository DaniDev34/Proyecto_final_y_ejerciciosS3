public class Inventario {

    // Atributos del inventario
    private String titulo;
    private int cantidadDisponible;
    private double precio;
    private String genero;

    // Constructor
    public Inventario(String titulo, int cantidadDisponible, double precio, String genero) {
        this.titulo = titulo;
        this.cantidadDisponible = cantidadDisponible;
        this.precio = precio;
        this.genero = genero;
    }
    // Método para mostrar la información del inventario
    mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Cantidad Disponible: " + cantidadDisponible);
        System.out.println("Precio: $" + precio);
        System.out.println("Género: " + genero);
    }
}