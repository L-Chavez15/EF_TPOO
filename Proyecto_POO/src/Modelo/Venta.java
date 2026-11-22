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
public class Venta
{
    private Integer idVenta;
    private LocalDate fecha;
    private double total;
    private Cliente cliente;
    private Empleado empleado;
    private FormaPago formaPago;
    private ArrayList<DetalleVenta> lista_detalleVenta;
    
    public Venta(Integer idVenta, LocalDate fecha, double total, Cliente cliente, Empleado empleado, FormaPago formaPago, ArrayList lista_detalleVenta) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = 0;
        this.cliente = cliente;
        this.empleado = empleado;
        this.formaPago = formaPago;
        this.lista_detalleVenta = lista_detalleVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public boolean setIdVenta(Integer idVenta) 
    {
        if (idVenta > 0)
        {
            this.idVenta = idVenta;
            return true;
        }
        else
        {
            System.out.println("ERROR: ID DE VENTA INVALIDO");
            return false;
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean setFecha(LocalDate fecha) 
    {
        if (fecha != null )
        {
            this.fecha = fecha;
            return true;
        }
        else
        {
            System.out.println("ERROR: INGRESE LA FECHA");
            return false;
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public ArrayList getLista_detalleVenta() {
        return lista_detalleVenta;
    }

    public void setLista_detalleVenta(ArrayList lista_detalleVenta) {
        this.lista_detalleVenta = lista_detalleVenta;
    }
    
     public void agregarDetalle(DetalleVenta dv) {
        if (dv != null) {
            lista_detalleVenta.add(dv);
            calcularTotal();
        }
    }

    public double calcularTotal() 
    {
        total = 0;
        for (DetalleVenta dv : lista_detalleVenta) {
            total += dv.calcularSubtotal();
        }
        return total;
    }

    public void mostrar() {
        System.out.println("===== VENTA =====");
        System.out.println("ID Venta: " + idVenta);
        System.out.println("Fecha: " + fecha);
        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido_pa());
        }
        if (empleado != null) {
            System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido_pa());
        }
        System.out.println("--- Detalles ---");
        for (DetalleVenta dv : lista_detalleVenta) {
            dv.mostrar();
        }
        calcularTotal();
        System.out.println("Total de venta: S/ " + total);
        if (formaPago != null) {
            formaPago.mostrar();
        }
    }
    
}
