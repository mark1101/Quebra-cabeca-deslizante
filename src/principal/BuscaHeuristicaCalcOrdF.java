/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mark_
 */
public abstract class BuscaHeuristicaCalcOrdF extends Busca {
  
         
	public BuscaHeuristicaCalcOrdF(EstadoHeuristicaFG estadoInicial, EstadoHeuristicaFG estadoFinal) {
		super(estadoInicial, estadoFinal);
	}

	protected abstract int funcaoH(Estado estado);

	@Override
	protected void adicionarEstadosListaAberta(List<Estado> listaAberta, Collection<Estado> estados) {
		
                //todos meus estados ou valores do vetor, ficam com seu valor de H calculado
		for (Estado estado : estados) { 
			RealizaJogo jogo = (RealizaJogo) estado; //objeto do tipo jogo 
			int funcaoH = funcaoH(jogo); // valor de funcaoH recebe os valores do calc de H de cada obj
			jogo.setFuncaoH(funcaoH);  //seta o valor de H para todo obj 
		}
                
		listaAberta.addAll(estados);
		Collections.sort(listaAberta); // ordenar lista
	}
    
}
