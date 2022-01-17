package com.company;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Alquiler {

    private int id;
    private Vehiculo vehiculo;
    private LocalDateTime inicioAlquiler;
    private LocalDateTime finAlquiler;
    private String tipoDocumento;
    private String documento;
    private String alquilador;
    private String uso;
    private double valor;

    public Alquiler(int miId, Vehiculo miVehiculo, LocalDateTime miInicioAlquiler,
            LocalDateTime miFinAlquiler, String miTipoDocumento,
            String miDocumento, String miAlquilador, String miUso) {

        id = miId;
        vehiculo = miVehiculo;
        inicioAlquiler = miInicioAlquiler;
        finAlquiler = miFinAlquiler;
        tipoDocumento = miTipoDocumento;
        documento = miDocumento;
        alquilador = miAlquilador;
        uso = miUso;
        valor = calculoValor();

    }

    public int getId() {
        return id;
    }

    public String getAlquilador() {
        return alquilador;
    }

    public LocalDateTime getFinAlquiler() {
        return finAlquiler;
    }

    public double getValor() {
        return valor;
    }

    public String getUso() {
        return uso;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getInicioAlquiler() {
        return inicioAlquiler;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    private double calculoValor() {
        double valorAlquiler = 0;
        double tiempo = ChronoUnit.HOURS.between(inicioAlquiler, finAlquiler);
        valorAlquiler = tiempo*vehiculo.getAlquilerHora();
        return valorAlquiler;
    }

    public double duracionAlquiler() {
        double duracion = ChronoUnit.HOURS.between(inicioAlquiler, finAlquiler);
        return duracion;
    }

}
