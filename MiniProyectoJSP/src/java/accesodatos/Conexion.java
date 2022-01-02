package accesodatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mauricio Manzaba
 */
public class Conexion extends Object{
    private Connection basededatos;
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            try{
                basededatos = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techstore", "postgres", "ivanmau9");
                setEstado(true);
            }
            catch(SQLException e){
                setEstado(false);
            }
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public int insertUsuario(String sentencia){
        int reg = -1;
        try {
            Statement statement = basededatos.createStatement();
            try{
                reg = statement.executeUpdate(sentencia);               
            }
            catch(SQLException e){
                setEstado(false);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            cerrar();
        }
       return reg;
    }
      private void cerrar() {
        try {
            basededatos.close();
        } catch (SQLException e) {
        }
    }
      
    /**
     *
     * @param sentencia
     * @return
     */
    public ResultSet selectUsuario(String sentencia)
      {
          ResultSet resultSet = null;
        
        try {
            Statement statement = basededatos.createStatement();
            try {
                resultSet = statement.executeQuery(sentencia);
                setEstado(true);
            } catch (SQLException e) {
                setEstado(false);
            }
        } catch (SQLException e) {
            setEstado(false);
        }

        return resultSet;
      }

}
