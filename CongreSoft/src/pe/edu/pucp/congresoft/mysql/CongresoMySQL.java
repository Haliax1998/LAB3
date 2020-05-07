/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.congresoft.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.config.DBManager;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;

/**
 *
 * @author: Karl Campos
 * @codigo: 20161008
 */
public class CongresoMySQL implements CongresoDAO{

    @Override
    public int insertar(Congreso congreso) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            
            String sql="INSERT INTO CONGRESO(NOMBRE,FECHA_INICIO,FECHA_FIN,PAIS,ACTIVO)"+"VALUES(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, congreso.getNombre());
            ps.setDate(2, new java.sql.Date(congreso.getFechaIni().getTime()));
            ps.setDate(3, new java.sql.Date(congreso.getFechaFin().getTime()));
            ps.setString(4, congreso.getPais());
            if(congreso.getActivo())
                ps.setInt(5,1);
            else
                ps.setInt(5, 0);
            
            resultado = ps.executeUpdate();
            
            con.close();
            }catch(Exception ex){
                System.out.print(ex.getMessage());
        }
            
        return resultado;    
    }

    @Override
    public ArrayList<Congreso> listar() {
        ArrayList<Congreso>congresos=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String sentencia="Select* from CONGRESO";
            Statement st = con.createStatement();
            //executeQuery -> SELECT
            //executeUpdate -> INSERT, UPDATE, DELETE
            ResultSet rs=st.executeQuery(sentencia);
            //recorres las filas del select
            while(rs.next()){
                Congreso congreso=new Congreso();
                congreso.setId(rs.getInt("ID_CONGRESO"));
                congreso.setNombre(rs.getString("NOMBRE"));
                congreso.setFechaIni(rs.getDate("FECHA_INICIO"));
                congreso.setFechaFin(rs.getDate("FECHA_FIN"));
                congreso.setPais(rs.getString("PAIS")); 
                congreso.setActivo(rs.getBoolean("ACTIVO"));
                
                congresos.add(congreso);
            }
            con.close();
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return congresos;
    }

}
