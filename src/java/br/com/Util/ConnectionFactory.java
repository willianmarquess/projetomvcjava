/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Willian
 */
public class ConnectionFactory {

    //método que retorna uma conexão com o banco postgres
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetomvc", "postgres", "willian");
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    //método que fecha a conexão com o banco de dados

    public static void close(Connection con, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void
            closeConnection(Connection con,
                    Statement stmt, ResultSet rs)
            throws Exception {
        close(con, stmt, rs);

    }

    public static void
            closeConnection(Connection con,
                    Statement stmt)
            throws Exception {
        close(con, stmt, null);

    }

    public static void
            closeConnection(Connection con)
            throws Exception {
        close(con, null, null);

    }

}
