public abstract class Persona {
    private String id;
    private String nombre;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        }
    }

    
    public abstract void mostrarInfo(); // un metodo abstracto para mostrar la informacion unicamente de los clientes y no de los empleados
}