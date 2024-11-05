public class Persona {
    String nombre;
    String apellidos;
    String numDNI;
    int anioNacimiento;
    String paisNac;
    char genero;

    Persona(String nombre, String apellidos, String numDNI, int anioNacimiento, String paisNac, char genero){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numDNI = numDNI;
        this.anioNacimiento = anioNacimiento;
        this.paisNac = paisNac;
        this.genero = genero;

    }

    void imprimir(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Número de DNI: " + numDNI);
        System.out.println("Año de nacimiento: " + anioNacimiento);
        System.out.println("País de nacimiento: " + paisNac);
        System.out.println("Género: " + genero);
        System.out.println();
    }

    public static void main(String args[]) {
        Persona p1 = new Persona("Pedro","Pérez","1053121010",1998,"Groenlandia",'H');
        Persona p2 = new Persona("Luis","León","1053223344",2001,"Bolivia",'H');
        p1.imprimir();
        p2.imprimir();
    }

}
