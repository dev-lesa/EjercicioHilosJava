/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

/**
 *
 * @author Luis
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDNumeros {
    Conexiones BLcon = new Conexiones();

    // Listar todos los números - retorna ResultSet
    public ResultSet ListarTodos() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Numeros";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        return ps.executeQuery();
    }

    // Obtener cantidad total de registros
    public ResultSet ObtenerTotal() throws ClassNotFoundException, SQLException {
        String sql = "SELECT COUNT(*) as total FROM Numeros";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        return ps.executeQuery();
    }
}
