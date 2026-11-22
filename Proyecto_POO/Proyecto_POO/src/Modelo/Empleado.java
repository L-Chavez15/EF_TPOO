/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoch
 */
public class Empleado extends Persona
{
    private String usuario;
    private String contrasena;
    private double sueldo;

    public Empleado() 
    {
    }
    public Empleado(String usuario, String contrasena, double sueldo, String nombre,String apellidoPa, String apellidoMa, String tipoDoc, String nroDoc, String telefono) {
        super(nombre, apellidoPa, apellidoMa, tipoDoc, nroDoc, telefono);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.sueldo = sueldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean setUsuario(String usuario) 
    {
        if (usuario != null)
        {
            if (usuario.length() > 0)
            {
                this.usuario = usuario;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL USUARIO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: EL USUARIO ES OBLIGATORIO");
            return false;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
     public void registrarVenta(Venta venta)
    {
        if (venta != null)
        {
            System.out.println("EL EMPLEADO REGISTRO LA VENTA");
            venta.mostrar();
        }
        else
        {
            System.out.println("NO EXISTE UNA VENTA");
        }
    }

    @Override
    public void verDatos() 
    {
         System.out.println("");
        System.out.println("::::::EMPLEADO::::::");
        System.out.println("USUARIO: "+ this.usuario);
        System.out.println("TIPO DOC: " + this.getTipoDoc()+ " NRO DOC: " + this.getNroDoc());
        System.out.println("NOMBRE: " + this.getNombre()+ " " + this.getApellido_pa()+ " " + this.getApellido_ma());
    }
}
