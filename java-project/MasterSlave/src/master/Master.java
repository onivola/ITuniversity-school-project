/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import DAO.EmployerDAO;
import static DAO.EmployerDAO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import model.Employer;


public class Master {
	 public static Fenetre Fen;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Fen = new Fenetre();
        Vector v = EmployerDAO.GetColumn("slave1");
        Vector v2 = EmployerDAO.GetRows("slave1");
        //System.out.println(v);
       // System.out.println(v2);
 Employer p = new Employer("g", "g", "g","1980-08-24");
        
        p.setDateajout(p.Getcurrentdatetime());
        
       // System.out.println(Integer.parseInt("sdf"));
        //insert("slave1",p);
        
        p.setDateajout(p.Getcurrentdatetime());
        //EmployerDAO.insert("slave1",p);
    }
    
}


   /** ResultSet rs = findAll("slave1");
      //On récupère les MetaData
        while (rs.next()) {
           int IdEmployer = Integer.parseInt(rs.getString("id_employer")); 
           System.out.println(IdEmployer);
       }
        
        Employer p = new Employer(1,"test", "test", "1980-08-24", "test", "test@yahoo.fr", "0326598785");
        
        p.setDateajout(p.Getcurrentdatetime());
        insert("slave1",p);**/