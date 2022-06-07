/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemasOperacionais;

/**
 *
 * @author ferna
 */
public class BestFit {
    static void bestFit(int tamanhoBloco[], int m, int tamanhoProcesso[],
            int n) {

        //Declarando as variáveis
        int maior = 0;
        int menor = 1;
        float media = 0; // variável para o cálculo de média
        int igualZero = 0; //Váriável para definir quantos blocos de memória são iguais a zero
        int soma = 0;      //Váriável para somar o tamanho restante de todos os blocos de memória
        int alocacao[] = new int[n];
        
        //Limpando as alocações.
        for (int i = 0; i < alocacao.length; i++) {
            alocacao[i] = -1;
        }

        // alocação do processo no bloco adequado, procurando o bloco que melhor se ajusta
        for (int i = 0; i < n; i++) {
            int melhorIdx = -1;
            for (int j = 0; j < m; j++) {
                if (tamanhoBloco[j] >= tamanhoProcesso[i]) {
                    if (melhorIdx == -1) {
                        melhorIdx = j;
                    } else if (tamanhoBloco[melhorIdx] > tamanhoBloco[j]) {
                        melhorIdx = j;
                    }
                }
            }

            // alocando o processo no melhor bloco
            if (melhorIdx != -1) {
                alocacao[i] = melhorIdx;

                // diminuindo o tamanho da memória do bloco
                tamanhoBloco[melhorIdx] -= tamanhoProcesso[i];
            }
        }

        System.out.println("--------------------------------------------\nResolutiva do questionameto 1.");
        
        // Encontarando o maior resto dos blocos de memória
        for (int i = 1; i < tamanhoBloco.length; i++) {
            if (tamanhoBloco[i] > tamanhoBloco[maior]) {
                maior = i;
            }
        }
        
        //Encontrando o menor resto entre os blocos de memória
        for (int i = 0; i < tamanhoBloco.length; i++) {
            if (tamanhoBloco[i] < tamanhoBloco[menor] && tamanhoBloco[i] != 0 && tamanhoBloco[menor] !=0) {
                menor = i;
            }
        }
        

        for (int i = 0; i < tamanhoBloco.length; i++) {
            soma += tamanhoBloco[i];
            if (tamanhoBloco[i] == 0) {
                igualZero++;
            }
        }
        
        if (tamanhoBloco.length - igualZero == 0) {
            media = 0;
        } else {
            media = soma / (tamanhoBloco.length - igualZero); //Média descontando os blocos vázios
        }
        


        System.out.println("\nNome do Bloco.\tTamanho dos Blocos\tQual a disponibilidade?.\n");
        for (int i = 0; i < m; i++) {
            System.out.print("   B" + (i + 1) + "\t\t" + tamanhoBloco[i] + "\t\t\t");
            if (tamanhoBloco[i] != 0) {
                System.out.print("Disponível para alocação");
            } else {
                System.out.print("Não disponível para alocação");
            }
            /*
            Os testes que serão feitos abaixo só procuram um número maior e um número menor, 
            isto é, na hipótese de restarem espaços similares o primeiro bloco (com valor repetido)
            será contabilizado como menor e/ou maior.
            */
            if (i == maior) {
                System.out.print(" e, além disso, esse é o maior espaço restante em um bloco de memória.");
            } else if (i == menor) {
                System.out.print(" e, além disso, esse é o menor espaço restante em um bloco de memória.");
            } else {
                System.out.print(". ");
            }

            System.out.println();
        }

        System.out.println("\n A média do espaço restante  nos blocos livres é: " + soma + "/(" + tamanhoBloco.length + "-" + igualZero + ") = " + media);

        System.out.println("\n\n--------------------------------------------\nResolutiva aglutinada dos questionametos 2 e 3.");
        System.out.println("\nNome do Processo.\tTamanho dos Processos\tBloco onde ele foi alocado.\n");
        for (int i = 0; i < n; i++) {
            System.out.print("   P" + (i + 1) + "\t\t\t" + tamanhoProcesso[i] + "\t\t\t");
            if (alocacao[i] != -1) {
                System.out.print(alocacao[i] + 1);
            } else {
                System.out.print("Não alocado");
            }
            System.out.println();
        }

    }

}
