/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mark_
 */
public class MexeVetor {

    // CRIACAO DO MEU ESTADO FINAL ALEATORIO  
    public static Integer[] geraEstadoFinal() {
        List<Integer> estadoF = new ArrayList<Integer>();

        /* MEU VETOR DE PECAS 
         1 - PEÇAS PRETAS 
         2 - PEÇAS BRANCAS 
         0 - ESPAÇO VAZIO DENTRO DO MEU VETOR*/
        estadoF.add(1);
        estadoF.add(1);
        estadoF.add(1);
        estadoF.add(1);
        estadoF.add(1);
        estadoF.add(2);
        estadoF.add(2);
        estadoF.add(2);
        estadoF.add(2);
        estadoF.add(2);
        estadoF.add(0);

        Collections.shuffle(estadoF);
        Integer[] completo = estadoF.toArray(new Integer[estadoF.size()]); // MUDANCA DA MINHA LISTA PARA VETOR

        return completo;
    }

    // CRIACAO DO MEU ESTADO INICIAL DE MODO ALEATORIO
    public static Integer[] geraEstadoInicialAleatorio() {
        List<Integer> estadoI = new ArrayList<Integer>();

        /* MEU VETOR DE PECAS 
         1 - PEÇAS PRETAS 
         2 - PEÇAS BRANCAS 
         0 - ESPAÇO VAZIO DENTRO DO MEU VETOR*/
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(0);

        Collections.shuffle(estadoI);
        Integer[] vetF = estadoI.toArray(new Integer[estadoI.size()]); // MUDANCA DA MINHA LISTA PARA VETOR

        return vetF;
    }

    // CRIACAO DO MEU ESTADO FINAL NORMAL PRE DEFINIDO 
    public static Integer[] geraEstadoFinalNormal() {
        List<Integer> estadoI = new ArrayList<Integer>();

        /* MEU VETOR DE PECAS 
         1 - PEÇAS PRETAS 
         2 - PEÇAS BRANCAS 
         0 - ESPAÇO VAZIO DENTRO DO MEU VETOR*/
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(1);
        estadoI.add(0);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(2);
        estadoI.add(2);

        Integer[] vetF = estadoI.toArray(new Integer[estadoI.size()]); // MUDANCA DA MINHA LISTA PARA VETOR
        return vetF;
    }

    // FUNCAO DE VERIFICACAO IGUALITARIA
    public static boolean equals(Integer[] vetor1, Integer[] vetor2) { // compara minhas matrizes 
        if (vetor1 == vetor2) {
            return true;
        }

        if (vetor1.length != vetor2.length) {
            return false;
        }

        for (int i = 0; i < vetor1.length; i++) {
            if (vetor1[i] != vetor2[i]) {
                return false;
            } else {
            }
        }

        return true;
    }

    public static String print(Integer[] vetor) {
        if (vetor == null) {
            throw new IllegalArgumentException("matriz nula!");
        }
        StringBuilder stringBuilder = new StringBuilder();

        //concatenacao
        stringBuilder.append(String.format("| %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | ", MexeVetor.transformarCelula(vetor[0]), MexeVetor.transformarCelula(vetor[1]), MexeVetor.transformarCelula(vetor[2]), MexeVetor.transformarCelula(vetor[3]), MexeVetor.transformarCelula(vetor[4]),
                MexeVetor.transformarCelula(vetor[5]), MexeVetor.transformarCelula(vetor[6]), MexeVetor.transformarCelula(vetor[7]), MexeVetor.transformarCelula(vetor[8]), MexeVetor.transformarCelula(vetor[9]), MexeVetor.transformarCelula(vetor[10])));
        stringBuilder.append("\n");
        // Retornar resultado
        return stringBuilder.toString();
    }

    private static String transformarCelula(Integer valorCelula) { // verificacao com mudanca para string, verificar estado nulo s
        if (valorCelula == null) {
            return ""; // String vazia
        } else {
            return valorCelula.toString(); // Transforma a celula em String
        }
    }
}
