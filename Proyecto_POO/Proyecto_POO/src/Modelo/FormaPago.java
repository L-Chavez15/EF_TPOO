/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author leoch
 */
public class FormaPago 
{
    private LocalDate fechaPago;
    private double montoPago;
    private String metodoPago;

    public FormaPago(LocalDate fechaPago, double montoPago, String metodoPago) {
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.metodoPago = metodoPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
     public void mostrar() 
     {
        System.out.println("--- FORMA DE PAGO ---");
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: S/ " + montoPago);
        System.out.println("Metodo: " + metodoPago);
    }
}
