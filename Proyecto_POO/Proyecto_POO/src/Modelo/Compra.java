/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author leoch
 */
public class Compra 
{
    private Integer idCompra;
    private LocalDate fechaCompra;
    private double totalCompra;
    private ArrayList<DetalleCompra> lista_detalleCompra;

    public Compra(Integer idCompra, LocalDate fechaCompra) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
        this.totalCompra = 0;
        this.lista_detalleCompra = new ArrayList<>();
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public ArrayList<DetalleCompra> getLista_detalleCompra() {
        return lista_detalleCompra;
    }

    public void setLista_detalleCompra(ArrayList<DetalleCompra> lista_detalleCompra) {
        this.lista_detalleCompra = lista_detalleCompra;
    }
    
    public void agregarDetalle(DetalleCompra dc) {
        if (dc != null) {
            lista_detalleCompra.add(dc);
            calcularTotalCompra();
        }
    }

    public double calcularTotalCompra() {
        totalCompra = 0;
        for (DetalleCompra dc : lista_detalleCompra) {
            totalCompra += dc.calcularSubtotal();
        }
        return totalCompra;
    }

    public void mostrar() {
        System.out.println("===== COMPRA =====");
        System.out.println("ID Compra: " + idCompra);
        System.out.println("Fecha: " + fechaCompra);
        System.out.println("--- Detalles de compra ---");
        for (DetalleCompra dc : lista_detalleCompra) {
            dc.mostrar();
        }
        calcularTotalCompra();
        System.out.println("Total de compra: S/ " + totalCompra);
    }
    
}
