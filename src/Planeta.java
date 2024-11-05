public class Planeta {

    private String nombre;
    private int cantSat;
    private double masa;
    private double volumen;
    private int diam;
    private int distSol;
    private int perOrbital;
    private int perRotacion;
    private double densidad;
    private boolean esExterior;

    public enum tipoPlaneta {GASEOSO, TERRESTRE, ENANO}
    private tipoPlaneta tipo;

    public Planeta() {
        this.nombre = null;
        this.cantSat = 0;
        this.masa = 0;
        this.volumen = 0;
        this.diam = 0;
        this.distSol = 0;
        this.perOrbital = 0;
        this.perRotacion = 0;
        this.densidad = 0;
        this.esExterior = false;
    }

    public Planeta(String nombre, int cantSat, double masa, double volumen, int diam, int distSol, int perOrbital, int perRotacion) {
        this.nombre = nombre;
        this.cantSat = cantSat;
        this.masa = masa;
        this.volumen = volumen;
        this.diam = diam;
        this.distSol = distSol;
        this.perOrbital = perOrbital;
        this.perRotacion = perRotacion;
        this.densidad = calcularDensidad(masa,volumen);
        this.esExterior = esPlanetaExterior(nombre,distSol);
    }

    void imprimir(){
        System.out.println("Planeta: " + nombre);
        System.out.println("Cantidad de sátelites: " + cantSat);
        System.out.println("Masa: " + masa + "kg");
        System.out.println("Volumen: " + volumen + "km3");
        System.out.println("Diámetro: " + diam + "km");
        System.out.println("Distancia media al sol: " + distSol + "M de km");
        System.out.println("Periodo orbital: " + perOrbital + " años");
        System.out.println("Periodo de rotación: " + perRotacion + " días");
        System.out.println();
    }

    public double calcularDensidad(double masa,double volumen){
        return masa*volumen;
    }

    public boolean esPlanetaExterior(String nombre,int distSol){
        int ua = 149597870;
        if (distSol > ua * 2.1 && distSol < ua * 3.4)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        Planeta p1 = new Planeta("Jupiter",3,3432412,327656,21313432,5,45,45);
        Planeta p2 = new Planeta("Neptuno",7,4545454,7784544,23894,9,12,2);
        p1.imprimir();
        System.out.println("La densidad de " + p1.nombre + " es de: " + p1.densidad + "kg/m3");
        if (p1.esExterior == true)
            System.out.println("El planeta " + p1.nombre + " es exterior");
        else
            System.out.println("El planeta " + p1.nombre + " NO es exterior");
        p2.imprimir();
        System.out.println("La densidad de " + p2.nombre + " es de: " + p2.densidad + "kg/m3");
        if (p2.esExterior == true)
            System.out.println("El planeta " + p2.nombre + " es exterior");
        else
            System.out.println("El planeta " + p2.nombre + " NO es exterior");

    }
}
