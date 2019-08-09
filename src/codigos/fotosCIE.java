/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.io.File;
import java.util.Vector;
import java.util.logging.Level;

/**
 *
 * @author Emerson
 */
public class fotosCIE {
    
    ChannelSftp sftp;
    Session session;
        
    public Boolean listarFoto(String codigo, String enderecoDir) {
        System.out.println("entrou");
        File diretorio = new File(enderecoDir);
        File[] arquivos = diretorio.listFiles();
        
        for (int i = 0; i < arquivos.length; i++) {
            if(arquivos[i].getAbsolutePath().contains(codigo)){
                return enviaFotos(arquivos[i].getAbsolutePath(), arquivos[i].getName());
            }
        }
        
        return false;
    }
    
    public Boolean enviaFotos(String caminhoFoto, String nomeFoto) {
        try {
            sftp.put(caminhoFoto, nomeFoto);
            return true;
        } catch (SftpException ex) {
            java.util.logging.Logger.getLogger(fotosCIE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void abreSessao() {
        String userCSV = "admin";
        String passwordCSV = "cr4ch4admin";
        String hostCSV = "www.quempagameia.com.br";
        int portCSV = 22;
        
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(userCSV, hostCSV, portCSV);
            session.setPassword(passwordCSV);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("PreferredAuthentications", "password");
            session.setConfig(config);
            session.connect();

            try {
                sftp = (ChannelSftp) session.openChannel("sftp");
                sftp.connect();
                sftp.cd("/usr/share/nginx/html/fotosCIE");

                System.out.println("pwd 1: " + sftp.pwd());
            } catch (Exception e) {
            }
        } catch (JSchException e) {
        }
    }
    
    public void fechaConexao(){
        sftp.disconnect();
        session.disconnect();
    }
}
