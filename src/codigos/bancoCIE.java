/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson
 */
public class bancoCIE {

    public static Connection connection = null;

    public void conexaoMysql() {
        System.out.println("Conectando ao banco...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://191.252.196.37:3306/projetocie", "root", "cr4ch4admin");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    /*public void abreConexao() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bancoCIE.class.getName()).log(Level.SEVERE, null, ex);
        }

        //connection = DriverManager.getConnection("jdbc:postgresql://192.168.0.85:5432/projetoCIE", "postgres", "ehoffmann");
        connection = DriverManager.getConnection("jdbc:postgresql://191.252.196.37:5432/projetocie", "projetocie", "cr4ch4admin");

        //System.out.println("Conexao com Sucesso");
        //connection.close();
    }*/

    public void fechaConexao() throws SQLException {
        connection.close();
    }

    public void insereValidacao(Estudante estudante) throws SQLException {
        //abreConexao();
        //conexaoMysql();
        if (connection != null) {
            //cria statement para executar a query
            Statement stm = connection.createStatement();
            //executa query
            //INSERT INTO validacao (codigoEstudante, codigoCertificado) VALUES (504440, 'tesdsadate');
            stm.executeUpdate("INSERT INTO validacao (codigoEstudante, validade, codigoCertificado) VALUES (" + Integer.parseInt(estudante.getCodigoCliente() + estudante.getCodigoEstudante()) + ", '" + estudante.getDataValidade() + "', '"+ estudante.getCodigoPEM() + "');");
            //postgres:   stm.executeUpdate("INSERT INTO validacao (\"codigoEstudante\", \"codigoCertificado\") VALUES (" + Integer.parseInt(estudante.getCodigoCliente() + estudante.getCodigoEstudante()) + ", '" + estudante.getCodigoPEM() + "')");
        }
        //fechaConexao();
    }

    public void insereEstudante(Estudante estudante) throws SQLException {
        //abreConexao();
        //conexaoMysql();
        if (connection != null) {
            //cria statement para executar a query
            Statement stm = connection.createStatement();
            //executa query
            stm.executeUpdate("INSERT INTO estudante(codigoCliente, codigoEstudante, dataNascimento, CPF, numeroMatricula, RG, orgaoExpeditor, instituicao, grauEscolaridade, nomeCurso, municipioInstituicao, UFInstituicao, nomeSocial, nomeEstudante, QRCode, id)\n"
                    + " VALUES ('" + estudante.getCodigoCliente() + "', '" + estudante.getCodigoEstudante() + "', '" + estudante.getDataNascimento() + "', '" + estudante.getCPF() + "', '" + estudante.getNumeroMatricula() + "', '" + estudante.getRG() + "', '" + estudante.getOrgaoExpeditor() + "', '" + estudante.getInstituicao() + "', '" + estudante.getGrauEscolaridade() + "', '" + estudante.getNomeCurso() + "', '" + estudante.getMunicipioInstituicao() + "', '" + estudante.getUFInstituicao() + "', '" + estudante.getNomeSocial() + "', '" + estudante.getNomeEstudante() + "', '" + estudante.getQRCode() + "', '" + estudante.codigoCliente + estudante.codigoEstudante + "');");
        }
        //fechaConexao();
    }

    public void buscaCertificado() throws SQLException {
        //conexaoMysql();
        if (connection != null) {
            //cria statement para executar a query
            Statement stm = connection.createStatement();
            //executa query
            //stm.executeUpdate("");

            // execute the query, and get a java resultset
            ResultSet rs = stm.executeQuery("SELECT * FROM validacao;");

            // iterate through the java resultset
            while (rs.next()) {
                int codigoEstudante = rs.getInt("codigoEstudante");
                String codigoCertificado = rs.getString("codigoCertificado");
                //String lastName = rs.getString("last_name");
                //Date dateCreated = rs.getDate("date_created");
                //boolean isAdmin = rs.getBoolean("is_admin");
                //int numPoints = rs.getInt("num_points");

                // print the results
                System.out.format("%s, %s\n", codigoEstudante, codigoCertificado);
            }

        }
        //fechaConexao();
    }
}
