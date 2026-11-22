/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Venta;
import java.util.ArrayList;

/**
 *
 * @author leoch
 */
public class ControladorVenta 
{
    private ArrayList<Venta> lista_ventas = new ArrayList();

    public boolean agregar(Venta venta_nueva)
    {
        if (venta_nueva != null)
        {
            if (this.buscar(venta_nueva.getIdVenta()) == null)
            {
                lista_ventas.add(venta_nueva);
                return true;
            }
            else
            {
                System.out.println("ERROR: EL ID DE VENTA YA ESTA REGISTRADO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: VENTA NO VALIDA");
            return false;
        }
    }

    public Venta buscar(int idVenta)
    {
        for (Venta v : lista_ventas)
        {
            if (v.getIdVenta() == idVenta)
            {
                return v;
            }
        }
        return null;
    }

    // Se utiliza para mostrar los registros en las tablas de la vista.
    public ArrayList<Venta> obtenerTodos()
    {
        return new ArrayList<Venta>(lista_ventas);
    }

    public void listar()
    {
        System.out.println("::::::::LISTA DE VENTAS::::::::");
        for (Venta v : lista_ventas)
        {
            v.mostrar();
            System.out.println("----------------------------");
        }
    }
    
}
