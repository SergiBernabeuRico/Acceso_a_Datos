package com.dam2;

import java.io.IOException;
import java.sql.*;


public class Ej4Sta {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("postgresql://localhost/pedidos", "root", "root")){
            try(Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){

                con.setAutoCommit(false);

                st.executeUpdate("INSERT INTO CATEGORIAS (categoriaid, nombreid) VALUES (555, 'minero");
                st.executeUpdate("INSERT INTO CATEGORIAS (categoriaid, nombreid) VALUES (555, 'minero");

                con.commit();
                System.out.println("filas añadidas");
            }catch (SQLException se){
                se.printStackTrace();
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
