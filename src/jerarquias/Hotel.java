package jerarquias;

public class Hotel extends Hospederia {
    //definir atributos
    protected boolean conDesayuno;

    //Constructores
    public Hotel() {
    }

    public Hotel(DatosCliente cliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(cliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    //Accesadores y Mutadores
    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    //Método que retorna el adicional (Se sobre escribe de la Clase Hospederia)
    @Override
    public int adicional() {
        int adicional= 0;
        if(this.isEsFumador() && this.isConDesayuno()){
            adicional = Math.round(this.subtotal()* 30/100);
        }
        return adicional;
    }

    //Método que retorna el valor a cancelar (Se sobreescribe de la clase Medio de Alojamiento)
    @Override
    public int valorACancelar() {
            int valorACancelar= 0;
            valorACancelar= this.subtotal() - this.bonoDescuento() + this.adicional();
            return valorACancelar;
    }

    //Método que retorna el incremento en el valor base (Se sobreescribe de la clase Hospederia)
    @Override
    public int incrementoValorBase() {
        return 0;
    }


}
