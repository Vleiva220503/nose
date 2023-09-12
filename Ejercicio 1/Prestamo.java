public class Prestamo {
    double precio;
    int plazo;  
    String tipoVehiculo;  

    public Prestamo() {}

    public Prestamo(double precio, int plazo, String tipoVehiculo) {
        this.precio = precio;
        this.plazo = plazo;
        this.tipoVehiculo = tipoVehiculo;
    }

    public double calcularCuota() {
        double tasaInteresAnual;

        if (tipoVehiculo.equals("usado")) {
            tasaInteresAnual = 0.18;
        } else {
            tasaInteresAnual = 0.24;
        }

        double tasaInteresMensual = tasaInteresAnual / 12;
        return precio * tasaInteresMensual / (1 - Math.pow(1 + tasaInteresMensual, -plazo));
    }

    public void menuTipoVehiculo() {
        System.out.println("\t1.- Usado");
        System.out.println("\t2.- Nuevo");
    }
}
