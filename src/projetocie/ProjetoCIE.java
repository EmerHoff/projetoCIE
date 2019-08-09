/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocie;

import com.oss.asn1.BadObjectIdentifierException;
import com.oss.asn1.ValidateNotSupportedException;
import java.io.IOException;
import java.security.CryptoPrimitive;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author LCASS
 */
 
public class ProjetoCIE extends Application {
    
    @Override
    public void start(Stage stage) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("CIEView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Gerador CIE - Cracha e Cartoes");
        stage.setResizable(false);//desabilita botao maximizar
        stage.setScene(scene);
        stage.show();

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
