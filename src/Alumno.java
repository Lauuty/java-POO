import java.util.ArrayList;
import java.util.Scanner;

class Nota {
    private String catedra;
    private double notaExamen;

    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }
}


public class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0.0; // No hay notas para calcular
        }
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return suma / notas.size();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }
}



class CargaNotas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Alumno " + (i + 1) + ":");
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();
            System.out.print("Legajo: ");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Limpiar el buffer

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.print("Ingrese la cantidad de notas para " + nombre + ": ");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Cátedra de la nota " + (j + 1) + ": ");
                String catedra = scanner.nextLine();
                System.out.print("Nota: ");
                double nota = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer

                Nota notaObj = new Nota(catedra, nota);
                alumno.agregarNota(notaObj);
            }

            alumnos.add(alumno);
        }

        // Mostrar la información cargada
        System.out.println("\nInformación cargada:");
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println("Notas:");
            for (Nota nota : alumno.getNotas()) {
                System.out.println("- " + nota.getCatedra() + ": " + nota.getNotaExamen());
            }
            System.out.printf("Promedio: %.2f%n", alumno.calcularPromedio());
            System.out.println();
        }

    }
}

