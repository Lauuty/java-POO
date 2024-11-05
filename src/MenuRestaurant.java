import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadDeMedida;

    public Ingrediente(String nombre, double cantidad, String unidadDeMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    @Override
    public String toString() {
        return cantidad + " " + unidadDeMedida + " de " + nombre;
    }
}

class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEsBebida() {
        return esBebida;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Plato: ").append(nombreCompleto)
                .append(", Precio: ").append(precio)
                .append(", Es bebida: ").append(esBebida);
        if (!esBebida) {
            info.append(", Ingredientes: ");
            for (Ingrediente ing : ingredientes) {
                info.append("\n  - ").append(ing);
            }
        }
        return info.toString();
    }
}

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        while (true) {
            System.out.print("Ingrese el nombre del plato (o 'salir' para terminar): ");
            String nombrePlato = scanner.nextLine();
            if (nombrePlato.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingrese el precio del plato: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("¿Es bebida? (true/false): ");
            boolean esBebida = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar el buffer

            Plato plato = new Plato(nombrePlato, precio, esBebida);

            // Si no es bebida, solicitar ingredientes
            if (!esBebida) {
                System.out.print("¿Cuántos ingredientes tiene el plato? ");
                int cantidadIngredientes = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                for (int i = 0; i < cantidadIngredientes; i++) {
                    System.out.print("Ingrese el nombre del ingrediente: ");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    double cantidad = scanner.nextDouble();
                    System.out.print("Ingrese la unidad de medida: ");
                    String unidadDeMedida = scanner.next();
                    scanner.nextLine(); // Limpiar el buffer

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadDeMedida);
                    plato.agregarIngrediente(ingrediente);
                }
            }

            platosMenu.add(plato);
        }

        // Mostrar la información cargada
        System.out.println("\nMenú del restaurante:");
        for (Plato plato : platosMenu) {
            System.out.println(plato);
        }

        scanner.close();
    }
}

