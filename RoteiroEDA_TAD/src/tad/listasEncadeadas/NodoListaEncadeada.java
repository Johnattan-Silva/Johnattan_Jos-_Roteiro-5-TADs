package tad.listasEncadeadas;

public class NodoListaEncadeada<T extends Comparable<T>> {
	
	protected T chave;
	protected NodoListaEncadeada<T> proximo = null;
	private NodoListaEncadeada<T> anterior = null;

	
	public NodoListaEncadeada() {
		this.setChave(null);
		this.setProximo(null);
	}
	
	public NodoListaEncadeada(T chave) {
		this.setChave(chave);
		this.setProximo(null);
	}
	
	public NodoListaEncadeada(T chave, NodoListaEncadeada<T> proximo) {
		this.setChave(chave);
		this.setProximo(proximo);
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public NodoListaEncadeada<T> getProximo() {
		return proximo;
	}

	public void setProximo(NodoListaEncadeada<T> proximo) {
		this.proximo = proximo;
	}
	
	public boolean isNull() {
		return (chave == null ? true:false);
	}

	/**
	 * Verifica se este nodo é igual a outro objeto.
	 * @param obj O objeto a ser comparado.
	 * @return true se o objeto passado for igual a este nodo, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		// Verifica se o objeto passado é nulo ou se a chave deste nodo é nula
		if (obj == null || this.chave == null) {
			return false;
		}
		
		// Converte o objeto passado para um NodoListaEncadeada
		@SuppressWarnings("unchecked")
		NodoListaEncadeada<T> aComparar = ((NodoListaEncadeada<T>) obj);
		
		// Verifica se a chave e o próximo nodo deste nodo são iguais ao daquele a ser comparado
		if ( (this.chave.compareTo(aComparar.getChave()) == 0) &&
				(this.getProximo().equals(aComparar.getProximo())) ) {
			return true;
		}
		
		return false; // Retorna false se as condições anteriores não forem atendidas
	}


	/**
	 * Retorna uma representação em string deste nodo.
	 * @return Uma string representando a chave deste nodo, ou null se este nodo for nulo.
	 */
	@Override
	public String toString() {
		// Verifica se este nodo não é nulo
		if (!this.isNull()) {
			return this.chave.toString(); // Retorna a representação em string da chave deste nodo
		}
		return null; // Retorna null se este nodo for nulo
	}

	
	public NodoListaEncadeada<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaEncadeada<T> anterior) {
        this.anterior = anterior;
    }

}
