/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mark_
 */
public class RealizaJogo implements EstadoHeuristicaFG {

    private Integer[] vetor; //MATRIZ ESTADO ATUAL

    private RealizaJogo pai; // ARMAZENA MEU ESTADO PAI 

    private int funcaoG; //FUNCAO G DO MEU ESTADO 

    private int funcaoH; // FUNCAO H DESTE ESTADO 

    // POSICOES AONDE ENCONTRO MINHA MATRIZ VAZIA
    private int lugarVazio;

    public RealizaJogo(RealizaJogo pai) {

        this(pai, MexeVetor.geraEstadoInicialAleatorio());

    }

    public RealizaJogo(RealizaJogo pai, Integer[] vet) {
        this.pai = pai;
        this.vetor = vet;
        if (pai != null) {
            funcaoG = pai.getFuncaoG() + 1;
        }

        lugarVazio = -1;
        funcaoH = -1;
    }

    @Override
    public Collection<Estado> movimento() {

        if ((lugarVazio == -1)) {
            lugarVazio = procurarVazio(); // VE AONDE ESTA MEU ESPACO VAZIO PARA PODER FAZER O MOVIMENTO
        }

        // LISTA COM OS VALORES ENCONTRADOS 
        Collection<Estado> resultado = new ArrayList<Estado>();

        Random rand = new Random();
        int a = rand.nextInt(10) + 1;
        if (lugarVazio <= 10 && lugarVazio > 0) {
            Integer[] copia = vetor.clone();
            copia[lugarVazio - 1] = 0;
            copia[lugarVazio] = vetor[lugarVazio - 1];
            resultado.add(new RealizaJogo(this, copia));
        }
        if (lugarVazio >= 0 && lugarVazio < 10) {
            Integer[] copia = vetor.clone();
            copia[lugarVazio + 1] = 0;
            copia[lugarVazio] = vetor[lugarVazio + 1];
            resultado.add(new RealizaJogo(this, copia));
        }

        if (lugarVazio <= 8) {
            Integer[] copia = vetor.clone();
            copia[lugarVazio + 2] = 0;
            copia[lugarVazio] = vetor[lugarVazio + 2];
            resultado.add(new RealizaJogo(this, copia));
        }

        if (lugarVazio >= 2) {
            Integer[] copia = vetor.clone();
            copia[lugarVazio - 2] = 0;
            copia[lugarVazio] = vetor[lugarVazio - 2];
            resultado.add(new RealizaJogo(this, copia));
        }

        // Retornar resultado
        return resultado;
    }

    @Override
    public String toString() {
        return MexeVetor.print(vetor);
    }

    @Override
    public int hashCode() {
        final int prime = 1000;
        int result = 1;

        result = vetor.length * prime;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof RealizaJogo)) {
            return false;
        }

        RealizaJogo other = (RealizaJogo) obj;

        if (!MexeVetor.equals(vetor, other.vetor)) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Estado o) {
        if (!(o instanceof RealizaJogo)) {
            return 1;
        }

        RealizaJogo other = (RealizaJogo) o;

        return getFuncaoF() - other.getFuncaoF();
    }

    public int procurarVazio() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == 0) { // Celula encontrada
                // System.out.println("ACHEI VAZIO AQUI " + i);
                lugarVazio = i; // Armazenar posicao do meu vetor vazio

            }
        }
        return lugarVazio;
    }

    public Integer[] getVetor() {
        return vetor;
    }

    public int getLugarVazio() { // valor do atributo posLinhaVazio
        if (lugarVazio == -1) {
            procurarVazio();
        }
        return lugarVazio;
    }

    public RealizaJogo getPai() { // valor do atributo pai 
        return pai;
    }

    public int getFuncaoG() {
        return funcaoG;
    }

    public int getFuncaoH() {
        return funcaoH;
    }

    @Override
    public int getFuncaoF() {
        return funcaoH + funcaoG;
    }

    public void setFuncaoG(int funcaoG) {
        this.funcaoG = funcaoG;
    }

    public void setFuncaoH(int funcaoH) { // novo valor para funcao de H 
        this.funcaoH = funcaoH;
    }

}
