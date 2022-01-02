package accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Manzaba
 */
public class Usuario {

    private Conexion conexion;
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contraseña;
    private String fechanacimiento;
    

    public Usuario() {
        conexion = new Conexion();
    }

    public boolean registrar(String Nombres, String Apellidos, String Correo, String Fecha, String Contraseña) {
        nombres = Nombres;
        apellidos = Apellidos;
        correo = Correo;
        fechanacimiento = Fecha;
        contraseña = Contraseña;
        if (conexion.isEstado()) {

            try {
                String sentencia = "insert into usuarios (nombres, apellidos, fechanacimiento, correo, contraseña)"
                        + " values('" + nombres + "','" + apellidos + "','" + fechanacimiento + "','" + correo + "','" + contraseña + "') ";

                conexion.insertUsuario(sentencia);
                return true;
            } catch (Exception e) {

            }
        }
        return false;
    }

    public boolean obtenerDatosUsuario(String correo) {
        if (conexion.isEstado()) {
            try {
                String sentencia = "select * from usuarios where correo='"+correo+"'"; 
                ResultSet resultset = conexion.selectUsuario(sentencia);
                try{
                    if(resultset.next()){
                        this.id = resultset.getString("id");
                        this.nombres = resultset.getString("nombres");
                        this.apellidos = resultset.getString("apellidos");
                        this.correo = resultset.getString("correo");
                        this.contraseña = resultset.getString("contraseña");
                        this.fechanacimiento = resultset.getString("fechanacimiento");
                    }
                     return true;
                }
                catch(Exception e){
                    
                }
               
            } catch (Exception ex) {

            }
        }
        return false;
    }
    public boolean verficarDatos(String Correo, String Contraseña){
        boolean existe = obtenerContraseña(Correo);
        if(existe){
            if(Contraseña == this.contraseña)
                return true;
        }
        return false;
    }
    private boolean obtenerContraseña(String correo) {
        if (conexion.isEstado()) {
            try {
                String sentencia = "select contraseña from usuarios where correo='"+correo+"'"; 
                ResultSet resultset = conexion.selectUsuario(sentencia);
                try{
                    if(resultset.next()){
                        this.contraseña = resultset.getString("contraseña");
                    }
                     return true;
                }
                catch(Exception e){
                    
                }
               
            } catch (Exception ex) {

            }
        }
        return false;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public String getId() {
        return id;
    }

}
