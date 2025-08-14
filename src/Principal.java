import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        API api = new API();
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Bienvenido al Conversor de Monedas ===");
            System.out.println("1. Dólar → Peso argentino");
            System.out.println("2. Peso argentino → Dólar");
            System.out.println("3. Dólar → Real brasileño");
            System.out.println("4. Real brasileño → Dólar");
            System.out.println("5. Dólar → Peso colombiano");
            System.out.println("6. Peso colombiano → Dólar");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            if (opcion == 7) {
                salir = true;
                System.out.println("¡Hasta luego!");
                continue;
            }

            System.out.print("Ingresa la cantidad: ");
            double cantidad = sc.nextDouble();
            double resultado = 0;

            switch (opcion) {
                case 1: resultado = cantidad * api.obtenerTasa("USD","ARS"); break;
                case 2: resultado = cantidad * api.obtenerTasa("ARS","USD"); break;
                case 3: resultado = cantidad * api.obtenerTasa("USD","BRL"); break;
                case 4: resultado = cantidad * api.obtenerTasa("BRL","USD"); break;
                case 5: resultado = cantidad * api.obtenerTasa("USD","COP"); break;
                case 6: resultado = cantidad * api.obtenerTasa("COP","USD"); break;
                default: System.out.println("Opción inválida"); continue;
            }

            System.out.println("Resultado: " + resultado);
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
