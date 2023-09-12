import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CalculadoraPrestamos {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Prestamo prestamo = new Prestamo();

        String entrada;
        boolean validacion;
        Pattern patronNumero = Pattern.compile("\\d+(\\.\\d+)?");  

        try {
            prestamo.menuTipoVehiculo();
            do {
                System.out.println("Seleccione el tipo de vehículo:");
                entrada = br.readLine();
                validacion = patronNumero.matcher(entrada).matches();

                if (validacion) {
                    int seleccion = Integer.parseInt(entrada);
                    if (seleccion == 1) {
                        prestamo.tipoVehiculo = "usado";
                        do {
                            System.out.println("Ingrese el precio del vehículo usado (entre 700 y 65000):");
                            entrada = br.readLine();
                            validacion = patronNumero.matcher(entrada).matches();
                            if (validacion) {
                                prestamo.precio = Double.parseDouble(entrada);
                            }
                        } while (prestamo.precio < 700 || prestamo.precio > 65000 || !validacion);

                        System.out.println("Seleccione el plazo: 36, 48 o 60 meses:");
                        prestamo.plazo = Integer.parseInt(br.readLine());
                        while (prestamo.plazo != 36 && prestamo.plazo != 48 && prestamo.plazo != 60) {
                            System.out.println("Plazo inválido. Seleccione nuevamente:");
                            prestamo.plazo = Integer.parseInt(br.readLine());
                        }

                    } else if (seleccion == 2) {
                        prestamo.tipoVehiculo = "nuevo";
                        do {
                            System.out.println("Ingrese el precio del vehículo nuevo (entre 12000 y 125000):");
                            entrada = br.readLine();
                            validacion = patronNumero.matcher(entrada).matches();
                            if (validacion) {
                                prestamo.precio = Double.parseDouble(entrada);
                            }
                        } while (prestamo.precio < 12000 || prestamo.precio > 125000 || !validacion);

                        System.out.println("Seleccione el plazo: 48, 60 o 72 meses:");
                        prestamo.plazo = Integer.parseInt(br.readLine());
                        while (prestamo.plazo != 48 && prestamo.plazo != 60 && prestamo.plazo != 72) {
                            System.out.println("Plazo inválido. Seleccione nuevamente:");
                            prestamo.plazo = Integer.parseInt(br.readLine());
                        }
                    } else {
                        validacion = false;
                    }
                }
            } while (!validacion);

            double cuota = prestamo.calcularCuota();
            System.out.println("La cuota mensual es: $" + cuota);

        } catch (IOException ex) {
            System.out.println("Error al leer desde consola.");
        }
    }
}
