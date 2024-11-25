package jerarquias;

public abstract class MedioDeAlojamiento {
    //definir atributos
    protected DatosCliente cliente;
    protected int valorBaseNoche;
    protected int cantidadNoches;
    protected String tipoTemporada;

    //Constructores
    public MedioDeAlojamiento() {
    }

    public MedioDeAlojamiento(DatosCliente cliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada) {
        this.cliente = cliente;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
    }

    //Accesadores y Mutadores

    public DatosCliente getCliente() {
        return cliente;
    }

    public void setCliente(DatosCliente cliente) {
        this.cliente = cliente;
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    //Método que retorna el subtotal
    public int subtotal(){
        int subtotal = this.getCantidadNoches() * this.getValorBaseNoche();
        return subtotal;
    }

    //Método que retorna el Bono descuento
    public int bonoDescuento(){
        int bonoDescuento;
        //descuento del 25% si es temporada baja
        if(this.getTipoTemporada().equalsIgnoreCase("Baja")){
            bonoDescuento= Math.round(this.subtotal()*(25/100));
            //descuento del 12.5% si es temporada media
        }else if(this.getTipoTemporada().equalsIgnoreCase("Media")){
            bonoDescuento= (int) Math.round(this.subtotal()*(12.5/100));
        }else{
            bonoDescuento= 0;
        }
        return bonoDescuento;
    }

    /*Método que retorna el valor a cancelar.
    Como el valor a cancelar se aplica de manera distinta en los medios de alojamiento
    se debe crear el método como abstracto y sobreescribir el mismo en las clases que lo heredan*/

    public abstract int valorACancelar();

}
