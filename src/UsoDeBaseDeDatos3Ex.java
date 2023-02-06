import java.sql.*;
import java.util.Scanner;

public class UsoDeBaseDeDatos3Ex {
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Scanner teclado;

    //Iniciamos el servidor en el constructor
    public UsoDeBaseDeDatos3Ex() {
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

    public void insertar(){
        System.out.println("Introduce part_number: ");
        String part_number = teclado.nextLine();
        int part_number2;
        try {
            part_number2 = Integer.parseInt(part_number);
            teclado.nextLine();
        }catch (Exception e){
            part_number2 = 0;
        }
        System.out.println("Introduce descripcion: ");
        String descripcion = teclado.nextLine();
        System.out.println("Introduce color: ");
        String color = teclado.nextLine();
        System.out.println("Introduce familia: ");
        String familia = teclado.nextLine();
        System.out.println("Introduce precio: ");
        String precio = teclado.nextLine();
        int precio2;
        try{
            precio2 = Integer.parseInt(precio);
            teclado.nextLine();
        }catch (Exception e){
            precio2 = 0;
        }

        try{
            //1º Consulta
            conexion.setAutoCommit(false);
            sentencia = conexion.prepareStatement("INSERT INTO tienda (part_number, descripcion, color, familia, precio) VALUES(?, ?, ?, ?, ?)");
            sentencia.setInt(1, part_number2);
            sentencia.setString(2, descripcion);
            sentencia.setString(3, color);
            sentencia.setString(4, familia);
            sentencia.setInt(5, precio2);
            sentencia.executeUpdate();
            //2º Consulta
            sentencia = conexion.prepareStatement("SELECT * FROM tienda");
            resultado = sentencia.executeQuery();
            ResultSetMetaData obtenerCs = resultado.getMetaData();
            int columnass = obtenerCs.getColumnCount();
            while (resultado.next()) {
                for (int i = 1; i <= columnass; i++) {
                    System.out.print(resultado.getString(i));
                    if (i != columnass) {
                        System.out.print(";");
                    }
                }
                System.out.println("");
            }
            conexion.commit();
            conexion.setAutoCommit(true);
            sentencia.close();
            resultado.close();
            conexion.close();

        }catch (Exception e){
            try {
                System.out.println("Ha hecho un rollback");
                conexion.rollback();
                sentencia.close();
                resultado.close();
                conexion.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
