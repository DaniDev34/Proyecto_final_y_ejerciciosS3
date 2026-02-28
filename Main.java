import java.util.Scanner;

public class Main {

    private static final String usuario1 = "Danielle";
    private static final String contraseñaU1 = "flamewall";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        
        SistemaPrestamos sistema = new SistemaPrestamos();

        
        sistema.getInventario().agregar(new Videojuego("71276", "Doom Eternal", 2));
        sistema.getInventario().agregar(new Videojuego("81273", "Resident Evil 4 Remake", 1)); // Juegos determinados en el sistema
        sistema.getInventario().agregar(new Videojuego("27365", "Mario Kart", 3));
        sistema.agregarCliente(new Cliente("62512", "Sofia"));
        sistema.agregarCliente(new Cliente("72365", "Ana"));
        sistema.agregarEmpleado(new Empleado("712636", "Daniel", "54678"));
        sistema.agregarEmpleado(new Empleado("923873", "Angel", "28137"));

        int opcionInicio = 0;

        do { // menu con do while para que se repita hasta que el usuario elija salir
            System.out.println("===== MENÚ INICIAL =====");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Ver información del programa");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            opcionInicio = leerEnt(scanner);

            switch (opcionInicio) { // un switch para manejar las opciones del menú inicial
                case 1:
                    boolean loginOk = iniciarSesion(scanner);
                    if (loginOk) {
                        menuServicios(scanner, sistema); 
                    }
                    break;

                case 2:
                    mostrarInformacion(scanner);
                    break;

                case 3:
                    System.out.println("Gracias por usar el programa. Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcionInicio != 3); // hasta que el usuario elija opcion 3 se acaba el programa

        scanner.close();
    }

    private static boolean iniciarSesion(Scanner scanner2) { // utilizamos un método para iniciar sesión, boolean para saber si el login es correcto o no, private para que solo se use dentro de esta clase, static para no tener que crear un objeto de la clase Main para usarlo
        System.out.println("--- INICIAR SESIÓN ---");
        System.out.print("Usuario: ");
        String usuario = scanner2.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = scanner2.nextLine();

        if (usuario.equals(usuario1) && contraseña.equals(contraseñaU1)) { // operador logico && para verificar que el usuario y la contraseña sean correctos
            System.out.println("Bienvenido de nuevo.");
            return true;
        } else { // uso un if else para manejar si es correcto o no el login
            System.out.println("Usuario o contraseña incorrectos, vuelve a intenarlo.");
            return false;
        }
    }

    private static void mostrarInformacion(Scanner scanner3) { // método para mostrar información del programa, se usa void porque no devuelve nada
        System.out.println("--- INFORMACIÓN DEL PROGRAMA ---");
        System.out.println("Gracias por usar este programa.");
        System.out.println("Hecho con 2 horas de sueño, 2 tazas de café y un Monster para aguantar el sueño.");
        System.out.println("Creado por mi, Daniel, estudiante de 1er semestre en IDS.");
        System.out.println("Con ayuda adicional de mi hermano desarrollador, quien me ayudó a entender mejor los bucles y try catch y usarlos de manera correcta.");
        System.out.println("Este sistema permite gestionar préstamos de videojuegos, agregar empleados, clientes y los videojuegos mismos.");
        System.out.println("En este programa hicimos uso de conceptos fundamentales de la programación orientada a objetos como clases, objetos, herencia, encapsulamiento, polimorfismo y abstracción.");
        System.out.println("Definimos reglas dentro de este sistema: ");
        System.out.println(" - Un cliente no puede tener más de 2 videojuegos prestados al mismo tiempo.");
        System.out.println(" - Un ṕréstamo puede tener un máximo de 2 videojuegos.");
        System.out.println(" - No se puede prestar un videojuego que no esté disponible en el inventario.");
        System.out.println(" - No se puede devolver un préstamo que no exista o que ya haya sido devuelto.");
        System.out.println("El usuario y contraseña para iniciar sesión son Danielle y flamewall respectivamente.");
        System.out.println("Presiona ENTER para volver al menú");
        scanner3.nextLine();
    }

    private static void menuServicios(Scanner scanner4, SistemaPrestamos sistema) { // otro método para mostrar el menú de servicios, se llama después de iniciar sesión correctamente

        int opcion = 0; // usamos esta variable para almacenar la opcion del usuario

        do {
            System.out.println("===== MENÚ DE SERVICIOS =====");
            System.out.println("1. Agregar videojuego al inventario");
            System.out.println("2. Ver inventario");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Registrar empleado");
            System.out.println("5. Crear préstamo");
            System.out.println("6. Devolver préstamo");
            System.out.println("7. Ver préstamos");
            System.out.println("8. Ver Clientes y Empleados");
            System.out.println("9. Cerrar sesión");
            System.out.print("Elige una opción: ");

            opcion = leerEnt(scanner4);

            switch (opcion) {
                case 1:
                    agregarVideojuego(scanner4, sistema); // llamamos al metodo de registrar videojuego
                    break;

                case 2:
                    System.out.println("--- INVENTARIO ---");
                    sistema.getInventario().mostrar(); // mostramos el inventario llamando al método mostrar del inventario
                    break;

                case 3:
                    registrarCliente(scanner4, sistema); // llamamos al metodo de registrar cliente
                    break;

                case 4:
                    registrarEmpleado(scanner4, sistema); // llamamos al metodo para registrar empleado
                    break;

                case 5:
                    crearPrestamo(scanner4, sistema); // llamamos al metodo para crear un prestamo
                    break;

                case 6:
                    devolverPrestamo(scanner4, sistema); // llamamos al metodo para devolver un prestamo
                    break;

                case 7:
                    System.out.println("--- PRÉSTAMOS ---");
                    sistema.mostrarPrestamos(); 
                    break;

                
                case 8:
                    listarPersonas(sistema); // llamamos al metodo para listar clientes y empleados
                    break;

                case 9:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 9);
    }

    private static void agregarVideojuego(Scanner scanner5, SistemaPrestamos sistema) {
        try { // try catch para manejar errorres cuando se agrega un videojuego, por ejemplo si el usuario ingresa un numero en vez de un texto
            System.out.println("--- AGREGAR VIDEOJUEGO ---");
            System.out.print("ID: ");
            String idJuego = scanner5.nextLine();

            System.out.print("Título: ");
            String titulo = scanner5.nextLine();

            System.out.print("Disponibles: ");
            int disponibilidad = leerEnt(scanner5);

            sistema.getInventario().agregar(new Videojuego(idJuego, titulo, disponibilidad));
            System.out.println("Videojuego agregado.");
        } catch (Exception ex) { // maneja el error y muestra un mensaje al usuario
            System.out.println("Error al agregar videojuego.");
        }
    }

    // a partir de aqui son metodos para hacer registros de clientes, empleados, hacer prestamos y devoluciones, parecidos a los anteriores 
    private static void registrarCliente(Scanner scanner6, SistemaPrestamos sistema) {
        System.out.println("--- REGISTRAR CLIENTE ---");
        System.out.print("ID: ");
        String idCliente = scanner6.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner6.nextLine();

        sistema.agregarCliente(new Cliente(idCliente, nombre));
        System.out.println("Cliente registrado correctamente.");
    }

    private static void registrarEmpleado(Scanner scanner7, SistemaPrestamos sistema) {
        System.out.println("--- REGISTRAR EMPLEADO ---");
        System.out.print("ID: ");
        String idEmpleado = scanner7.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner7.nextLine();

        System.out.print("Número de empleado: ");
        String num = scanner7.nextLine();

        sistema.agregarEmpleado(new Empleado(idEmpleado, nombre, num));
        System.out.println("Empleado registrado correctamente.");
    }

    private static void crearPrestamo(Scanner scanner8, SistemaPrestamos sistema) {
        System.out.println("--- HACER UN PRÉSTAMO (máximo 2 juegos) ---");
        
        System.out.print("ID Cliente: ");
        String idCliente = scanner8.nextLine();

        System.out.print("ID Empleado: ");
        String idEmpleado = scanner8.nextLine();

        System.out.print("ID Juego 1: ");
        String idJuego1 = scanner8.nextLine();

        System.out.print("ID Juego 2 (opcional)");
        String idJuego2 = scanner8.nextLine();

        String prestamo = sistema.crearPrestamo(idCliente, idEmpleado, idJuego1, idJuego2);
        System.out.println(prestamo);
    }

    private static void devolverPrestamo(Scanner scanner9, SistemaPrestamos sistema) {
        System.out.println("--- DEVOLVER PRÉSTAMO ---");
        System.out.print("ID Préstamo: ");
        String idPrestamo = scanner9.nextLine();

        String prestamoDevuelto = sistema.devolver(idPrestamo);
        System.out.println(prestamoDevuelto);
    }

    private static void listarPersonas(SistemaPrestamos sistema) {
    System.out.println("--- CLIENTES Y EMPLEADOS REGISTRADOS ---");
    sistema.mostrarPersonas();
}   


    private static int leerEnt(Scanner scanner10) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String texto = scanner10.nextLine();
                numero = Integer.parseInt(texto);
                valido = true;
            } catch (Exception e) {
                System.out.print("Entrada inválida, intenta de nuevo: ");
            }
        }
        return numero;
    }
}