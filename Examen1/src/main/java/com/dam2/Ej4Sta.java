package com.dam2;

import java.sql.*;


public class Ej4Sta {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/pedidos", "root", "root"))
        {
            try(Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE))
            {
                con.setAutoCommit(false);

                st.executeUpdate("INSERT INTO CATEGORIAS (categoriaid, nombrecat) VALUES (555, 'Carpintero')");
                st.executeUpdate("INSERT INTO CATEGORIAS (categoriaid, nombrecat) VALUES (666, 'Diabólico')");

                con.commit();
                System.out.println("Las filas se han insertado correctamente");

            } catch(SQLException se){
                se.printStackTrace();
                con.rollback();
            } finally{
                con.setAutoCommit(true);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
