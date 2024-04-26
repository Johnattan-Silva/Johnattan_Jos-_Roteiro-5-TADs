package tad.listasEncadeadas;

import java.lang.reflect.Array;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
	NodoListaEncadeada<T> cabeca = null;  
	NodoListaEncadeada<T> cauda = null; 
	
	public ListaEncadeadaImpl() { 
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
	}
	

	@Override
	public boolean isEmpty() {
		return cabeca.getProximo() == cauda;		
	}

	/**
	 * Retorna o número de elementos na lista duplamente encadeada.
	 * 
	 * Este método calcula e retorna o número de elementos na lista duplamente encadeada.
	 * 
	 * @return O número de elementos na lista duplamente encadeada.
	 */
	@Override
	public int size() {
		int tamanho = 0;
		NodoListaEncadeada<T> atual = cabeca.getProximo();  
		while (atual != cauda) {  
			tamanho++; 
			atual = atual.getProximo();  
		}
		return tamanho;
	}


	/**
	 * Busca um elemento na lista duplamente encadeada.
	 * 
	 * Este método busca um elemento com a chave especificada na lista duplamente encadeada.
	 * 
	 * @param chave A chave do elemento a ser buscado.
	 * @return O nodo da lista que contém a chave especificada, ou null se a chave não for encontrada.
	 */
	@Override
	public NodoListaEncadeada<T> search(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo();  
		while (atual != cauda) {  
			if (atual.getChave().equals(chave)) {  
				return atual; 
			}
			atual = atual.getProximo(); 
		}
		return null;  
	}


	/**
	 * Insere um novo elemento no início da lista duplamente encadeada.
	 * 
	 * Este método insere um novo elemento com a chave especificada no início da lista duplamente encadeada.
	 * 
	 * @param chave A chave do novo elemento a ser inserido.
	 */
	@Override
	public void insert(T chave) {
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
	
		if (cabeca.getProximo().equals(cauda)) {
			cabeca.setProximo(novoNo);
			cauda.setProximo(novoNo);  
		} else {  
			novoNo.setProximo(cabeca.getProximo());
			cabeca.setProximo(novoNo);
		}
	}


	/**
	 * Remove o elemento com a chave especificada da lista duplamente encadeada.
	 * 
	 * Este método remove o primeiro elemento encontrado na lista com a chave especificada.
	 * 
	 * @param chave A chave do elemento a ser removido.
	 * @return O nodo removido, se encontrado; caso contrário, retorna null.
	 */
	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		NodoListaEncadeada<T> anterior = cabeca;  
		NodoListaEncadeada<T> atual = cabeca.getProximo();  

		while (atual != cauda) {
			if (atual.equals(chave)) {  
				anterior.setProximo(atual.getProximo());  
				return atual;  
			}
			anterior = atual;  
			atual = atual.getProximo();  
		}
 
		return null;
	}


	/**
	 * Converte a lista duplamente encadeada em um array do tipo especificado.
	 * 
	 * Este método cria e retorna um array contendo todos os elementos da lista
	 * duplamente encadeada na ordem em que aparecem na lista.
	 * 
	 * @param clazz O tipo da classe do array desejado.
	 * @return Um array contendo os elementos da lista duplamente encadeada.
	 */
	@Override
	public T[] toArray(Class<T> clazz) { 
		int tamanho = size();
 
		@SuppressWarnings("unchecked")
		T[] meuArray = (T[]) Array.newInstance(clazz, tamanho);
 
		NodoListaEncadeada<T> atual = cabeca.getProximo();  
		int indice = 0;
		while (atual != cauda) {
			meuArray[indice] = atual.getChave();  
			atual = atual.getProximo();  
			indice++;
		}

		return meuArray;
	}

	/**
	 * Retorna uma string contendo os elementos da lista duplamente encadeada na ordem em que aparecem.
	 * 
	 * Este método percorre a lista e concatena os valores dos elementos em uma string, separados por vírgula e espaço.
	 * 
	 * @return Uma string contendo os elementos da lista na ordem em que aparecem.
	 */
	@Override
	public String imprimeEmOrdem() {
		String valores = "";  
		NodoListaEncadeada<T> corrente = cabeca.getProximo();  
 
		while (!corrente.equals(cauda)) {
			valores += corrente.getChave() + ", ";  
			corrente = corrente.getProximo();  
		}
 
		return valores.substring(0, valores.length() - 2);
	}

	/**
	 * Retorna uma string contendo os elementos da lista duplamente encadeada na ordem inversa.
	 * 
	 * Este método percorre a lista a partir do último nó e concatena os valores dos elementos em uma string,
	 * separados por vírgula e espaço.
	 * 
	 * @return Uma string contendo os elementos da lista na ordem inversa.
	 */
	@Override
	public String imprimeInverso() {
		StringBuilder valores = new StringBuilder(); 
		NodoListaEncadeada<T> corrente = cauda.getAnterior();  

		while (corrente != cabeca) {
			valores.append(corrente.getChave()).append(", "); 
			corrente = corrente.getAnterior();  
		}
 
		if (valores.length() > 0) {
			valores.delete(valores.length() - 2, valores.length());
		}

		return valores.toString();  
	}

	
	/**
	 * Retorna o sucessor do elemento com a chave especificada.
	 * 
	 * Este método percorre a lista a partir do primeiro nó após a cabeça e verifica se o elemento atual é igual à chave especificada.
	 * Se encontrar o elemento com a chave especificada, retorna o sucessor desse elemento na lista.
	 * 
	 * @param chave A chave do elemento cujo sucessor será buscado.
	 * @return O sucessor do elemento com a chave especificada, ou null se a chave não for encontrada ou se o nó for o último.
	 */
	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo();  
 
		while (atual != cauda) {
			if (atual.getChave().equals(chave)) {  
				return atual.getProximo(); 
			}
			atual = atual.getProximo();  
		}
 
		return null;
	}


	/**
	 * Retorna o predecessor do elemento com a chave especificada.
	 * 
	 * Este método percorre a lista a partir do primeiro nó após a cabeça e verifica se o elemento atual é igual à chave especificada.
	 * Se encontrar o elemento com a chave especificada, retorna o predecessor desse elemento na lista.
	 * 
	 * @param chave A chave do elemento cujo predecessor será buscado.
	 * @return O predecessor do elemento com a chave especificada, ou null se a chave não for encontrada ou se o nó for o último.
	 */
	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo(); 
		NodoListaEncadeada<T> predecessor = cabeca;  
 
		while (atual != cauda) {
			if (atual.getChave().equals(chave)) {  
				return predecessor;  
			}
			predecessor = atual; 
			atual = atual.getProximo();  
		}
 
		return null;
	}


	/**
	 * Insere um novo elemento com a chave especificada em um determinado índice na lista encadeada.
	 * 
	 * Este método insere o novo elemento com a chave especificada em um índice específico da lista encadeada.
	 * Se o índice for menor que zero, uma exceção IllegalArgumentException será lançada.
	 * 
	 * @param chave A chave do elemento a ser inserido.
	 * @param index O índice onde o elemento será inserido na lista.
	 * @throws IllegalArgumentException Se o índice for menor que zero.
	 */
	@Override
	public void insert(T chave, int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Índice inválido: " + index);
		}

		NodoListaEncadeada<T> novoNodo = new NodoListaEncadeada<>(chave);
		NodoListaEncadeada<T> atual = cabeca;
 
		for (int i = 0; i < index && atual.getProximo() != cauda; i++) {
			atual = atual.getProximo();
		}
 
		novoNodo.setProximo(atual.getProximo());
		atual.setProximo(novoNodo);
	}


}
