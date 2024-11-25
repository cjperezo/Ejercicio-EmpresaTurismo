package jerarquias;

public class Cabagna extends Hospederia {
    //definir atributos
    protected boolean conChimenea;

    //Constructores
    public Cabagna() {
    }

    public Cabagna(DatosCliente cliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int capacidad, boolean esFumador, boolean conChimenea) {
        super(cliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidad, esFumador);
        this.conChimenea = conChimenea;
    }

    //Accesaodres y Mutadores
    public boolean isConChimenea() {
        return conChimenea;
    }

    public void setConChimenea(boolean conChimenea) {
        this.conChimenea = conChimenea;
    }

    //Método que retorna el adicional (Se sobre escribe de la Clase Hospederia)
    @Override
    public int adicional() {
        return 0;
    }

    //Método que retorna el valor a cancelar (Se sobreescribe de la clase Medio de Alojamiento)
    @Override
    public int valorACancelar() {
        int valorACancelar = 0;
        valorACancelar = this.subtotal() + this.incrementoValorBase() - this.bonoDescuento();
        return valorACancelar;
    }

    //Método que retorna el incremento en el valor base (Se sobreescribe de la clase Hospederia)
    @Override
    public int incrementoValorBase() {
        int incrementoValorBase = 0;
        if (this.getCapacidad() > 5) {
            incrementoValorBase = Math.round(this.getValorBaseNoche() * 18 / 100);
            return incrementoValorBase;
        } else {
            return 0;
        }
    }
}
