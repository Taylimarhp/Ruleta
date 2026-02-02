package Ejercicio;
import java.util.Scanner;
import java.util.InputMismatchException; 

public class InterfazRuleta {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int saldoInicial = 0;
        boolean saldoValido = false;

        System.out.println("BIENVENIDO AL CASINO");

        
        while (!saldoValido) {
            try {  
                System.out.print("Introduce tu saldo para empezar a jugar: ");
                saldoInicial = sc.nextInt();
                
                if (saldoInicial > 0) {
                    saldoValido = true;
                } else {
                    System.out.println("El saldo debe ser mayor que cero.");
                }
            } catch (InputMismatchException e) { 
                System.out.println("Error: Debes introducir un número entero.");
                sc.nextLine();
            }
        }

        
        Ruleta miJuego = new Ruleta(saldoInicial);

       
        while (miJuego.getSaldo() > 0) {
            try {
                System.out.println("\n---------------------------------");
                System.out.println("SALDO ACTUAL: " + miJuego.getSaldo() + "€");
                System.out.println("1. Apostar a un Número");
                System.out.println("2. Apostar a una Docena");
                System.out.println("3. Apostar a una Fila");
                System.out.println("4. Apostar a Par");
                System.out.println("5. Apostar a Impar");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                
                int opcion = sc.nextInt();

                if (opcion == 0) break; 

                System.out.print("¿Cuánto dinero quieres apostar?: ");
                int dineroApostado = sc.nextInt();

              
                if (dineroApostado > miJuego.getSaldo()) {
                    System.out.println("No tienes suficiente dinero para esa apuesta.");
                    continue;
                }

                
                miJuego.Lanzarbolita(); 
                int numeroGanador = miJuego.getbolita();
                boolean resultado = false;

                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("¿A qué número (0-36) quieres apostar?: ");
                        int num = sc.nextInt();
                        resultado = miJuego.apuestaPorNumero(dineroApostado, num);
                    }
                    case 2 -> {
                        System.out.print("¿A qué docena (1, 2 o 3) quieres apostar?: ");
                        int doc = sc.nextInt();
                        resultado = miJuego.apuestaPorDocena(dineroApostado, doc);
                    }
                    case 3 -> {
                        System.out.print("¿A qué fila (1, 2 o 3) quieres apostar?: ");
                        int fila = sc.nextInt();
                        resultado = miJuego.apostarFila(dineroApostado, fila);
                    }
                    case 4 -> {
                        resultado = miJuego.apuestaPar(numeroGanador, dineroApostado);
                    }
                    case 5 -> {
                        resultado = miJuego.apuestaImpar(numeroGanador, dineroApostado);
                    }
                    default -> System.out.println("Opción no válida.");
                }

                
                System.out.println(" La bolita cayó en el: " + numeroGanador);
                if (resultado) {
                    System.out.println("Has ganado.");
                } else {
                    System.out.println("Lo siento, has perdido esta vez.");
                }

            } catch (InputMismatchException e) {
               
                System.out.println("¡Error de entrada! Por favor, usa solo números.");
                sc.nextLine(); 
            }
        }

        System.out.println("\nJuego terminado. Te vas con " + miJuego.getSaldo() + "€.");
        sc.close();
    }
}
	
		
