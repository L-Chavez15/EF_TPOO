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

    public boolean setIdCompra(Integer idCompra)
    {
        if (idCompra != null)
        {
            if (idCompra >= 0)
            {
                this.idCompra = idCompra;
                return true;
            }
        }

        System.out.println("ERROR: ID DE COMPRA INVALIDO");
        return false;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalCompra() {
        return calcularTotalCompra();
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public ArrayList<DetalleCompra> getLista_detalleCompra() {
        return lista_detalleCompra;
    }

    public boolean setLista_detalleCompra(ArrayList<DetalleCompra> lista_detalleCompra) 
    {
        if (lista_detalleCompra == null)
        {
            System.out.println("ERROR: LISTA DE COMPRA INVALIDA");
            return false;
        }

        for (DetalleCompra dc : lista_detalleCompra)
        {
            if (dc == null)
            {
                System.out.println("ERROR: DETALLE DE COMPRA INVALIDO");
                return false;
            }
        }

        this.lista_detalleCompra = lista_detalleCompra;
        calcularTotalCompra();
        return true;
    }
    
    public boolean agregarDetalle(DetalleCompra dc) 
    {
         if (dc != null) {
            lista_detalleCompra.add(dc);
            calcularTotalCompra();
            return true;
        }
        else 
        {
            System.out.println("Detalle de compra invalido");
            return false;
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
