package db;

import data.ContratosData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContratosDAO {

    //Método con la consulta sql
    public void introducirDatos(ContratosData contratos) throws SQLException {
        //Consulta
        String sql = "INSERT INTO contratos (nif, adjudicatario, objeto_generico, objeto, fecha_adjudicacion, importe, tipo_contrato)"
                + "VALUES (?,?,?,?,?,?,?)";

        try (Connection connec = MySQLConnection.getConnection(); 
             PreparedStatement ps = connec.prepareStatement(sql);) {

            //System.out.println("Nif: " + contratos.getNif());
            
            //Conecta con la base de datos y asigna los datos
            ps.setString(1, contratos.getNif());
            ps.setString(2, contratos.getAdjudicatario());
            ps.setString(3, contratos.getObjetoGenerico());
            ps.setString(4, contratos.getObjeto());
            
            if (contratos.getFechaAdjudicacion() != null){
            ps.setTimestamp(5, Timestamp.valueOf(contratos.getFechaAdjudicacion()));
                //System.out.println("Fecha insertada " + contratos.getFechaAdjudicacion());
            } else{
                ps.setNull(5, Types.TIMESTAMP);
            }
            
            ps.setDouble(6, contratos.getImporte());
            ps.setString(7, contratos.getTipoContrato());

            //Ejecuta la consulta e inserta los datos.
            int filasInsert = ps.executeUpdate();
            //System.out.println("Filas insertadas en la base de datos: " + filasInsert);

        } catch (SQLException e) {
            throw new RuntimeException("Error " + e.getMessage(), e);
        }
        
    }
        //Método para comprobar mediante una consulta que se insertaron los datos.
    public List<ContratosData> listarContratos(String nif, String adjudicatario, String objetoGenerico, String objeto, LocalDateTime fechaAdjudicacion, Double importe, String tipoContrato){
        List<ContratosData> salida = new ArrayList<>();

        String sql = "SELECT nif, adjudicatario, objeto_generico, objeto, fecha_adjudicacion, importe, tipo_contrato FROM contratos";

        try (Connection connec = MySQLConnection.getConnection(); PreparedStatement ps = connec.prepareStatement(sql);) {  
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ContratosData contrato = obtenerDatos(rs);
                salida.add(contrato);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error " + e.getMessage(), e);
        }
        return salida;
    }

    private ContratosData obtenerDatos(ResultSet rs) throws SQLException {
        
        //Si espera LocalDateTime.
        Timestamp timestamp = rs.getTimestamp("fecha_adjudicacion");
        LocalDateTime fecha = (timestamp != null) ? timestamp.toLocalDateTime() : null;
        
        ContratosData datosContratos = new ContratosData(
                rs.getString("nif"),
                rs.getString("adjudicatario"),
                rs.getString("objeto_generico"),
                rs.getString("objeto"),
                fecha,
                rs.getDouble("importe"),
                rs.getString("tipo_contrato"));

        return datosContratos;
    }
    
    //Método para eliminar datos de la base de datos y poder hacer pruebas.
    public void vaciarDatos() throws SQLException{
        String sql = "DELETE FROM contratos";
        try (Connection connec = MySQLConnection.getConnection(); 
             PreparedStatement ps = connec.prepareStatement(sql);) {
            
            int filasEliminadas = ps.executeUpdate();
            System.out.println("Filas eliminadas");
        } catch (SQLException e){
            throw new SQLException("Error al limpiar tabla: " + e.getMessage(), e);
        }
    }
}
