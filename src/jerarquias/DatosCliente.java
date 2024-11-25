package jerarquias;

public class DatosCliente {
    //definir atributos
    private String nombre;
    private String rut;

    //Constructores
    public DatosCliente() {
    }

    public DatosCliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    //Accesadores y Mutadores
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
