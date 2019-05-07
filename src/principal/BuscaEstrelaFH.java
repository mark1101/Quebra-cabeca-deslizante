/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author mark_
 */
public class BuscaEstrelaFH extends BuscaHeuristicaCalcOrdF {

    //tenho que achar meu objeto(estado) com menor heuristica para meu movimento
    public BuscaEstrelaFH(RealizaJogo estadoInicial, RealizaJogo estadoFinal) {
        super(estadoInicial, estadoFinal);
    }

    public int funcaoH(Estado estado) {
        
        RealizaJogo RealizaF = (RealizaJogo) getEstadoFinal();
        RealizaJogo play = (RealizaJogo) estado;

        Integer[] vetorAtual = play.getVetor();
        Integer[] vetorFinal = RealizaF.getVetor();

        int tamHeuristica = 0;

        // ENCONTRA POSICOES DIFERENTES SE TIVER
        for (int i = 0; i < vetorAtual.length; i++) {
            /*faz como se fosse uma heuristica de geral assim, pra saber qual dos meus estados
                                pode ser o melhor a ser escolhido*/
            if (!comparar(vetorAtual[i], vetorFinal[i])) {
                tamHeuristica++;
            }
        }

        return tamHeuristica;
    }

    private boolean comparar(Integer m1, Integer m2) {
        if (m1 == null) {
            if (m2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (m2 == null) {
                return false;
            } else {
                return m1.equals(m2);
            }
        }
    }

    @Override
    public String toString() {
        return "Buscas na aplicação de quebra-cabeça deslizante";
    }

}
