/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;
import java.sql.*;
/**
 *
 * @author luciana
 */
public class TesteBD {
//Objeto que guarda informacoes da conexao com o SGBD.
    private Connection conn;

    //Objeto usado para enviar comandos SQL no SGBD
    private Statement stmt;


	public TesteBD(){

     try{
   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	  String conexao = "jdbc:mysql://mysql-xoler.jelastic.websolute.net.br/xoler";
          String usuario = "xoler";
          String senha = "123xoler";
           conn = DriverManager.getConnection(conexao,usuario,senha);
           stmt = conn.createStatement();


           
  System.out.println("ConexÃ£o OK!!!");

           conn.close();
     }
     catch (Exception e){
         e.printStackTrace();
         System.out.println("Erro");
     }

        }


public static void main (String args[]){
  TesteBD t=new TesteBD();
}
}