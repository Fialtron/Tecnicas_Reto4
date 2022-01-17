package com.company;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Seguro {

    private int id;
    private Vehiculo vehiculo;
    private LocalDate inicioSeguro;
    private LocalDate finSeguro;
    private String empresa;
    private String descripcion;

    public Seguro(  int miId,Vehiculo miVehiculo,
                    LocalDate miInicioSeguro,LocalDate miFinSeguro, 
                    String miEmpresa, String miDescripcion){
        id = miId;
        vehiculo = miVehiculo;
        inicioSeguro = miInicioSeguro;
        finSeguro = miFinSeguro;
        empresa = miEmpresa;
        descripcion = miDescripcion;                
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public LocalDate getFinSeguro() {
        return finSeguro;
    }

    public int getId() {
        return id;
    }

    public LocalDate getInicioSeguro() {
        return inicioSeguro;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double cobertura(){
        double diasCobertura = ChronoUnit.DAYS.between(inicioSeguro, finSeguro);   
        return diasCobertura;
    }
  
}
