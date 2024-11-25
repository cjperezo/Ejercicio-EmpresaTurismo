package jerarquias;

public abstract class Hospederia extends MedioDeAlojamiento {
    //definir atributos
    protected int capacidad;
    protected boolean esFumador;

    //Constructores
    public Hospederia() {
    }

    public Hospederia(DatosCliente cliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int capacidad, boolean esFumador) {
        super(cliente, valorBaseNoche, cantidadNoches, tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    //Accesadores y Mutadores

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    //Método que retorna el adicional
    public abstract int adicional();

    //Método que retorna el incremento en el valor Base segun la capacidad en cabaña
    public abstract int incrementoValorBase();
}

