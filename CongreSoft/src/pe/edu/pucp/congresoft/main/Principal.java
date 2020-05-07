/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.congresoft.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;
import pe.edu.pucp.congresoft.mysql.CongresoMySQL;

/**
 *
 * @author: Karl Campos
 * @codigo: 20161008
 */
public class Principal {
    public static void main(String[] args) throws ParseException{
        ArrayList<Congreso>congresos= new ArrayList<>();
        CongresoDAO daoCongreso=new CongresoMySQL();
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Congreso c1 =new Congreso("INTERACT 2021",
                sdf.parse("01-01-2021"),sdf.parse("05-01-2021"),"BOLIVIA",true);
        daoCongreso.insertar(c1);
        congresos=daoCongreso.listar();
        
        
        for(Congreso e: congresos){
            System.out.println(e.imprimirDatos());
        }
    }
}
