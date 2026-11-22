/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoch
 */
public class Producto 
{
    private Integer idProducto;
    private String nombre;
    private String talla;
    private String color;
    private double precio;
    private Integer stock;
    private Categoria categoria;

    public Producto(Integer idProducto, String nombre, String talla, String color,
                    double precio, Integer stock, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public boolean setIdProducto(Integer idProducto) 
    {
        if (idProducto > 0)
        {
            this.idProducto = idProducto;
            return true;
        }
        else
        {
            System.out.println("ERROR: ID DE PRODUCTO INVALIDO");
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) 
    {
       if (nombre != null && nombre.length() > 0) 
       {
        if (nombre.matches("[A-Z-a-z]+")) 
        {
            this.nombre = nombre;
            return true;
        } else {
            System.out.println("ERROR: EL NOMBRE SOLO DEBE CONTENER LETRAS");
            return false;
        }
       } else 
       {
        System.out.println("ERROR: INGRESE EL NOMBRE");
        return false;
       }
    }

    public String getTalla() {
        return talla;
    }

    public boolean setTalla(String talla) 
    {
        if (talla != null && talla.length() > 0)
        {
            this.talla = talla;
            return true;
        }
        else
        {
            System.out.println("ERROR: INGRESE LA TALLA");
            return false;
        }
    }

    public String getColor() {
        return color;
    }

    public boolean setColor(String color) 
    {
       if (color != null && color.length() > 0) 
       {
        if (color.matches("[A-Z-a-z]+")) 
        { 
            this.color = color;
            return true;
        } else {
            System.out.println("ERROR: EL COLOR SOLO DEBE CONTENER LETRAS");
            return false;
        }
       } else 
       {
        System.out.println("ERROR: INGRESE COLOR");
        return false;
       }
    }

    public double getPrecio() {
        return precio;
    }

    public boolean setPrecio(double precio) 
    {
         if (precio > 0)
        {
            this.precio = precio;
            return true;
        }
        else
        {
            System.out.println("ERROR: PRECIO INVALIDO");
            return false;
        }
    }

    public Integer getStock() {
        return stock;
    }

    public boolean setStock(Integer stock) 
    {
        if (stock >= 0)
        {
            this.stock = stock;
            return true;
        }
        else
        {
            System.out.println("ERROR: STOCK INVALIDO");
            return false;
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public double calcularPrecioFinal() 
    {
        return precio;
    }

    public void actualizarStock(int cantidad) 
    {
        if (cantidad > 0) {
            stock += cantidad;
        } else if (cantidad < 0) {
            if (stock + cantidad >= 0) {
                stock += cantidad;
            } else {
                System.out.println("No hay stock suficiente para " + nombre);
            }
        }
    }

    public void mostrar() 
    {
        System.out.println("===== PRODUCTO =====");
        System.out.println("ID: " + idProducto);
        System.out.println("Nombre: " + nombre);
        System.out.println("Talla: " + talla + " | Color: " + color);
        System.out.println("Precio: S/ " + precio + " | Stock: " + stock);
        if (categoria != null) {
            System.out.println("Categoria: " + categoria.getNombreCategoria());
        }
    }

}
