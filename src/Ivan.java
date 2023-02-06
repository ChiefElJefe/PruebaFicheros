import java.sql.*;
import java.util.Scanner;

public class Ivan {
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Scanner teclado;

    //Iniciamos el servidor en el constructor
    public Ivan() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vehiculos_motorizados",
                    "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.teclado = new Scanner(System.in);
    }

    public void borrar(){
        System.out.println("Introduce id: ");
        String id = teclado.nextLine();
        System.out.println("Introduce part_number: ");
        String part_number = teclado.nextLine();
        int part_number2;
        try {
            part_number2 = Integer.parseInt(part_number);
            teclado.nextLine();
        }catch (Exception e){
            part_number2 = 0;
        }
        try {
            sentencia = conexion.prepareStatement("DELETE FROM tienda WHERE ? = ?");
            sentencia.setString(1, id);
            sentencia.setInt(2, part_number2);
            sentencia.executeUpdate();
            sentencia.close();
            resultado.close();
            conexion.close();
        }catch (Exception e){
            try {
                e.printStackTrace();
                sentencia.close();
                resultado.close();
                conexion.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}
