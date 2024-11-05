import java.util.Scanner;
import java.util.ArrayList;

class DetalleFactura {
    private String codigoArticulo;
    private String nombreArticulo;
    private int cantidad;
    private double precioUnitario;
    private double descuentoItem;
    private double subtotal;

    // Constructor
    public DetalleFactura(String codigoArticulo, String nombreArticulo, int cantidad, double precioUnitario) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuentoItem = 0.0;
        this.subtotal = 0.0;
    }

    // Getters y Setters
    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuentoItem() {
        return descuentoItem;
    }

    public void setDescuentoItem(double descuentoItem) {
        this.descuentoItem = descuentoItem;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // Método para calcular el descuento y subtotal
    public void calcularDescuentoYSubtotal() {
        if (this.cantidad > 5) {
            this.descuentoItem = this.precioUnitario * 0.1;  // Descuento del 10%
        }
        this.subtotal = (this.precioUnitario * this.cantidad) - (this.descuentoItem * this.cantidad);
    }
}

class Factura {
    private String fechaFactura;
    private long numeroFactura;
    private double totalCalculadoFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura;

    // Constructor
    public Factura() {
        this.detallesFactura = new ArrayList<>();
    }

    // Getters y Setters
    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getTotalCalculadoFactura() {
        return totalCalculadoFactura;
    }

    public void setTotalCalculadoFactura(double totalCalculadoFactura) {
        this.totalCalculadoFactura = totalCalculadoFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(ArrayList<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    // Método para calcular el monto total de la factura
    public void calcularMontoTotal() {
        double total = 0;
        for (DetalleFactura detalle : detallesFactura) {
            total += detalle.getSubtotal();
        }
        this.totalCalculadoFactura = total;
    }
}

public class Facturacion {
    // Array de artículos (código, nombre y precio)
    static String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear una nueva factura
        Factura factura = new Factura();

        // Solicitar datos de la factura
        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFechaFactura(sc.nextLine());

        long numeroFactura;
        do {
            System.out.print("Ingrese el número de la factura (número mayor que 0): ");
            numeroFactura = sc.nextLong();
        } while (numeroFactura <= 0);
        factura.setNumeroFactura(numeroFactura);

        sc.nextLine();  // Limpiar el buffer
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = sc.nextLine();
        while (cliente.isEmpty()) {
            System.out.print("El cliente no puede ser vacío. Ingrese el nombre del cliente: ");
            cliente = sc.nextLine();
        }
        factura.setCliente(cliente);

        // Proceso de agregar artículos a la factura
        boolean continuar = true;
        while (continuar) {
            // Solicitar código de artículo
            String codigoArticulo;
            boolean articuloValido = false;
            String nombreArticulo = "";
            double precioUnitario = 0.0;
            do {
                System.out.print("Ingrese el código del artículo: ");
                codigoArticulo = sc.next();
                for (String[] articulo : articulos) {
                    if (articulo[0].equals(codigoArticulo)) {
                        nombreArticulo = articulo[1];
                        precioUnitario = Double.parseDouble(articulo[2]);
                        articuloValido = true;
                        break;
                    }
                }
                if (!articuloValido) {
                    System.out.println("El código ingresado no existe, intente nuevamente.");
                }
            } while (!articuloValido);

            // Solicitar cantidad
            System.out.print("Ingrese la cantidad a facturar: ");
            int cantidad = sc.nextInt();

            // Crear el detalle de la factura
            DetalleFactura detalle = new DetalleFactura(codigoArticulo, nombreArticulo, cantidad, precioUnitario);
            detalle.calcularDescuentoYSubtotal();
            factura.getDetallesFactura().add(detalle);

            // Preguntar si se desea continuar
            System.out.print("¿Desea continuar cargando artículos? (sí/no): ");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            }
        }

        // Calcular el monto total de la factura
        factura.calcularMontoTotal();

        // Imprimir los datos de la factura
        System.out.println("\nFactura:");
        System.out.println("Fecha: " + factura.getFechaFactura());
        System.out.println("Número: " + factura.getNumeroFactura());
        System.out.println("Cliente: " + factura.getCliente());

        System.out.println("\nCódigo\tArticulo\tNombre\tCantidad\tPrecio\tDescuento\tSubtotal");
        for (DetalleFactura detalle : factura.getDetallesFactura()) {
            System.out.println(detalle.getCodigoArticulo() + "\t" +
                    detalle.getNombreArticulo() + "\t" +
                    detalle.getCantidad() + "\t" +
                    detalle.getPrecioUnitario() + "\t" +
                    detalle.getDescuentoItem() + "\t" +
                    detalle.getSubtotal());
        }
        System.out.println("\nTotal: " + factura.getTotalCalculadoFactura());

    }
}


