/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Categoria;
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
    public boolean editar(Integer idProducto, String nombreNuevo, String tallaNueva,String colorNuevo, double precioNuevo, Integer stockNuevo, Categoria categoriaNueva)
    {
        Producto producto_editar = null;

        for (Producto p : lista_productos)
        {
            if (p.getIdProducto().equals(idProducto))
            {
                producto_editar = p;
            }
        }

        if (producto_editar != null)
        {
            for (Producto p : lista_productos)
            {
                if (!p.getIdProducto().equals(idProducto))
                {
                    if (p.getNombre().equalsIgnoreCase(nombreNuevo)
                            && p.getTalla().equalsIgnoreCase(tallaNueva)
                            && p.getColor().equalsIgnoreCase(colorNuevo))
                    {
                        System.out.println("ERROR: PRODUCTO YA REGISTRADO");
                        return false;
                    }
                }
            }
            producto_editar.setNombre(nombreNuevo);
            producto_editar.setTalla(tallaNueva);
            producto_editar.setColor(colorNuevo);
            producto_editar.setPrecio(precioNuevo);
            producto_editar.setStock(stockNuevo);
            producto_editar.setCategoria(categoriaNueva);

            return true;
        }

        return false;
    }
    public boolean eliminar(Integer idProducto)
    {
        Producto producto_eliminar = null;

        for (Producto p : lista_productos)
        {
            if (p.getIdProducto().equals(idProducto))
            {
                producto_eliminar = p;
            }
        }

        if (producto_eliminar != null)
        {
            lista_productos.remove(producto_eliminar);
            return true;
        }

        return false;
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
