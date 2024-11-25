package presentacion;

import controladora.EmpresaTurismo;
import jerarquias.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        EmpresaTurismo nomada = new EmpresaTurismo(new ArrayList<>());
        int opcion;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    crearAlojamiento(nomada);
                    break;
                case 2:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else {
                        mostrarTodosLosAlojamientos(nomada);
                    }
                    break;
                case 3:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else {
                        System.out.println("Ingrese el RUT del cliente:");
                        String rutCliente = Leer.dato();
                        mostrarDatosClienteX(nomada, rutCliente);
                    }
                    break;
                case 4:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else{
                        mostrarTotalAdicional(nomada);
                    }
                    break;
                case 5:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else{
                        mostrarTotalBonoDescuento(nomada);
                    }
                    break;
                case 6:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else{
                        mostrarCantidadMediosAlojamiento(nomada);
                    }
                    break;
                case 7:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else{
                        mostrarValorACancelarPorCliente(nomada);
                    }
                    break;
                case 8:
                    if (nomada.getEmpresa().isEmpty()) {
                        System.out.println("***Por Favor Ingrese Datos de Alojamiento para Continuar***");
                    } else{
                        aplicarIncrementoValorBase(nomada);
                    }
                    break;
            }

        } while (opcion != 9);
    }

    public static int menu() {
        System.out.println("---------------------------");
        System.out.println("******TURISMOS NÓMADA******");
        System.out.println("    Sistema de Registros   ");
        System.out.println("---------------------------");
        System.out.println("1.) Ingresar Medio de Alojamiento (Carpa, Hotel, Cabaña)");
        System.out.println("2.) Mostrar Medios de Alojamiento almacenados");
        System.out.println("3.) Datos de un Cliente en particular");
        System.out.println("4.) Total Adicional");
        System.out.println("5.) Total Bono Descuento");
        System.out.println("6.) Cantidad de Medios de Alojamiento X");
        System.out.println("7.) Valor a Cancelar por un Cliente en particular");
        System.out.println("8.) Aplicar Incremento del Valor Base ");
        System.out.println("9.) Salir");
        return Leer.datoInt();
    }

    public static String pedirId() {
        System.out.println("***Por Favor, Ingrese el RUT del Cliente***");
        return Leer.dato();
    }

    public static void crearAlojamiento(EmpresaTurismo nomada) {
        boolean registrarOtro = true;

        while (registrarOtro) {
            System.out.println("---------------------");
            System.out.println("  REGISTRO CLIENTE  ");
            System.out.println("---------------------");

            String rutCliente = pedirId();

            if (nomada.buscarMedioAlojamiento(rutCliente) == -1) { // No está registrado el cliente
                System.out.println("***No existe Registro de este Cliente. Favor Registrar***");
                System.out.println(" ");

                String nombre;
                String[] datosNombre;
                do {
                    System.out.println("**Nombre del Cliente (Nombre y Apellido)**");
                    nombre = Leer.dato();
                    datosNombre = nombre.split(" ");
                } while (datosNombre.length != 2);

                System.out.println("**Ingrese el valor base por noche**");
                int valorBaseNoche = Leer.datoInt();

                System.out.println("**Ingrese la cantidad de noches**");
                int cantidadNoches = Leer.datoInt();

                String tipoTemporada;
                do {
                    System.out.println("Ingrese Tipo de Temporada (Alta, Media, Baja)");
                    tipoTemporada = Leer.dato();
                } while (!tipoTemporada.equalsIgnoreCase("Alta") &&
                        !tipoTemporada.equalsIgnoreCase("Media") &&
                        !tipoTemporada.equalsIgnoreCase("Baja"));

                int respuesta;
                do {
                    System.out.println("***Ingrese Medio de Alojamiento***");
                    System.out.println("1.) Carpa");
                    System.out.println("2.) Hotel");
                    System.out.println("3.) Cabaña");
                    respuesta = Leer.datoInt();
                } while (respuesta < 1 || respuesta > 3);

                DatosCliente cliente = new DatosCliente(nombre, rutCliente);

                if (respuesta == 1) {
                    System.out.println("***Alojamiento CARPA***");
                    System.out.println("--> Ingrese la Cantidad de Personas");
                    int cantidadPersonas = Leer.datoInt();

                    Carpa carpa = new Carpa(cliente, valorBaseNoche, cantidadNoches, tipoTemporada, cantidadPersonas);
                    nomada.ingresarCarpa(carpa);
                    System.out.println("***Alojamiento CARPA Registrado Exitosamente***");

                } else if (respuesta == 2) {
                    System.out.println("***Alojamiento HOTEL***");
                    System.out.println("--> Ingrese la Capacidad");
                    int capacidadHotel = Leer.datoInt();
                    System.out.println("--> ¿Desayuno Incluido? (Sí/No)");
                    boolean conDesayuno = Leer.datoBoolean();
                    System.out.println("--> ¿El Cliente es Fumador? (Sí/No)");
                    boolean esFumador = Leer.datoBoolean();

                    Hotel hotel = new Hotel(cliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidadHotel, conDesayuno, esFumador);
                    nomada.ingresarHotel(hotel);
                    System.out.println("***Alojamiento HOTEL Registrado Exitosamente***");

                } else {
                    System.out.println("***Alojamiento CABAÑA***");
                    System.out.println("--> Ingrese la Capacidad");
                    int capacidadCabagna = Leer.datoInt();
                    System.out.println("--> ¿Con Chimenea? (Sí/No)");
                    boolean conChimenea = Leer.datoBoolean();
                    System.out.println("--> ¿El Cliente es Fumador? (Sí/No)");
                    boolean esFumador = Leer.datoBoolean();

                    Cabagna cabagna = new Cabagna(cliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidadCabagna, esFumador, conChimenea);
                    nomada.ingresarCabagna(cabagna);
                    System.out.println("***Alojamiento CABAÑA Registrado Exitosamente***");
                }
            } else {
                System.out.println("El cliente ya tiene un medio de alojamiento registrado.");
            }

            System.out.println(" ");
            System.out.println("***¿Desea Registrar otro Alojamiento?***");
            System.out.println("1. Sí");
            System.out.println("2. No, volver al menú principal");
            int respuesta = Leer.datoInt();
            registrarOtro = (respuesta == 1);
        }
    }


    public static void mostrarTodosLosAlojamientos(EmpresaTurismo nomada) {
        for (MedioDeAlojamiento alojamiento : nomada.getEmpresa()) {
            mostrarMedioAlojamiento(alojamiento);
        }
    }

    public static void mostrarMedioAlojamiento(MedioDeAlojamiento alojamiento) {
        System.out.println("---------------------------------");
        System.out.println(" DATOS DEL ALOJAMIENTO REGISTRADO");
        System.out.println("---------------------------------");
        System.out.println("Nombre del Cliente: " + alojamiento.getCliente().getNombre());
        System.out.println("Rut del Cliente: " + alojamiento.getCliente().getRut());
        System.out.println("Valor Base por Noche: " + alojamiento.getValorBaseNoche());
        System.out.println("Cantidad de Noches: " + alojamiento.getCantidadNoches() + " Noches");
        System.out.println("Tipo de Temporada: " + alojamiento.getTipoTemporada());

        if (alojamiento instanceof Carpa) {
            Carpa carpa = (Carpa) alojamiento;
            System.out.println("Tipo de Alojamiento: Carpa");
            System.out.println("Cantidad de Personas: " + carpa.getCantidadPersonas() + " Personas");
        } else if (alojamiento instanceof Hotel) {
            Hotel hotel = (Hotel) alojamiento;
            System.out.println("Tipo de Alojamiento: Hotel");
            System.out.println("Capacidad: " + hotel.getCapacidad() + " Personas");
            System.out.println("Desayuno Incluido: " + (hotel.isConDesayuno()? "Sí" : "No"));
            System.out.println("Cliente Fumador: " + (hotel.isEsFumador()? "Sí" : "No"));
        } else if (alojamiento instanceof Cabagna) {
            Cabagna cabagna = (Cabagna) alojamiento;
            System.out.println("Tipo de Alojamiento: Cabaña");
            System.out.println("Capacidad: " + cabagna.getCapacidad() + " Personas");
            System.out.println("Con Chimenea: " + (cabagna.isConChimenea()? "Sí" : "No"));
            System.out.println("Cliente Fumador: " + (cabagna.isEsFumador()? "Sí" : "No"));
        }
    }


    public static void mostrarDatosClienteX(EmpresaTurismo nomada, String rutCliente) {
        System.out.println("------------------------");
        System.out.println("    DATOS DEL CLIENTE   ");
        System.out.println("------------------------");

        boolean clienteEncontrado = false;

        for (MedioDeAlojamiento alojamiento : nomada.getEmpresa()) {

            if (alojamiento.getCliente().getRut().equals(rutCliente)) {
                clienteEncontrado = true;
                System.out.println("Nombre del Cliente: " + alojamiento.getCliente().getNombre());
                System.out.println("Rut del Cliente: " + alojamiento.getCliente().getRut());
                System.out.println("Valor Base por Noche: " + alojamiento.getValorBaseNoche());
                System.out.println("Cantidad de Noches: " + alojamiento.getCantidadNoches() + " Noches");
                System.out.println("Tipo de Temporada: " + alojamiento.getTipoTemporada());

                if (alojamiento instanceof Carpa) {
                    Carpa carpa = (Carpa) alojamiento;
                    System.out.println("Tipo de Alojamiento: Carpa");
                    System.out.println("Cantidad de Personas: " + carpa.getCantidadPersonas() + " Personas");
                } else if (alojamiento instanceof Hotel) {
                    Hotel hotel = (Hotel) alojamiento;
                    System.out.println("Tipo de Alojamiento: Hotel");
                    System.out.println("Capacidad: " + hotel.getCapacidad() + " Personas");
                    System.out.println("Desayuno Incluido: " + (hotel.isConDesayuno() ? "Sí" : "No"));
                    System.out.println("Cliente Fumador: " + (hotel.isEsFumador() ? "Sí" : "No"));
                } else if (alojamiento instanceof Cabagna) {
                    Cabagna cabagna = (Cabagna) alojamiento;
                    System.out.println("Tipo de Alojamiento: Cabaña");
                    System.out.println("Capacidad: " + cabagna.getCapacidad() + " Personas");
                    System.out.println("Con Chimenea: " + (cabagna.isConChimenea() ? "Sí" : "No"));
                    System.out.println("Cliente Fumador: " + (cabagna.isEsFumador() ? "Sí" : "No"));
                }
                System.out.println("---------------------------------");
            }
        }

        if (!clienteEncontrado) {
            System.out.println("El cliente no se encuentra registrado en este lugar.");
        }
    }

    public static void mostrarTotalAdicional(EmpresaTurismo nomada) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese RUT del Cliente para calcular el Total Adicional");
        System.out.println("---------------------------------------------------------");
        String rutCliente = Leer.dato();

        System.out.println(nomada.totalAdicional(nomada,rutCliente));
    }

    public static void mostrarTotalBonoDescuento(EmpresaTurismo nomada) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese RUT del Cliente para calcular el Bono Descuento");
        System.out.println("---------------------------------------------------------");
        String rutCliente = Leer.dato();

        System.out.println(nomada.totalBonoDescuento(nomada,rutCliente));
    }

    public static void mostrarCantidadMediosAlojamiento(EmpresaTurismo nomada) {
        System.out.println("---------------------------------");
        System.out.println("CANTIDAD DE MEDIOS DE ALOJAMIENTO");
        System.out.println("---------------------------------");

        String cantidad= nomada.cantidadMedioAlojamiento();
        System.out.println(cantidad);
    }

    public static void mostrarValorACancelarPorCliente(EmpresaTurismo nomada) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese RUT del Cliente para calcular el Valor a Cancelar");
        System.out.println("---------------------------------------------------------");
        String rutCliente = Leer.dato();

        System.out.println(nomada.valorACancelarX(nomada, rutCliente));
    }

    public static void aplicarIncrementoValorBase(EmpresaTurismo nomada) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese RUT del Cliente para calcular el incremento en el Valor Base");
        System.out.println("---------------------------------------------------------");
        String rutCliente = Leer.dato();

        System.out.println(nomada.incrementoValorBase(nomada, rutCliente));
    }

}