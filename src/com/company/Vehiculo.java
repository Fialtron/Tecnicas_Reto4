package com.company;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Vehiculo {

    private int id;
    private String placa;
    private String modelo;
    private String tipo;
    private LocalDate fechaModelo;
    private float alquilerHora;

    public Vehiculo(int miId, String miPlaca, String miModelo, String miTipo, LocalDate miFechaModelo,
            float miAlquilerHora) {

        id = miId;
        placa = miPlaca;
        modelo = miModelo;
        tipo = miTipo;
        fechaModelo = miFechaModelo;
        alquilerHora = miAlquilerHora;

    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public double getAlquilerHora() {
        return alquilerHora;
    }

    public String estadoVehiculo() {
        String estado = " ";

        double tiempo = ChronoUnit.YEARS.between(fechaModelo, LocalDate.now());

        if (tiempo <= 1) {
            estado = "Nuevo";
        } else if (tiempo > 1 && tiempo <= 2) {
            estado = "Medianamente usado";
        } else {
            estado = "Usado";
        }
        return estado;
    }

}
