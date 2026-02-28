import java.util.ArrayList;

public class SistemaPrestamos {
    private Inventario inventario;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;
    private ArrayList<Prestamo> prestamos;
    private int contadorPrestamos;

    // arraylist para hacer listas de los clientes, empleados y prestamos, y un
    // inventario para manejar los videojuegos
    public SistemaPrestamos() {
        inventario = new Inventario();
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
        prestamos = new ArrayList<>();
        contadorPrestamos = 1; // empieza en 1
    }

    public Inventario getInventario() {
        return inventario;
    } // para mostrar el inventario desde main con el getter

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public Cliente buscarCliente(String id) { // busca al cliente por su id
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id))
                return clientes.get(i);
        }
        return null;
    }

    public Empleado buscarEmpleado(String id) { // con esto buscamos a un empleado mediante su id
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId().equals(id))
                return empleados.get(i);
        }
        return null;
    }

    public Prestamo buscarPrestamo(String idPrestamo) { // busca prestamos por su id
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getIdPrestamo().equals(idPrestamo))
                return prestamos.get(i);
        }
        return null;
    }

    public String crearPrestamo(String idCliente, String idEmpleado, String idJuego1, String idJuego2) {

        String idPrestamo = "P" + contadorPrestamos;
        contadorPrestamos++; // ID unico de un prestamo

        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null)
            return "Cliente no encontrado."; // use un null porque si el sistema no encuentra una id con la que se dio
                                             // arrojara un mensaje de error

        Empleado empleado = buscarEmpleado(idEmpleado);
        if (empleado == null)
            return "Empleado no encontrado.";

        int cantidad = 0;
        if (idJuego1 != null && !idJuego1.equals(""))
            cantidad++;
        if (idJuego2 != null && !idJuego2.equals(""))
            cantidad++;

        // reglas que establecí desde la documentación: máximo 2 juegos por persona y no
        // puede tener mas de 2 prestados al mismo tiempo
        if (cantidad == 0)
            return "Debes elegir al menos 1 juego.";
        if (cantidad > 2)
            return "Máximo 2 juegos.";

        if (!cliente.puedePedir(cantidad))
            return "El cliente ya tiene 2 juegos prestados."; // ! este operador lo use para negar la condicion que es
                                                              // si el cliente puede pedir el prestamo

        Videojuego juego1 = inventario.buscar(idJuego1);
        if (juego1 == null)
            return "Juego 1 no existe.";
        if (!juego1.hayDisponibles())
            return "Juego 1 sin disponibilidad.";

        Videojuego j2 = null; // este es por si el cliente quiere pedir otro juego, con un null por si no
                              // quiere pedirlo
        if (cantidad == 2) {
            j2 = inventario.buscar(idJuego2);
            if (j2 == null)
                return "Juego 2 no existe.";
            if (!j2.hayDisponibles())
                return "Juego 2 sin disponibilidad.";
        }

        juego1.prestar();
        if (j2 != null)
            j2.prestar();

        Prestamo p = new Prestamo(idPrestamo, cliente, empleado); // con esto se crea un prestamo con id, cliente y
                                                                  // empleadp
        p.agregarJuego(juego1);
        if (j2 != null)
            p.agregarJuego(j2);

        prestamos.add(p);

        cliente.sumarPrestados(cantidad);

        return "Préstamo creado.";
    }

    public String devolver(String idPrestamo) { // este metodo lo hice para devolver un prestamo mediante su id
        Prestamo p = buscarPrestamo(idPrestamo);
        if (p == null)
            return "Préstamo no encontrado.";
        if (!p.isActivo())
            return "Ese préstamo ya fue devuelto.";

        if (p.getJuego1() != null)
            p.getJuego1().devolver();
        if (p.getJuego2() != null)
            p.getJuego2().devolver();

        p.getCliente().sumarPrestados(-p.getCantidad());

        p.devolverPrestamo();
        return "Devolución lista.";
    }

    public void mostrarPrestamos() { // tipo void porque no devuelve nada, solo muestra la información de los
                                     // prestamos
        if (prestamos.size() == 0) {
            System.out.println("No hay préstamos.");
            return;
        }

        for (int i = 0; i < prestamos.size(); i++) {
            prestamos.get(i).mostrarInfo();
        }
    }

    public void mostrarPersonas() { // para mostrar informacion de clientes y empleados, otro void porque no
                                    // devuelve nada
        for (int i = 0; i < clientes.size(); i++)
            clientes.get(i).mostrarInfo();
        for (int i = 0; i < empleados.size(); i++)
            empleados.get(i).mostrarInfo();
    }
}