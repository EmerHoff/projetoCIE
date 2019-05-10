/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;

import jxl.Cell;
import jxl.write.*;

import jxl.NumberCell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;

import javax.swing.JOptionPane;
import jxl.WorkbookSettings;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Emerson
 */
public class leitorExcel {

    public List lerArquivo(String enderecoArq) throws IOException, BiffException {

        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");
        Workbook workbook = Workbook.getWorkbook(new File(enderecoArq), conf);

        List<Estudante> listaEstudantes = new ArrayList<>();

        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();

        System.out.println("Iniciando a leitura da planilha XLS:");

        for (int i = 1; i < linhas; i++) {
            Estudante estudante = new Estudante();

            Cell celula = sheet.getCell(0, i);
            estudante.setCodigoCliente(celula.getContents());

            celula = sheet.getCell(1, i);
            estudante.setCodigoEstudante(celula.getContents());

            celula = sheet.getCell(2, i);
            estudante.setDataNascimento(celula.getContents());

            celula = sheet.getCell(3, i);
            estudante.setCPF(celula.getContents());

            celula = sheet.getCell(4, i);
            estudante.setNumeroMatricula(celula.getContents());

            celula = sheet.getCell(5, i);
            estudante.setRG(celula.getContents());

            celula = sheet.getCell(6, i);
            estudante.setOrgaoExpeditor(celula.getContents());

            celula = sheet.getCell(7, i);
            estudante.setInstituicao(celula.getContents());

            celula = sheet.getCell(8, i);
            estudante.setGrauEscolaridade(celula.getContents());

            celula = sheet.getCell(9, i);
            estudante.setNomeCurso(celula.getContents());

            celula = sheet.getCell(10, i);
            estudante.setMunicipioInstituicao(celula.getContents());

            celula = sheet.getCell(11, i);
            estudante.setUFInstituicao(celula.getContents());

            celula = sheet.getCell(12, i);
            estudante.setNomeSocial(celula.getContents());

            celula = sheet.getCell(13, i);
            estudante.setNomeEstudante(celula.getContents());

            if (!estudante.getCodigoCliente().equals("") && !estudante.getCodigoEstudante().equals("")) {
                listaEstudantes.add(estudante);
            }
        }
        workbook.close();

        return listaEstudantes;
    }

    public void confereRestricoes(List<Estudante> listaEstudantes) {
        for (int i = 0; i < listaEstudantes.size(); i++) {
            while (listaEstudantes.get(i).getCodigoCliente().length() < 7) {
                listaEstudantes.get(i).setCodigoCliente("0" + listaEstudantes.get(i).getCodigoCliente());
            }

            while (listaEstudantes.get(i).getCodigoEstudante().length() < 5) {
                listaEstudantes.get(i).setCodigoEstudante("0" + listaEstudantes.get(i).getCodigoEstudante());
            }

            while (listaEstudantes.get(i).getDataNascimento().length() < 8) {
                listaEstudantes.get(i).setDataNascimento("0" + listaEstudantes.get(i).getDataNascimento());
            }

            while (listaEstudantes.get(i).getCPF().length() < 11) {
                listaEstudantes.get(i).setCPF("0" + listaEstudantes.get(i).getCPF());
            }

            while (listaEstudantes.get(i).getNumeroMatricula().length() < 15) {
                listaEstudantes.get(i).setNumeroMatricula("0" + listaEstudantes.get(i).getNumeroMatricula());
            }

            while (listaEstudantes.get(i).getRG().length() < 15) {
                listaEstudantes.get(i).setRG("0" + listaEstudantes.get(i).getRG());
            }

            while (listaEstudantes.get(i).getOrgaoExpeditor().length() < 10) {
                listaEstudantes.get(i).setOrgaoExpeditor(listaEstudantes.get(i).getOrgaoExpeditor() + " ");
            }

            while (listaEstudantes.get(i).getInstituicao().length() < 40) {
                listaEstudantes.get(i).setInstituicao(listaEstudantes.get(i).getInstituicao() + " ");
            }

            while (listaEstudantes.get(i).getGrauEscolaridade().length() < 15) {
                listaEstudantes.get(i).setGrauEscolaridade(listaEstudantes.get(i).getGrauEscolaridade() + " ");
            }

            while (listaEstudantes.get(i).getNomeCurso().length() < 30) {
                listaEstudantes.get(i).setNomeCurso(listaEstudantes.get(i).getNomeCurso() + " ");
            }

            while (listaEstudantes.get(i).getMunicipioInstituicao().length() < 20) {
                listaEstudantes.get(i).setMunicipioInstituicao(listaEstudantes.get(i).getMunicipioInstituicao() + " ");
            }

            /*while(listaEstudantes.get(i).getUFInstituicao().length() < 2){
                listaEstudantes.get(i).setUFInstituicao(listaEstudantes.get(i).getUFInstituicao() + " ");
            }*/
            //Insere QrCode
            listaEstudantes.get(i).setQRCode("www.crachacartoes.com.br/validacao/" + listaEstudantes.get(i).getCodigoCliente() + listaEstudantes.get(i).getCodigoEstudante());
        }
    }

    public void insereQRCode(String enderecoArq, List<Estudante> listaEstudantes) throws IOException, BiffException, WriteException {
        //Reescreve a Planilha
        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");
        Workbook workbookAux = Workbook.getWorkbook(new File(enderecoArq), conf);
        Sheet sheet = workbookAux.getSheet(0);
        int linha = sheet.getRows();

        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("pt", "BR"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(enderecoArq), ws);
        WritableSheet s = workbook.createSheet("Planilha1", 0);

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < sheet.getColumns(); j++) {
                if (!sheet.getCell(j, i).getContents().equals("")) {//EXECUTA APENAS SE ACHAR ALGUM VALOR
                    Label l = new Label(j, i, sheet.getCell(j, i).getContents());
                    //PEGA TODA CONFIGURAÇÃO DA CÉLULA E ADICIONA
                    s.addCell(l);
                }
            }
        }

        //Adiciona o QRCode
        for (int i = 0; i < listaEstudantes.size(); i++) {
            Label l = new Label(14, i + 1, listaEstudantes.get(i).getQRCode());
            //Label l = new Label(14, i, enderecoArq)

            s.addCell(l);
        }

        workbook.write();
        workbook.close();

    }

    public void SalvarTXT(String endereco, List<Estudante> listaEstudantes) {
        FileWriter arq;
        try {

            arq = new FileWriter(endereco.substring(0, endereco.length() - 4) + "TXT.txt");

            PrintWriter gravarArq = new PrintWriter(arq);

            for (int i = 0; i < listaEstudantes.size(); i++) {
                gravarArq.println("PEM (estudante " + listaEstudantes.get(i).getCodigoEstudante() + "): " + listaEstudantes.get(i).getCodigoPEM() + "\r\n");
            }

            arq.close();
            System.out.println("Arquivo gravado com sucesso");
        } catch (IOException ex) {
            Logger.getLogger(leitorExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
