/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Categoria;
import java.util.ArrayList;

/**
 *
 * @author leoch
 */
public class ControladorCategoria 
{
    private ArrayList<Categoria> lista_categorias = new ArrayList();

    public boolean agregar(Categoria categoria_nueva)
    {
        if (categoria_nueva != null)
        {
            if (this.buscar(categoria_nueva.getNombreCategoria()) == null)
            {
                lista_categorias.add(categoria_nueva);
                return true;
            }
            else
            {
                System.out.println("ERROR: CATEGORIA YA REGISTRADA");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: CATEGORIA NO VALIDA");
            return false;
        }
    }
    public boolean editar(Integer idCategoria, String nombreNuevo, String descripcionNueva)
    {
        if (nombreNuevo != null && !nombreNuevo.trim().isEmpty())
        {
            Categoria categoria_editar = null;

            for (Categoria c : lista_categorias)
            {
                if (c.getIdCategoria().equals(idCategoria))
                {
                    categoria_editar = c;
                }
            }

            if (categoria_editar != null)
            {
                for (Categoria c : lista_categorias)
                {
                    if (!c.getIdCategoria().equals(idCategoria))
                    {
                        if (c.getNombreCategoria().equalsIgnoreCase(nombreNuevo))
                        {
                            System.out.println("ERROR: CATEGORIA YA REGISTRADA");
                            return false;
                        }
                    }
                }
                categoria_editar.setNombreCategoria(nombreNuevo);
                categoria_editar.setDescripcion(descripcionNueva);
                return true;
            }
        }
        return false;
    }
    public boolean eliminar(Integer idCategoria)
    {
        Categoria categoria_eliminar = buscarPorId(idCategoria);

        if (categoria_eliminar != null)
        {
            lista_categorias.remove(categoria_eliminar);
            return true;
        }
        else
        {
            return false;
        }
    }
    public Categoria buscar(String nombre)
    {
        for (Categoria c : lista_categorias)
        {
            if (c.getNombreCategoria().equalsIgnoreCase(nombre))
            {
                return c;
            }
        }
        return null;
    }
    public Categoria buscarPorId(Integer idCategoria)
    {
        for (Categoria c : lista_categorias)
        {
            if (c.getIdCategoria().equals(idCategoria))
            {
                return c;
            }
        }

        return null;
    }

    // Se utiliza para mostrar los registros en las tablas de la vista.
    public ArrayList<Categoria> obtenerTodos()
    {
        return new ArrayList<Categoria>(lista_categorias);
    }

    public void listar()
    {
        System.out.println("::::::::LISTA DE CATEGORIAS::::::::");
        for (Categoria c : lista_categorias)
        {
            c.mostrar();
            System.out.println("----------------------------");
        }
    }
    
}
