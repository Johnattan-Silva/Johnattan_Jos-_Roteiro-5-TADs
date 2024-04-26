package tad.listasEncadeadas;

import java.lang.reflect.Array;

/**
 * Implementação de uma lista duplamente encadeada.
 * Esta classe representa uma lista duplamente encadeada que armazena elementos do tipo genérico T,
 * onde T deve implementar a interface Comparable para permitir a comparação entre elementos.
 * Cada nó da lista contém uma referência para o próximo nó e para o nó anterior, permitindo a
 * travessia tanto para frente quanto para trás na lista.
 * 
 * <p>O objetivo desta classe é fornecer uma implementação eficiente de uma lista duplamente encadeada
 * em Java, com suporte a operações como inserção, remoção, busca e conversão para array.</p>
 * 
 * @param <T> O tipo de elemento armazenado na lista, que deve implementar a interface Comparable.
 */
public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {
	
	//TODO: implementar o nó cabeça
	//TODO: implementar o nó cauda 
	//TODO: implementar as sentinelas
	
	NodoListaDuplamenteEncadeada<T> cabeca = null;  
	NodoListaDuplamenteEncadeada<T> cauda = null; 
	
	/**
	 * Construtor padrão da lista duplamente encadeada.
	 * Inicializa a lista com os nós cabeça e cauda, e configura as sentinelas.
	 */
	public ListaDuplamenteEncadeadaImpl() { 
		cabeca = new NodoListaDuplamenteEncadeada<T>();   
		cauda = new NodoListaDuplamenteEncadeada<T>();   
		 
		cabeca.setProximo(cauda);   
		cabeca.setAnterior(cauda); 
		cauda.setAnterior(cabeca); 
		cauda.setProximo(cabeca);  
	}


	@Override
	public boolean isEmpty() {
		return cabeca.getProximo() == cauda;
	}

	/**
	 * Retorna o número de elementos na lista.
	 * 
	 * @return O número de elementos na lista.
	 */
	@Override
	public int size() {
		int count = 0;  
		NodoListaDuplamenteEncadeada<T> atual = cabeca;   

		while (atual != cauda) {  
			count++;   
			atual = cauda.getAnterior();  
		}

		return count;
	}


	/**
	 * Busca um elemento na lista.
	 * 
	 * @param chave O elemento a ser buscado na lista.
	 * @return O nó que contém o elemento buscado, ou null se não encontrado.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> search(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior();  

		while (atual != cabeca) {  
			if (atual.getChave().equals(chave)) {  
				return atual;   
			}
			atual = atual.getAnterior();   
		}

		return null;   
	}


	/**
	 * Insere um elemento na lista.
	 * 
	 * @param chave O elemento a ser inserido na lista.
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
	 * Remove um elemento da lista com a chave especificada.
	 * 
	 * Este método percorre a lista encadeada a partir do nó cabeça até o nó cauda,
	 * procurando pelo elemento com a chave especificada. Se o elemento for encontrado,
	 * ele é removido da lista e o nó anterior é ligado ao próximo nó, excluindo o nó
	 * atual da lista.
	 * 
	 * @param chave A chave do elemento a ser removido.
	 * @return O nó que foi removido da lista, ou null se o elemento não for encontrado.
	 */
	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		NodoListaEncadeada<T> anterior = cabeca;   
		NodoListaEncadeada<T> atual = cabeca.getProximo();   

		while (atual != cauda) {   
			if (atual.getChave().equals(chave)) {   
				anterior.setProximo(atual.getProximo());   
				return atual;   
			}
			anterior = atual;   
			atual = atual.getProximo();   
		}

		return null;   
	}



	/**
	 * Retorna uma representação em String dos elementos da lista na ordem em que foram inseridos.
	 * 
	 * Este método percorre a lista encadeada a partir do nó cabeça até o nó cauda,
	 * concatenando as chaves dos elementos em uma string separadas por espaço.
	 * 
	 * @return Uma representação em String dos elementos da lista na ordem em que foram inseridos.
	 */
	@Override
	public String imprimeEmOrdem() {
		StringBuilder builder = new StringBuilder(); 
		NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo(); 

		while (atual != cauda) { 
			builder.append(atual.getChave()).append(" "); 
			atual = atual.getProximo(); 
		}

		return builder.toString().trim(); 
	}	



	/**
	 * Retorna uma representação em String dos elementos da lista na ordem inversa à inserção.
	 * 
	 * Este método percorre a lista encadeada a partir do nó cauda até o nó cabeça,
	 * concatenando as chaves dos elementos em uma string separadas por espaço.
	 * 
	 * @return Uma representação em String dos elementos da lista na ordem inversa à inserção.
	 */
	@Override
	public String imprimeInverso() {
		StringBuilder builder = new StringBuilder(); 
		NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior(); 

		while (atual != cabeca) {   
			builder.append(atual.getChave()).append(" "); 
			atual = atual.getAnterior(); 
		}

		return builder.toString().trim(); 
	}



	/**
	 * Retorna o sucessor do elemento com a chave especificada.
	 * 
	 * Este método percorre a lista encadeada a partir do primeiro nó após o nó cabeça,
	 * comparando as chaves dos elementos com a chave especificada. Se encontrar um elemento
	 * com a chave especificada, retorna o próximo elemento na lista, que é o seu sucessor.
	 * Se não encontrar um elemento com a chave especificada, retorna null.
	 * 
	 * @param chave A chave do elemento cujo sucessor será retornado.
	 * @return O sucessor do elemento com a chave especificada, ou null se não for encontrado.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> sucessor(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo(); 

		while (atual != cauda) { 
			if (atual.getChave().equals(chave)) { 
				return atual.getProximo();   
			}
			atual = atual.getProximo(); 
		}

		return null; 
	}

	

	/**
	 * Retorna o antecessor do elemento com a chave especificada.
	 * 
	 * Este método percorre a lista encadeada a partir do último nó antes do nó cauda,
	 * comparando as chaves dos elementos com a chave especificada. Se encontrar um elemento
	 * com a chave especificada, retorna o nó anterior na lista, que é o seu antecessor.
	 * Se não encontrar um elemento com a chave especificada, retorna null.
	 * 
	 * @param chave A chave do elemento cujo antecessor será retornado.
	 * @return O antecessor do elemento com a chave especificada, ou null se não for encontrado.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> predecessor(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = cauda; 

		while (atual != cabeca) { 
			if (atual.getChave().equals(chave)) {   
				return atual.getAnterior(); 
			}
			atual = atual.getAnterior(); 
		}

		return null; 
	}


	/**
	 * Converte os elementos da lista duplamente encadeada para um array do tipo especificado.
	 * 
	 * Este método cria um novo array do tipo especificado com o tamanho igual ao tamanho da lista.
	 * Em seguida, percorre a lista encadeada, atribuindo os elementos aos índices correspondentes do array.
	 * Retorna o array preenchido com os elementos da lista.
	 * 
	 * @param clazz A classe do tipo dos elementos do array.
	 * @return Um array contendo os elementos da lista duplamente encadeada.
	 */
	@Override
	public T[] toArray(Class<T> clazz) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(clazz, size());   

		NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();   
		int indice = 0; 

		while (atual != cauda) { 
			array[indice] = atual.getChave(); 
			atual = atual.getProximo();   
			indice++;  
		}

		return array;  
	}


	/**
	 * Insere um elemento no início da lista duplamente encadeada.
	 * 
	 * Este método cria um novo nó com o elemento especificado e o insere antes do primeiro nó atual na lista.
	 * O novo nó se torna o primeiro nó da lista e o antigo primeiro nó se torna o segundo nó.
	 * 
	 * @param elemento O elemento a ser inserido no início da lista.
	 */
	@Override
	public void inserePrimeiro(T elemento) {
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<>(elemento); 

		novoNo.setProximo(cabeca.getProximo());   
		novoNo.setAnterior(cabeca); 

		cabeca.getProximo().setAnterior(novoNo);   
		cabeca.setProximo(novoNo);   
	}



	/**
	 * Remove o último elemento da lista duplamente encadeada.
	 * 
	 * Este método remove o último nó da lista e o retorna. Se a lista estiver vazia, retorna null.
	 * 
	 * @return O último nó da lista, ou null se a lista estiver vazia.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> removeUltimo() { 
		if (isEmpty()) {
			return null; 
		}
		
		NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior(); 
		NodoListaDuplamenteEncadeada<T> penultimo = atual.getAnterior(); 
		
		penultimo.setProximo(cauda);   
		cauda.setAnterior(penultimo);   
		
		atual.setProximo(null); 
		atual.setAnterior(null);   
		
		return atual; 
	}



	/**
	 * Remove o primeiro elemento da lista duplamente encadeada.
	 * 
	 * Este método remove o primeiro nó da lista e o retorna. Se a lista estiver vazia, retorna null.
	 * 
	 * @return O primeiro nó da lista, ou null se a lista estiver vazia.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> removePrimeiro() { 
		if (isEmpty()) {
			return null;  
		}
		
		NodoListaDuplamenteEncadeada<T> primeiro = cabeca.getProximo();   
		
		cabeca.setProximo(primeiro.getProximo()); 
		primeiro.getProximo().setAnterior(cabeca);  
		
		primeiro.setProximo(null);   
		primeiro.setAnterior(null);   
		
		return primeiro;   
	}



	/**
	 * Insere um novo elemento na lista duplamente encadeada na posição especificada pelo índice.
	 * 
	 * Este método insere um novo nó com a chave especificada na posição indicada pelo índice na lista.
	 * Se o índice for menor que zero ou maior que o tamanho da lista, uma exceção IndexOutOfBoundsException será lançada.
	 * 
	 * @param chave A chave do novo elemento a ser inserido na lista.
	 * @param index O índice onde o novo elemento será inserido na lista.
	 * @throws IndexOutOfBoundsException Se o índice for menor que zero ou maior que o tamanho da lista.
	 */
	@Override
	public void insert(T chave, int index) { 
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Índice inválido: " + index);
		} 

		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<>(chave);
		
		NodoListaDuplamenteEncadeada<T> atual = cabeca;
		for (int i = 0; i < index; i++) {
			atual = atual.getProximo();
		}
		
		novoNo.setProximo(atual.getProximo());
		novoNo.setAnterior(atual);
		
		atual.getProximo().setAnterior(novoNo);
		atual.setProximo(novoNo);    
	}
}
