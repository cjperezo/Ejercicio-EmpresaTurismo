package controladora;

import jerarquias.Cabagna;
import jerarquias.Carpa;
import jerarquias.Hotel;
import jerarquias.MedioDeAlojamiento;

import java.util.ArrayList;

public class EmpresaTurismo {
    //definir atributos
    private ArrayList<MedioDeAlojamiento> nomada;

    //Constructores
    public EmpresaTurismo() {
        this.nomada= new ArrayList<>();
    }

    public EmpresaTurismo(ArrayList<MedioDeAlojamiento> nomada) {
        this.nomada = nomada;
    }

    //Accesadores y Mutadores
    public ArrayList<MedioDeAlojamiento> getEmpresa() {
        return nomada;
    }

    public void setEmpresa(ArrayList<MedioDeAlojamiento> nomada) {
        this.nomada = nomada;
    }

    //Métodos con la lógica que requiere la aplicación
    public int buscarMedioAlojamiento(String rutCliente){
        for(int i=0;i<nomada.size();i++){
            if(nomada.get(i).getCliente().getRut().compareToIgnoreCase(rutCliente) == 0){ //el alojamiento se encontró
                return i;
            }
        }
        return -1; //no se encontró----> Registrar
    }

    //Método para ingresar objeto tipo Carpa a la colección
    public void ingresarCarpa(Carpa carpa){
        if(this.buscarMedioAlojamiento(carpa.getCliente().getRut()) ==-1){ //el medio de alojamiento no esta registrado
            nomada.add(carpa);
        }
    }

    //Método para ingresar objetivo tipo Hotel a la colección
    public void ingresarHotel(Hotel hotel) {
        if (this.buscarMedioAlojamiento(hotel.getCliente().getRut()) == -1) { //el medio de alojamiento no esta registrado
            nomada.add(hotel);
        }
    }

    //Método para ingresar objeto tipo Cabaña a la colección
    public void ingresarCabagna(Cabagna cabagna) {
        if (this.buscarMedioAlojamiento(cabagna.getCliente().getRut()) == -1) { //el medio de alojamiento no esta registrado
            nomada.add(cabagna);
        }
    }

    //Metodo para calcular el total adicional
    public String totalAdicional(EmpresaTurismo nomada, String rutCliente) {
        StringBuilder mensaje = new StringBuilder();
        boolean clienteEncontrado = false;

        for (MedioDeAlojamiento alojamiento : nomada.getEmpresa()) {
            if (alojamiento.getCliente().getRut().equals(rutCliente)) {
                clienteEncontrado = true;
                mensaje.append("Nombre del Cliente: ").append(alojamiento.getCliente().getNombre()).append("\n")
                        .append("Tipo de Alojamiento: ");
                if (alojamiento instanceof Carpa) {
                    Carpa carpa = (Carpa) alojamiento;
                    mensaje.append("Carpa\n")
                            .append("Total Adicional: $0");
                } else if (alojamiento instanceof Hotel) {
                    Hotel hotel = (Hotel) alojamiento;
                    mensaje.append("Hotel\n")
                            .append("Total Adicional: $").append(hotel.adicional()).append("\n\n");
                } else if (alojamiento instanceof Cabagna) {
                    Cabagna cabagna = (Cabagna) alojamiento;
                    mensaje.append("Cabaña\n")
                            .append("Total Adicional: $").append(cabagna.adicional()).append("\n\n");
                }
            }
        }

        if (!clienteEncontrado) {
            mensaje.append("El cliente no se encuentra registrado en este lugar.\n");
        }
        return mensaje.toString();
    }

    //Método para calcular el total de bono descuento
    public String totalBonoDescuento(EmpresaTurismo nomada, String rutCliente){
        StringBuilder mensaje = new StringBuilder();
        boolean clienteEncontrado = false;

        for (MedioDeAlojamiento alojamiento : nomada.getEmpresa()) {
            if (alojamiento.getCliente().getRut().equals(rutCliente)) {
                clienteEncontrado = true;
                mensaje.append("Nombre del Cliente: ").append(alojamiento.getCliente().getNombre()).append("\n")
                        .append("Tipo de Alojamiento: ");
                if (alojamiento instanceof Carpa) {
                    Carpa carpa = (Carpa) alojamiento;
                    mensaje.append("Carpa\n")
                            .append("Total Bono Descuento: $").append(carpa.bonoDescuento()).append("\n\n");
                } else if (alojamiento instanceof Hotel) {
                    Hotel hotel = (Hotel) alojamiento;
                    mensaje.append("Hotel\n")
                            .append("Total Bono Descuento: $").append(hotel.bonoDescuento()).append("\n\n");
                } else if (alojamiento instanceof Cabagna) {
                    Cabagna cabagna = (Cabagna) alojamiento;
                    mensaje.append("Cabaña\n")
                            .append("Total Bono Descuento: $").append(cabagna.bonoDescuento()).append("\n\n");
                }
            }
        }

        if (!clienteEncontrado) {
            mensaje.append("El cliente no se encuentra registrado en este lugar.\n");
        }

        return mensaje.toString();
    }

