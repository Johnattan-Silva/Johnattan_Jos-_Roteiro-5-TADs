package tad.listasEncadeadas;

import java.lang.reflect.Array;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
	NodoListaEncadeada<T> cabeca = null; // Estratégia usando marcação sentinela
	NodoListaEncadeada<T> cauda = null;// Estratégia usando marcação sentinela
	
	public ListaEncadeadaImpl() {// Estratégia usando marcação sentinela
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
	}
	

	@Override
	public boolean isEmpty() {
		return cabeca.getProximo() == cauda;		
	}

	@Override
	public int size() {
		int tamanho = 0;
		NodoListaEncadeada<T> atual = cabeca.getProximo(); // começando do nodo apos a 'beca sentinela'
		while (atual != cauda) { // ate chegar na cauda
			tamanho++; 
			atual = atual.getProximo(); // indo de nodo em nodo
		}
		return tamanho;
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
    	NodoListaEncadeada<T> atual = cabeca.getProximo(); // Começamos do nodo após a cabeça sentinela
		while (atual != cauda) { // Enquanto não chegarmos à cauda
			if (atual.getChave().equals(chave)) { // Verifica se o elemento atual é igual à chave
				return atual; // Retorna o nodo se encontrarmos a chave
			}
			atual = atual.getProximo(); // Avançamos para o próximo nodo
		}
    	return null; // Retorna null se não encontrarmos a chave na lista
	}

	@Override
	public void insert(T chave) {
		 NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		 // Se a lista estiver vazia
		 if (cabeca.getProximo().equals(cauda)) {
			 cabeca.setProximo(novoNo);
			 cauda.setProximo(novoNo); // Atualiza a cauda para o novo nó
		 } else { // Lista não está vazia
			 novoNo.setProximo(cabeca.getProximo());
			 cabeca.setProximo(novoNo);
		 }
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		NodoListaEncadeada<T> anterior = cabeca; // Nodo anterior ao atual
		NodoListaEncadeada<T> atual = cabeca.getProximo(); // Começamos do primeiro nodo após a cabeça

		// Percorre a lista até encontrar o nodo com a chave especificada
		while (atual != cauda) {
			if (atual.equals(chave)) { // Verifica se o elemento atual é igual à chave
				anterior.setProximo(atual.getProximo()); // Remove o nodo atual, ligando o anterior ao próximo
				return atual; // Retorna o nodo removido
			}
			anterior = atual; // Atualiza o nodo anterior
			atual = atual.getProximo(); // Avança para o próximo nodo
		}

		// Se a chave não for encontrada, retorna null
		return null;
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// Determinar o tamanho da lista encadeada
		int tamanho = size();

		// Criar um array do tipo desejado com o tamanho determinado
		@SuppressWarnings("unchecked") // 
		T[] meuArray = (T[]) Array.newInstance(clazz, tamanho);

		// Percorrer a lista encadeada e adicionar cada elemento ao array
		NodoListaEncadeada<T> atual = cabeca.getProximo(); // Começamos a partir do primeiro nó após a cabeça
		int indice = 0;
		while (atual != cauda) {
			meuArray[indice] = atual.getChave(); // Adiciona o elemento atual ao array
			atual = atual.getProximo(); // Avança para o próximo nó
			indice++;
		}

		return meuArray;
	}


	@Override
	public String imprimeEmOrdem() {
//		throw new UnsupportedOperationException("Precisa implementar!");
		String valores = "";
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		
		while (!corrente.equals(cauda)) {
			valores += corrente.getChave() + ", ";
		}
		
		return valores.substring(0, valores.length()-2);
		
	}

	@Override
	public String imprimeInverso() {
		StringBuilder valores = new StringBuilder();
		NodoListaEncadeada<T> corrente = cauda.getAnterior(); // Começamos do último nodo antes da cauda
	
		while (corrente != cabeca) {
			valores.append(corrente.getChave()).append(", "); // Adiciona o elemento ao StringBuilder
			corrente = corrente.getAnterior(); // Avança para o nodo anterior
		}
	
		if (valores.length() > 0) {
			// Remove a última vírgula e o espaço
			valores.delete(valores.length() - 2, valores.length());
		}
	
		return valores.toString();
	}
	
	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo(); // Começamos do primeiro nodo após a cabeça

		// Percorre a lista até encontrar o nodo com a chave especificada
		while (atual != cauda) {
			if (atual.getChave().equals(chave)) { // Verifica se o elemento atual é igual à chave
				return atual.getProximo(); // Retorna o sucessor do nodo atual
			}
			atual = atual.getProximo(); // Avança para o próximo nodo
		}

		// Se a chave não for encontrada ou se o nó for o último, retorna null
		return null;
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo(); // Começamos do primeiro nodo após a cabeça
		NodoListaEncadeada<T> predecessor = cabeca; // Inicializamos o predecessor com a cabeça

		// Percorre a lista até encontrar o nodo com a chave especificada
		while (atual != cauda) {
			if (atual.getChave().equals(chave)) { // Verifica se o elemento atual é igual à chave
				return predecessor; // Retorna o predecessor do nodo atual
			}
			predecessor = atual; // Atualiza o predecessor para o nodo atual
			atual = atual.getProximo(); // Avança para o próximo nodo
		}

		// Se a chave não for encontrada ou se o nó for o último, retorna null
		return null;
	}

	@Override
	public void insert(T chave, int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Índice inválido: " + index);
		}

		NodoListaEncadeada<T> novoNodo = new NodoListaEncadeada<>(chave);
		NodoListaEncadeada<T> atual = cabeca;

		// itera sobre a lista ate o indice ou ate o final
		for (int i = 0; i < index && atual.getProximo() != cauda; i++) {
			atual = atual.getProximo();
		}

		// Insere o novo nodo após o nodo atual
		novoNodo.setProximo(atual.getProximo());
		atual.setProximo(novoNodo);
	}

}
