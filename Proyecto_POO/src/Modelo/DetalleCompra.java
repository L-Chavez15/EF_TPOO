/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoch
 */
public class DetalleCompra 
{
    private Integer cantidad;
    private double precio;
    private Producto producto;

    public DetalleCompra(Integer cantidad, double precio, Producto producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public double calcularSubtotal() {
        return cantidad * precio;
    }

    public void mostrar() 
    {
        if (producto != null) {
            System.out.println("Producto: " + producto.getNombre());
        } else {
            System.out.println("Producto: Sin producto");
        }

        System.out.println("Cantidad: " + cantidad + " | Precio de compra: S/ " + precio + " | Subtotal: S/ " + calcularSubtotal());
    }
}
