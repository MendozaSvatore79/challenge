import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la aplicación de conversión de moneda.");
        System.out.println("Por favor, elija una opción:");

        int option = -1;
        while (option != 6) {
            displayMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    convertDollarsToPesos();
                    break;

                case 2 :
                    convertirDolarApesosMexicanos();

                    break;

                case 3 :
                    convertirDolaresApesosColobianos();
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestra aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Convertir dólares a pesos argentinos");
        System.out.println("1. Convertir dólares a pesos Mexicanos");
        System.out.println("1. Convertir dólares a pesos Colombianos");

        System.out.println("6. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void convertDollarsToPesos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor en dólares a convertir: ");
        double dollars = scanner.nextDouble();
        double pesos = dollars * 81.75; // Tipo de cambio aproximado
        System.out.println("El valor de $" + dollars + " equivale a $" + pesos + " pesos argentinos.");
        // Aquí podrías guardar la información en formato JSON si lo deseas
        saveToJson("dolares_a_pesos", dollars, pesos);
    }

    private static void convertirDolarApesosMexicanos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor en dólares a convertir: ");
        double dollars = scanner.nextDouble();
        double pesos = dollars * 17.5; // Tipo de cambio aproximado
        System.out.println("El valor de $" + dollars + " equivale a $" + pesos + " pesos argentinos.");
        // Aquí podrías guardar la información en formato JSON si lo deseas
        saveToJson("dolares_a_pesos", dollars, pesos);
    }


    private static void convertirDolaresApesosColobianos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor en dólares a convertir: ");
        double dollars = scanner.nextDouble();
        double pesos = dollars * 0.004; // Tipo de cambio aproximado
        System.out.println("El valor de $" + dollars + " equivale a $" + pesos + " pesos argentinos.");
        // Aquí podrías guardar la información en formato JSON si lo deseas
        saveToJson("dolares_a_pesos", dollars, pesos);
    }

    // Agrega más métodos de conversión aquí si lo deseas

    private static void saveToJson(String type, double originalValue, double convertedValue) {
        ConversionData data = new ConversionData(type, originalValue, convertedValue);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(data);
        System.out.println("Guardando datos en formato JSON:");
        System.out.println(json);
        // Aquí podrías guardar el JSON en un archivo si lo deseas
    }

    private static class ConversionData {
        String type;
        double originalValue;
        double convertedValue;

        ConversionData(String type, double originalValue, double convertedValue) {
            this.type = type;
            this.originalValue = originalValue;
            this.convertedValue = convertedValue;
        }
    }
}
