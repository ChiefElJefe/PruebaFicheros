import java.sql.*;

public class UsoBasedeDatos {
    Connection conexion;
    PreparedStatement sentencia;
    ResultSet resultado;

    public UsoBasedeDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vehiculos_motorizados",
                    "root", "root");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertarTabla(String dato1, String dato2){
        try {
            sentencia = conexion.prepareStatement("INSERT INTO sede (Sede, Nacionalidad) Values (?, ?)");
            sentencia.setString(1, dato1);
            sentencia.setString(2, dato2);
            sentencia.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizarTupla(String datooOr, String dato1, String dato2){
        try {
            sentencia = conexion.prepareStatement("UPDATE sede SET Sede = ?, Nacionalidad = ? WHERE Sede = ?");
            sentencia.setString(1, dato1);
            sentencia.setString(2, dato2);
            sentencia.setString(3, datooOr);
            sentencia.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void borrarDatos(String dato){
        try{
            sentencia = conexion.prepareStatement("DELETE FROM sede WHERE Sede = ?");
            sentencia.setString(1, dato);
            sentencia.executeUpdate();
        }catch (Exception e){

        }
    }

    public void listaDatos(String consulta){
        try{
            conexion.setAutoCommit(false);
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();
            ResultSetMetaData obtenerC = resultado.getMetaData();
            int columnas = obtenerC.getColumnCount();
            while(resultado.next()){
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(resultado.getString(i));
                    if (i != columnas) {
                        System.out.print(";");
                    }
                }
                System.out.println("");
            }
            conexion.commit();
            conexion.setAutoCommit(true);
        }catch (Exception e){
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void cerrarConexion(){
        try {
            sentencia.close();
            resultado.close();
            conexion.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
