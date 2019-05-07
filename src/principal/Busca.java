/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mark_
 */
public abstract class Busca {
  
	protected Estado estadoInicial;
	protected Estado estadoFinal;

	protected List<Estado> listaAberta; // arm todos estados gerados pela lista fechada
	protected Collection<Estado> listaFechada; // arm todos estados que foram analisados pela busca e fecha

        
	public Busca(Estado estadoInicial, Estado estadoFinal) {
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
	}

	public Estado getEstadoFinal() {
		return estadoFinal;
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public Estado executar() {
		listaAberta = new LinkedList<Estado>();
		listaFechada = new HashSet<Estado>();

		// Inserir o estado inicial na lista aberta
		adicionarEstadosListaAberta(listaAberta, estadoInicial);

		while (true) {
                    
			if (listaAberta.isEmpty()) {
                            System.out.println("CAI AQUI LISTA VAZIA");
				return null; // ERRO
			}
			Estado e = escolherProximoEstado(listaAberta); // ELEMENTO DA LISTA ABERTA PARA FECHADA
			listaFechada.add(e);

			if (e.equals(estadoFinal)) {
				return e; //SUCESSO
			}

			// FAZ MEUS MOVIMENTOS 
			Collection<Estado> novosEstados = e.movimento();

                        //sem estados gerados
			if (novosEstados.isEmpty()) {
				continue;
			}
                        //gerado um estado novo se tive igual a um que tenho dentro da lista fechada remove
			novosEstados.removeAll(listaFechada); // PARA NAO FICAR COM ESTADOS REPETIDOS 

			// Incluir estados gerados na lista aberta
			adicionarEstadosListaAberta(listaAberta, novosEstados); //outra classe faz 
		}
	}

	protected abstract void adicionarEstadosListaAberta(List<Estado> listaAberta, Collection<Estado> estados);

	private void adicionarEstadosListaAberta(List<Estado> listaAberta, Estado estado) {
		Collection<Estado> temp = new ArrayList<Estado>();
		temp.add(estado);
		adicionarEstadosListaAberta(listaAberta, temp);
	}

	private Estado escolherProximoEstado(List<Estado> listaAberta) {
		// Remover e retornar o primeiro elemento da lista aberta
		return listaAberta.remove(0);
	}

	public List<Estado> getListaAberta() {
		return listaAberta;
	}

	public Collection<Estado> getListaFechada() {
		return listaFechada;
	}
}
