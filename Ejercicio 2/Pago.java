public class Pago {
    private double subtotal;
    private String tipoPago; 

    public Pago() {}

    public Pago(double subtotal, String tipoPago) {
        this.subtotal = subtotal;
        this.tipoPago = tipoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double calcularTotal() {
        if (tipoPago.equals("a")) {
            return subtotal - (subtotal * 0.05); 
        } else {
            return subtotal;
        }
    }

    public void menuTipoPago() {
        System.out.println("\ta.- Crédito");
        System.out.println("\tb.- Contado");
    }
}
