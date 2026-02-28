public class Empleado extends Persona { // extends para hacer uso de herencia a empleados y clientes, porque ambas son personas
    private String numeroEmpleado;

    public Empleado(String id, String nombre, String numeroEmpleado) {
        super(id, nombre);
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() { return numeroEmpleado; }

    @Override // un override para mostrar la informacion unicamente de los empleados, ya que la clase persona tiene su propio metodo para mostrar informacion, y aqui solo queremos que muestre informacion de los empleados
    public void mostrarInfo() {
        System.out.println("Empleado: " + getId() + " - " + getNombre() + " | NoEmpleado: " + numeroEmpleado);
    }
}