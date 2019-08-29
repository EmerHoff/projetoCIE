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
import java.util.Date;

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
            if (isValidacaoCadastrada(estudante.codigoCliente + estudante.codigoEstudante)) {
                excluirCIE(estudante.codigoCliente + estudante.codigoEstudante);
            }
            //executa query
            stm.executeUpdate("INSERT INTO validacao (codigoEstudante, validade, codigoCertificado) VALUES ('" + estudante.getCodigoCliente() + estudante.getCodigoEstudante() + "', '" + estudante.getDataValidade() + "', '" + estudante.getCodigoPEM() + "');");
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
            if (isEstudanteCadastrado(estudante.codigoCliente + estudante.codigoEstudante)) {
                excluirCIE(estudante.codigoCliente + estudante.codigoEstudante);
            }
            
            stm.executeUpdate("INSERT INTO estudante(codigoCliente, codigoEstudante, dataNascimento, CPF, numeroMatricula, RG, orgaoExpeditor, instituicao, grauEscolaridade, nomeCurso, municipioInstituicao, UFInstituicao, nomeSocial, nomeEstudante, QRCode, id)\n"
                    + " VALUES ('" + estudante.getCodigoCliente() + "', '" + estudante.getCodigoEstudante() + "', '" + estudante.getDataNascimento() + "', '" + estudante.getCPF() + "', '" + estudante.getNumeroMatricula() + "', '" + estudante.getRG() + "', '" + estudante.getOrgaoExpeditor() + "', '" + estudante.getInstituicao() + "', '" + estudante.getGrauEscolaridade() + "', '" + estudante.getNomeCurso() + "', '" + estudante.getMunicipioInstituicao() + "', '" + estudante.getUFInstituicao() + "', '" + estudante.getNomeSocial() + "', '" + estudante.getNomeEstudante() + "', '" + estudante.getQRCode() + "', '" + estudante.codigoCliente + estudante.codigoEstudante + "');");

        }
        //fechaConexao();
    }

    public void buscaCertificado() throws SQLException {
        if (connection != null) {
            //cria statement para executar a query
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM validacao;");

            while (rs.next()) {
                int codigoEstudante = rs.getInt("codigoEstudante");
                String codigoCertificado = rs.getString("codigoCertificado");
                System.out.format("%s, %s\n", codigoEstudante, codigoCertificado);
            }
        }
    }

    public Date buscaCIEValidade(String codigoEstudante) throws SQLException {
        Date validade = null;
        if (connection != null) {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT validade FROM validacao where codigoEstudante = '" + codigoEstudante + "' limit 1;");

            while (rs.next()) {
                validade = rs.getDate("validade");
                return validade;
            }
        }
        return validade;
    }

    public Estudante buscaCIEInformacoes(String codigoEstudante) throws SQLException {
        Estudante estudante = new Estudante();
        if (connection != null) {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM estudante where id = '" + codigoEstudante + "' limit 1;");

            while (rs.next()) {
                estudante.setNomeEstudante(rs.getString("nomeEstudante"));
                estudante.setInstituicao(rs.getString("instituicao"));
                estudante.setNomeCurso(rs.getString("nomeCurso"));
                estudante.setCPF(rs.getString("CPF"));
            }
        }
        return estudante;
    }

    public boolean excluirCIE(String codigoEstudante) throws SQLException {
        if (connection != null) {
            Statement stm = connection.createStatement();
            boolean excluiuEstudante = stm.execute("DELETE FROM estudante where id = '" + codigoEstudante + "';");
            boolean excluiuValidacao = stm.execute("DELETE FROM validacao where codigoEstudante = '" + codigoEstudante + "';");

            if (excluiuEstudante && excluiuValidacao) {
                return true;
            }
        }
        return false;
    }

    public boolean salvaAlteracoesCIE(String codigoEstudante, String validade) throws SQLException {
        if (connection != null) {
            Statement stm = connection.createStatement();
            boolean alterouValidade = stm.execute("UPDATE validacao SET validade = '" + validade + "' WHERE codigoEstudante = '" + codigoEstudante + "';");
            if (alterouValidade) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidacaoCadastrada(String codigoEstudante) throws SQLException {
        if (connection != null) {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM validacao where codigoEstudante = '" + codigoEstudante + "';");
            while (rs.next()) {
                return true;
            }
        }
        return false;
    }

    public boolean isEstudanteCadastrado(String codigoEstudante) throws SQLException {
        if (connection != null) {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM estudante where id = '" + codigoEstudante + "';");
            while (rs.next()) {
                return true;
            }
        }
        return false;
    }
    
    public void zerarAnoCIE(String anoDeletar) throws SQLException {
        if (connection != null) {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT codigoEstudante FROM validacao WHERE validade LIKE '" + anoDeletar + "-%';");
            while (rs.next()) {
                excluirCIE(rs.getString("codigoEstudante"));
            }
        }
    }
}
