public class Prestamo {
    private String idPrestamo;
    private Cliente cliente;
    private Empleado empleado;

    private Videojuego juego1;
    private Videojuego juego2;
    private int cantidad;
    private boolean activo;

    // constructor 
    public Prestamo(String idPrestamo, Cliente cliente, Empleado empleado) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.empleado = empleado;
        this.cantidad = 0;
        this.activo = true;
    }
    // getters y setters
    public String getIdPrestamo() { return idPrestamo; }
    public boolean isActivo() { return activo; }
    public Cliente getCliente() { return cliente; }

    public boolean agregarJuego(Videojuego videojuego) {
        if (cantidad == 0) {
            juego1 = videojuego;
            cantidad = 1;
            return true;
        } else if (cantidad == 1) {
            juego2 = videojuego;
            cantidad = 2;
            return true;
        }
        return false; 
    }

    public int getCantidad() { return cantidad; }

    public Videojuego getJuego1() { return juego1; }
    public Videojuego getJuego2() { return juego2; }

    public void devolverPrestamo() {
        activo = false;
    }

    public void mostrarInfo() { // mostrar información del prestamo
        System.out.println("Préstamo: " + idPrestamo + " | Activo: " + activo);
        System.out.println("Cliente: " + cliente.getNombre() + " | Empleado: " + empleado.getNombre());
        System.out.print("Juegos: ");
        // mostrar los juegos prestados
        if (juego1 != null) System.out.print(juego1.getTitulo()); // usamos != para negar si es igual a null y mostrar el juego
        if (juego2 != null) System.out.print(", " + juego2.getTitulo());

        System.out.println("-------------------------");
    }
}