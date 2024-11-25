package jerarquias;

public class Carpa extends MedioDeAlojamiento {
    //definir atributos
    protected int cantidadPersonas;

    //Constructores
    public Carpa() {
    }

    public Carpa(DatosCliente cliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int cantidadPersonas) {
        super(cliente, valorBaseNoche, cantidadNoches, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    //Accesadores y Mutadores
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    //Método que retorna el valor a cancelar (Se sobreescribe de la clase Medio de Alojamiento)
    @Override
    public int valorACancelar() {
        int valorACancelar= 0;
        valorACancelar= this.subtotal() - this.bonoDescuento();
        return valorACancelar;
    }
}
