package tad.conjuntoDinamico;

import java.util.Arrays;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	private Integer[] meusDados = null;
	private int posInsercao = 0;
	
	/**
	 * Insere o item especificado no final da lista.
	 * 
	 * Este método insere o item especificado no final da lista. Se o array subjacente
	 * estiver cheio, ele será redimensionado para acomodar o novo item.
	 * 
	 * @param item O item a ser inserido na lista.
	 */
	@Override
	public void inserir(Integer item) {
		if (posInsercao == meusDados.length) {
			meusDados = aumentarArray(meusDados);
		}
		meusDados[posInsercao++] = item;
	}

	
	private Integer[] aumentarArray(Integer[] array) { 
		// criar um array maior (arrayMaior)
			// Qual é a taxa de aumento desse array?
		// copiar os dados de meusDados (array cheio)
		// colar os dados para o novo array (arrayMaior)
		int novoTamanho = array.length * 2; // array || meusDados ? 
		Integer[] novoArray = Arrays.copyOf(meusDados, novoTamanho);
		return novoArray;
	}

	/**
	 * Remove a primeira ocorrência do item especificado da lista e o retorna.
	 * 
	 * Este método remove a primeira ocorrência do item especificado da lista e o retorna.
	 * Se o item não estiver presente na lista, retorna null.
	 * 
	 * @param item O item a ser removido da lista.
	 * @return O item removido, ou null se o item não estiver presente na lista.
	 */
	@Override
	public Integer remover(Integer item) {
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				Integer removido = meusDados[i];
				for (int j = i; j < posInsercao - 1; j++) {
					meusDados[j] = meusDados[j + 1];
				}
				meusDados[--posInsercao] = null;
				return removido;
			}
		}
		return null;
	}


	/**
	 * Retorna o predecessor do item especificado na lista.
	 * 
	 * Este método retorna o item que precede o item especificado na lista.
	 * 
	 * @param item O item para o qual se deseja encontrar o predecessor.
	 * @return O predecessor do item especificado ou null se o item não for encontrado ou se não houver predecessor.
	 */
	@Override
	public Integer predecessor(Integer item) {
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				if (i > 0) {
					return meusDados[i - 1];
				} else {
					return null;  
				}
			}
		}
		return null;  
	}


	/**
	 * Retorna o sucessor do item especificado na lista.
	 * 
	 * Este método retorna o item que sucede o item especificado na lista.
	 * 
	 * @param item O item para o qual se deseja encontrar o sucessor.
	 * @return O sucessor do item especificado ou null se o item não for encontrado ou se não houver sucessor.
	 */
	@Override
	public Integer sucessor(Integer item) {
		for (int i = 0; i < posInsercao - 1; i++) {
			if (meusDados[i].equals(item)) {
				return meusDados[i + 1];
			}
		}
		return null;
	}


	@Override
	public int tamanho() {
		return posInsercao;
	}

	/**
	 * Busca um item na lista e retorna o próprio item se encontrado.
	 * 
	 * Este método busca o item especificado na lista e retorna o item se encontrado.
	 * 
	 * @param item O item que está sendo buscado na lista.
	 * @return O item se encontrado na lista, caso contrário retorna null.
	 */
	@Override
	public Integer buscar(Integer item) {
		for (int i = 0; i < meusDados.length; i++) {
			if (meusDados[i].equals(item)) {
				return meusDados[i];
			}
		}
		return null;
	}


	/**
	 * Retorna o menor elemento da lista.
	 * 
	 * Este método retorna o menor elemento presente na lista.
	 * 
	 * @return O menor elemento da lista, ou null se a lista estiver vazia.
	 */
	@Override
	public Integer minimum() {
		if (posInsercao == 0) { // caso
			return null;
		}
		int minimo = meusDados[0];
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] < minimo) {
				minimo = meusDados[i];
			}
		}
		return minimo;
	}


	/**
	 * Retorna o maior elemento da lista.
	 * 
	 * @return O maior elemento presente na lista, ou null se a lista estiver vazia.
	 */
	@Override
	public Integer maximum() {
		if (posInsercao == 0) {
			return null;
		} 

		int maximo = meusDados[0];

		for (int i = 1; i < posInsercao; i++) { // itera e substitui o valor da variável se um maior for encontrado
			if (meusDados[i] > maximo) {
				maximo = meusDados[i];
			}
		}
		return maximo;
	}


}
