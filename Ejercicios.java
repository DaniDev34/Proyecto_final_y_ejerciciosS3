import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero1 = scanner.nextInt();

        if (numero1 <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        int[] numeros2 = new int[numero1];
        for (int i = 0; i < numero1; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            numeros2[i] = scanner.nextInt();
        }

        int suma = 0;
        {
            for (int i = 0; i < numero1; i++) {
                suma += numeros2[i];
            }

            double promedio = (double) suma / numero1;
            System.out.println("El promedio es: " + promedio);

            System.out.println("Suma total: " + suma);
            System.out.println("Promedio: " + promedio);
        }
        scanner.close();
    }

}
