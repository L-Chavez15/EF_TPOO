/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoch
 */
public class Cliente extends Persona
{
    private int idCliente;

    public Cliente(int idCliente, String tipoDoc, String nroDoc, String Nombre, String Apellido_pa, String Apellido_ma, String Telefono) 
    {
        super(tipoDoc, nroDoc, Nombre, Apellido_pa, Apellido_ma, Telefono);
        this.idCliente = idCliente;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public boolean setIdCliente(int idCliente) 
    {
        if (idCliente > 0)
        {
            this.idCliente = idCliente;
            return true;
        }
        else
        {
            System.out.println("ERROR: ID DE CLIENTE INVALIDO");
            return false;
        }
    }
    
    public void realizarCompra(Compra compra) 
    {
        try
        {
            if (compra == null)
            {
                System.out.println("ERROR: NO EXISTE UNA COMPRA");
                return;
            }

            System.out.println("El cliente " + getNombre()
                    + " esta realizando una compra.");

            compra.mostrar();
        }
        catch (RuntimeException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void verDatos() 
    {
        System.out.println("===== CLIENTE =====");
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido paterno: " + this.getApellido_pa());
        System.out.println("Apellido materno: " + this.getApellido_ma());
        System.out.println("Tipo de documento: " + this.getTipoDoc());
        System.out.println("Número de documento: " + this.getNroDoc());
        System.out.println("Telefono: " + getTelefono());
    }
}
