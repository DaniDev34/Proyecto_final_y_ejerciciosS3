import java.util.Scanner;
    public class ejercicios {
        public static void main(String[] args){
            Scanner scanner = new Scanner (System.in); //capturas las calificaciones a evaluar
            System.out.println("Ingresa las calificaciones: ");
            if (scanner.hasNextInt()){
                calificaciones = scanner.nextInt();
            } else {
                System.out.println("Cantidad inválida");
                scanner.close();
                return;
            }
            int calificaciones = scanner.nextInt();

            if (calificaciones <= 0 || calificaciones > 10 )
                System.out.println("");
        }
    }