    //Metodo para calcular la cantidad de medios de alojamiento
    public String cantidadMedioAlojamiento(){
        int cantidadCarpas = 0;
        int cantidadHoteles = 0;
        int cantidadCabagnas = 0;

        for (MedioDeAlojamiento alojamiento : this.getEmpresa()) {
            if (alojamiento instanceof Carpa) {
                cantidadCarpas++;
            } else if (alojamiento instanceof Hotel) {
                cantidadHoteles++;
            } else if (alojamiento instanceof Cabagna) {
                cantidadCabagnas++;
            }
        }

        return "Cantidad de Carpas: " + cantidadCarpas + "\n" +
                "Cantidad de Hoteles: " + cantidadHoteles + "\n" +
                "Cantidad de Cabañas: " + cantidadCabagnas;
    }

    // Metodo para calcular el valor a cancelar por un cliente X
    public String valorACancelarX(EmpresaTurismo nomada, String rutCliente) {
        StringBuilder mensaje = new StringBuilder();
        boolean clienteEncontrado = false;

        for (MedioDeAlojamiento alojamiento : nomada.getEmpresa()) {
            if (alojamiento.getCliente().getRut().equals(rutCliente)) {
                clienteEncontrado = true;
                mensaje.append("Nombre del Cliente: ").append(alojamiento.getCliente().getNombre()).append("\n")
                        .append("Tipo de Alojamiento: ");
                if (alojamiento instanceof Carpa) {
                    Carpa carpa = (Carpa) alojamiento;
                    mensaje.append("Carpa\n")
                            .append("Valor a Cancelar: $").append(carpa.valorACancelar()).append("\n\n");
                } else if (alojamiento instanceof Hotel) {
                    Hotel hotel = (Hotel) alojamiento;
                    mensaje.append("Hotel\n")
                            .append("Valor a Cancelar: $").append(hotel.valorACancelar()).append("\n\n");
                } else if (alojamiento instanceof Cabagna) {
                    Cabagna cabagna = (Cabagna) alojamiento;
                    mensaje.append("Cabaña\n")
                            .append("Valor a Cancelar: $").append(cabagna.valorACancelar()).append("\n\n");
                }
            }
        }

        if (!clienteEncontrado) {
            mensaje.append("El cliente no se encuentra registrado en este lugar.\n");
        }

        return mensaje.toString();
    }


    //Método para aplicar el incremento de valor base donde corresponda
    public String incrementoValorBase(EmpresaTurismo nomada, String rutCliente){
        StringBuilder mensaje = new StringBuilder();
        boolean clienteEncontrado = false;

        for (MedioDeAlojamiento alojamiento : nomada.getEmpresa()) {
            if (alojamiento.getCliente().getRut().equals(rutCliente)) {
                clienteEncontrado = true;
                mensaje.append("Nombre del Cliente: ").append(alojamiento.getCliente().getNombre()).append("\n")
                        .append("Tipo de Alojamiento: ");
                if (alojamiento instanceof Carpa) {
                    Carpa carpa = (Carpa) alojamiento;
                    mensaje.append("Carpa\n")
                            .append("Incremento Valor Base: 0$");
                } else if (alojamiento instanceof Hotel) {
                    Hotel hotel = (Hotel) alojamiento;
                    mensaje.append("Hotel\n")
                            .append("Incremento Valor Base: $").append(hotel.incrementoValorBase()).append("\n\n");
                } else if (alojamiento instanceof Cabagna) {
                    Cabagna cabagna = (Cabagna) alojamiento;
                    mensaje.append("Cabaña\n")
                            .append("Incremento Valor Base: $").append(cabagna.incrementoValorBase()).append("\n\n");
                }
            }
        }

        if (!clienteEncontrado) {
            mensaje.append("El cliente no se encuentra registrado en este lugar.\n");
        }

        return mensaje.toString();
    }
}

