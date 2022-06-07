/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemasOperacionais;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static trabalhoSistemasOperacionais.BestFit.bestFit;

/**
 *
 * @author ferna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //!!!!!!!!!!!!Atenção!!!!!!!!!!!!! Mude o local do arquivo abaixo↓       
        File file = new File("C:\\Users\\ferna\\OneDrive\\Documentos\\NetBeansProjects\\JavaApplication6\\src\\trabalhoSistemasOperacionais\\APS.txt");
         
        //Declaração das variáveis 
        int[] linhaProcesso = new int[0];
        int[] linhaMemoria = new int[0];
        Scanner sc = null;
        
        //Lendo o arquivo de texto
        try {
                sc = new Scanner(file);
               
                for (int i = 0; sc.hasNextLine(); i++) {
                    String linhaAtual = sc.nextLine();
                    String novoVetor []= linhaAtual.split(";");
                    
                    
                    if (i==0) {
                        linhaMemoria = new int[novoVetor.length];
                        for (int j = 0; j < novoVetor.length; j++) {
                            linhaMemoria[j] = Integer.parseInt(novoVetor[j]);
                        }
                    } else {
                        linhaProcesso = new int[novoVetor.length];
                        for (int j = 0; j < novoVetor.length; j++) {
                            linhaProcesso[j] = Integer.parseInt(novoVetor[j]);
                    }
                }
            }
        } 
        catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
        } 
        finally {
                if (sc != null) {
                        sc.close();
                }
        }
        
        
        //Execução do processo de simulação
        System.out.println("Neste trabalho será simulado o processo de alocação contígua com partições de memória dinâmicas chamado Best-fit.\n\n\n");
        
         int tamanhoBloco[] = linhaMemoria;
         int tamanhoProcesso[] = linhaProcesso;
         int m = tamanhoBloco.length;
         int n = tamanhoProcesso.length;
          
         bestFit(tamanhoBloco, m, tamanhoProcesso, n);
        
    }
    
}
