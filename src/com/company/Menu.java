package com.company;

import java.util.*;
import java.time.*;

public class Menu {

    boolean exit = false;
    int option;
    private int nRegistros;
    private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private List<Seguro> seguros = new ArrayList<Seguro>();

    private Scanner sc = new Scanner(System.in);

    public Menu() {
        this.menu();
    }

    private void menu() {
        while (!exit) {
            System.out.print(" \n Menu \n 1. Registrar vehículos \n " +
                    "2. Registrar Alquileres \n " +
                    "3. Registrar Seguros \n " +
                    "4. Verificar duración de un alquiler en horas \n " +
                    "5. Verificar duración de un seguro en dias \n " +
                    "6. Verificar antiguedad de un vehículo \n " +
                    "7. Salir \n");
            System.out.print("Ingrese una opcion: ");
            try {
                option = Integer.parseInt(sc.next());
                switch (option) {
                    case 1:
                        registro(1);
                        break;
                    case 2:
                        if (vehiculos.size() != 0) {
                            registro(2);
                        } else {
                            System.out.print("Necesita tener vehiculos registrados para el uso de esta opcion ");
                        }
                        break;
                    case 3:
                        if (vehiculos.size() != 0) {
                            registro(3);
                        } else {
                            System.out.print("Necesita tener vehiculos registrados para el uso de esta opcion ");
                        }
                        break;
                    case 4:
                        if (vehiculos.size() != 0 ) {
                            duracionAlquiler();
                        } else {
                            System.out.print(
                                    "Necesita tener vehiculos registrados para el uso de esta opcion ");
                        }
                        break;
                    case 5:
                        if (vehiculos.size() != 0 ) {
                            coberturaSeguro();
                        } else {
                            System.out.print(
                                    "Necesita tener vehiculos  registrados para el uso de esta opcion ");
                        }
                        break;
                    case 6:
                        antiguedadVehiculo();
                        break;
                    case 7:
                        System.out.print("Hasta luego!");
                        exit = true;
                        break;
                    default:
                        System.out.print("Opcion no valida!\n\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
            }
        }
    }

    private void registro(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el numero de vehiculos que desea ingresar: ");
                try {
                    nRegistros = sc.nextInt();
                    if (nRegistros > 0) {

                        for (int i = 0; i < nRegistros; i++) {

                            int id = 0;
                            String placa = null;
                            String modelo = null;
                            String tipo = null;
                            String fechaModelo = null;
                            float alquilerHora;

                            try {
                                System.out.print(" \n Ingrese el identificador del vehiculo (numero sin puntos): ");
                                id = sc.nextInt();

                                System.out.print("Ingrese la placa del vehiculo: ");
                                placa = System.console().readLine();

                                System.out.print("Ingrese el modelo del vehiculo: ");
                                modelo = System.console().readLine();

                                System.out.print("Ingrese el tipo de vehiculo: ");
                                tipo = System.console().readLine();

                                System.out.print("Ingrese el alquiler por hora del vehiculo: ");
                                alquilerHora = sc.nextFloat();

                                System.out.print("Ingrese la fecha del modelo con el siguiente formato aaaa-mm-dd: ");
                                fechaModelo = System.console().readLine();

                                vehiculos.add(new Vehiculo(id, placa, modelo, tipo, LocalDate.parse(fechaModelo),
                                        alquilerHora));

                            } catch (Exception e) {
                                System.out.println(
                                        "\n Ha ingresado incorrectamente la informacion. Por favor intente nuevamente\n\n");
                            }
                        }
                        System.out.print(" \n Vehiculos ingresados exitosamente ");
                    } else {
                        System.out.println("Inserte un numero mayor a 0. Por favor intente nuevamente\n\n");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
                }

                break;
            case 2:

                System.out.print("Ingrese el numero de alquileres que desea ingresar: ");

                try {

                    nRegistros = sc.nextInt();

                    if (nRegistros > 0) {

                        for (int i = 0; i < nRegistros; i++) {

                            int id = 0;
                            int idVehiculo = 0;
                            Vehiculo vehiculo = null;
                            String tipoDocumento = null;
                            String documento = null;
                            String alquilador = null;
                            String usoVehiculo = null;
                            LocalDateTime inicioAlquiler;
                            LocalDateTime finAlquiler;

                            try {

                                System.out.print(" \n Ingrese el identificador del alquiler (numero sin puntos): ");
                                id = sc.nextInt();
                                System.out
                                        .print("Seleccione el vehiculo que desea alquilar (por medio del simbolo #): ");
                                for (int j = 0; j < vehiculos.size(); j++) {
                                    System.out.print(" \n #: " + j + " Id: " + vehiculos.get(j).getId() + " Placa: "
                                            + vehiculos.get(j).getPlaca() + " Modelo: " + vehiculos.get(j).getModelo()
                                            + "  \n");
                                }

                                idVehiculo = sc.nextInt();
                                vehiculo = vehiculos.get(idVehiculo);
                                System.out.print("Ingrese el tipo de documento del alquilador: ");
                                tipoDocumento = System.console().readLine();
                                System.out.print("Ingrese el documento del alquilador: ");
                                documento = System.console().readLine();
                                System.out.print("Ingrese el nombre completo del alquilador: ");
                                alquilador = System.console().readLine();
                                System.out.print("Ingrese la fecha y hora del inicio del alquiler");
                                System.out.print(
                                        " \n Utilice el siguiente formato aaaa-mm-ddThh:mm:ss sin olvidar la T: ");
                                inicioAlquiler = LocalDateTime.parse(System.console().readLine());
                                System.out.print("Ingrese la fecha y hora del final del alquiler");
                                System.out.print(
                                        "\n Utilice el siguiente formato aaaa-mm-ddThh:mm:ss sin olvidar la T: ");
                                finAlquiler = LocalDateTime.parse(System.console().readLine());
                                System.out.print("Ingrese el uso que le dara al vehiculo: ");
                                usoVehiculo = System.console().readLine();

                                alquileres.add(new Alquiler(id, vehiculo, inicioAlquiler, finAlquiler, tipoDocumento,
                                        documento, alquilador, usoVehiculo));

                            } catch (Exception e) {
                                System.out.println(
                                        "\n Ha ingresado incorrectamente la informacion. Por favor intente nuevamente\n\n");
                            }

                            System.out.print(" \n Alquileres ingresados exitosamente ");
                        }

                    } else {
                        System.out.println("Inserte un numero mayor a 0. Por favor intente nuevamente\n\n");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
                }

                break;
            case 3:

                System.out.print("Ingrese el numero de seguros que desea ingresar: ");

                try {

                    nRegistros = sc.nextInt();

                    if (nRegistros > 0) {

                        for (int i = 0; i < nRegistros; i++) {

                            int id = 0;
                            int idVehiculo = 0;
                            Vehiculo vehiculo = null;
                            String empresa = null;
                            String descripcion = null;
                            LocalDate inicioSeguro;
                            LocalDate finSeguro;

                            try {

                                System.out.print(" \n Ingrese el identificador del Seguro (numero sin puntos): ");
                                id = sc.nextInt();
                                System.out
                                        .print("Seleccione el vehiculo que desea asegurar (por medio del simbolo #): ");
                                for (int j = 0; j < vehiculos.size(); j++) {
                                    System.out.print(" \n #: " + j + " Id: " + vehiculos.get(j).getId() + " Placa: "
                                            + vehiculos.get(j).getPlaca() + " Modelo: " + vehiculos.get(j).getModelo()
                                            + "  \n");
                                }

                                idVehiculo = sc.nextInt();
                                vehiculo = vehiculos.get(idVehiculo);
                                System.out.print("Ingrese el nombre de la empresa aseguradora: ");
                                empresa = System.console().readLine();
                                System.out.print("Ingrese la descripcion del seguro: ");
                                descripcion = System.console().readLine();
                                System.out.print("Ingrese la fecha del inicio del seguro");
                                System.out.print(
                                        " \n Utilice el siguiente formato aaaa-mm-dd: ");
                                inicioSeguro = LocalDate.parse(System.console().readLine());
                                System.out.print("Ingrese la fecha del final del seguro");
                                System.out.print(
                                        "\n Utilice el siguiente formato aaaa-mm-dd: ");
                                finSeguro = LocalDate.parse(System.console().readLine());

                                seguros.add(new Seguro(id, vehiculo, inicioSeguro, finSeguro, empresa, descripcion));

                            } catch (Exception e) {
                                System.out.println(
                                        "\n Ha ingresado incorrectamente la informacion. Por favor intente nuevamente\n\n");
                            }

                            System.out.print(" \n Seguros ingresados exitosamente ");
                        }

                    } else {
                        System.out.println("Inserte un numero mayor a 0. Por favor intente nuevamente\n\n");
                    }

                } catch (NumberFormatException ex) {
                    System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
                }
                break;

            default:
                break;
        }

    }

    private void antiguedadVehiculo() {
        int opcionVehiculo;

        if (!vehiculos.isEmpty()) {
            System.out.print(" \n Lista de vehiculos actuales:  \n");
            for (int i = 0; i < vehiculos.size(); i++) {
                System.out.print(" \n #: " + i + " Id: " + vehiculos.get(i).getId() + " Placa: "
                        + vehiculos.get(i).getPlaca() + " Modelo: " + vehiculos.get(i).getModelo() + "  \n");
            }
            try {
                System.out.print(" \n Seleccione por medio del # el vehiculo que desea verificar:  \n");
                opcionVehiculo = sc.nextInt();
                System.out.print("El vehiculo seleccionado se encuentra en estado: "
                        + vehiculos.get(opcionVehiculo).estadoVehiculo() + "\n");
            } catch (Exception e) {
                System.out.println("\n Ha ingresado incorrectamente la informacion. Por favor intente nuevamente\n\n");
            }

        } else {
            System.out.print(" \n Registre vehiculos para utilizar esta opcion  \n");
        }

    }

    private void duracionAlquiler() {
        int opcion;

        if (!alquileres.isEmpty()) {
            System.out.print(" \n Lista de alquileres actuales:  \n");
            for (int i = 0; i < alquileres.size(); i++) {
                System.out.print(" \n #: " + i + " Id: " + alquileres.get(i).getId() + " Alquilador: "
                        + alquileres.get(i).getAlquilador() + " Valor: " + alquileres.get(i).getValor() + "  \n");
            }
            try {
                System.out.print(" \n Seleccione por medio del # el alquiler que desea verificar:  \n");
                opcion = sc.nextInt();
                System.out.print("La duracion en horas del alquiler es : "
                        + alquileres.get(opcion).duracionAlquiler() + "\n");
            } catch (Exception e) {
                System.out.println("\n Ha ingresado incorrectamente la informacion. Por favor intente nuevamente\n\n");
            }

        } else {
            System.out.print(" \n Registre alquileres para utilizar esta opcion  \n");
        }

    }

    private void coberturaSeguro(){
        int opcion;

        if (!seguros.isEmpty()) {
            System.out.print(" \n Lista de seguros actuales:  \n");
            for (int i = 0; i < seguros.size(); i++) {
                System.out.print(" \n #: " + i + " Id: " + seguros.get(i).getId() + " Empresa: "
                        + seguros.get(i).getEmpresa() + " Placa vehiculo: " + seguros.get(i).getVehiculo().getPlaca() + "  \n");
            }
            try {
                System.out.print(" \n Seleccione por medio del # el seguro que desea verificar:  \n");
                opcion = sc.nextInt();
                System.out.print("La duracion en dias del seguro es : "
                        + seguros.get(opcion).cobertura() + "\n");
            } catch (Exception e) {
                System.out.println("\n Ha ingresado incorrectamente la informacion. Por favor intente nuevamente\n\n");
            }

        } else {
            System.out.print(" \n Registre alquileres para utilizar esta opcion  \n");
        }
    }

}
