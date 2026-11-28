/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author leoch
 */
public class ControladorProducto 
{
    private ArrayList<Producto> lista_productos = new ArrayList();

    public boolean agregar(Producto producto_nuevo)
    {
        if (producto_nuevo != null)
        {
            if (this.buscar(producto_nuevo.getIdProducto()) == null)
            {
                lista_productos.add(producto_nuevo);
                return true;
            }
            else
            {
                System.out.println("ERROR: EL ID DEL PRODUCTO YA ESTA REGISTRADO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: PRODUCTO NO VALIDO");
            return false;
        }
    }

    public Producto buscar(int idProducto)
    {
        for (Producto p : lista_productos)
        {
            if (p.getIdProducto() == idProducto)
            {
                return p;
            }
        }
        return null;
    }
    
    //busca si existe un producto con el mismo nombre, talla y color
    public boolean existeProducto(String nombre, String talla, String color)
    {
        //obtenemos los registros existentes
        for (Producto p : lista_productos)
        {
            //verificamos si existe la misma combinación de nombre, talla y color
            if (p.getNombre().equalsIgnoreCase(nombre)&& p.getTalla().equalsIgnoreCase(talla)&& p.getColor().equalsIgnoreCase(color))
            {
                return true;
            }
        }
        //si no existe la combinación, retorna false
        return false;
    }
    

    // Se utiliza para mostrar los registros en las tablas de la vista.
    public ArrayList<Producto> obtenerTodos()
    {
        return new ArrayList<Producto>(lista_productos);
    }

    public void listar()
    {
        System.out.println("::::::::LISTA DE PRODUCTOS::::::::");
        for (Producto p : lista_productos)
        {
            p.mostrar();
            System.out.println("----------------------------");
        }
    }
    
}
