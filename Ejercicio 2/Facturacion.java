import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Facturacion {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Pago pago = new Pago();

        String entrada;
        double total, montoEntregado = 0.0;

        Pattern patronNumero = Pattern.compile("\\d+(\\.\\d+)?"); 
        try {
            do {
                System.out.println("Digite el subtotal de su factura:");
                entrada = br.readLine();
                Matcher validador = patronNumero.matcher(entrada);
                if (validador.matches()) {
                    double subtotal = Double.parseDouble(entrada);
                    pago.setSubtotal(subtotal);
                }
            } while (pago.getSubtotal() <= 0);

            pago.menuTipoPago();

            do {
                System.out.println("Seleccione su opción de pago (a/b):");
                entrada = br.readLine();
                if (entrada.equalsIgnoreCase("a") || entrada.equalsIgnoreCase("b")) {
                    pago.setTipoPago(entrada);
                }
            } while (!entrada.equalsIgnoreCase("a") && !entrada.equalsIgnoreCase("b"));

            total = pago.calcularTotal();

            if (pago.getTipoPago().equalsIgnoreCase("a")) {
                do {
                    System.out.println("Monto a entregar:");
                    entrada = br.readLine();
                    Matcher validador = patronNumero.matcher(entrada);
                    if (validador.matches()) {
                        montoEntregado = Double.parseDouble(entrada);
                    }
                } while (montoEntregado < total);
                System.out.println("Vuelto: " + (montoEntregado - total));
            }

            System.out.println("Total a pagar: " + total);

        } catch (IOException ex) {
            System.out.println("Error al leer desde consola.");
        }
    }
}
