package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 **/
public class MinhaFila implements FilaIF<Integer> {
	
	private int tamanho = 10;
	private int cauda = 1;
	private int cabeca = 0;
	private Integer[] meusDados = null;

	public MinhaFila(int tamanhoInicial) {
		this.tamanho = tamanhoInicial;
		this.meusDados = new Integer[tamanho];
	}
	
	public MinhaFila() {
		this.meusDados = new Integer[tamanho];
	}

	/**
	 * Adiciona um elemento ao final da fila.
	 * @param item O elemento a ser enfileirado.
	 * @throws IllegalStateException Se a fila estiver cheia.
	 */
	@Override
	public void enfileirar(Integer item) {
		if (isFull()) { 
			throw new IllegalStateException("Fila cheia!"); // Lança uma exceção se a fila estiver cheia
		}
		meusDados[cauda] = item; // Adiciona o item ao final da fila
		cauda = (cauda + 1) % tamanho; // Atualiza o índice da cauda para o próximo espaço disponível
	}


	/**
	 * Remove e retorna o elemento no início da fila.
	 * @return O elemento removido.
	 * @throws IllegalStateException Se a fila estiver vazia.
	 */
	@Override
	public Integer desenfileirar() {
		if (isEmpty()) { 
			throw new IllegalStateException("Fila vazia!"); // Lança uma exceção se a fila estiver vazia
		}
		Integer item = meusDados[cabeca]; // Obtém o item no início da fila
		meusDados[cabeca] = null; // Remove o item definindo o valor do índice da cabeça como nulo
		cabeca = (cabeca + 1) % tamanho; // Atualiza o índice da cabeça para o próximo item na fila
		return item; // Retorna o item removido
	}


	/**
	 * Retorna o elemento na cauda da fila, ou seja, o último elemento inserido.
	 * @return O elemento na cauda da fila.
	 * @throws IllegalStateException Se a fila estiver vazia.
	 */
	@Override
	public Integer verificarCauda() {
		if (isEmpty()) { 
			throw new IllegalStateException("Fila vazia"); // Lança uma exceção se a fila estiver vazia
		}
		return meusDados[(cauda - 1 + tamanho) % tamanho]; // Retorna o último elemento inserido na fila
	}


	/**
	 * Retorna o elemento na cabeça da fila, ou seja, o primeiro elemento inserido.
	 * @return O elemento na cabeça da fila.
	 * @throws IllegalStateException Se a fila estiver vazia.
	 */
	@Override
	public Integer verificarCabeca() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia"); // Lança uma exceção se a fila estiver vazia
		}
		return meusDados[cabeca]; // Retorna o primeiro elemento inserido na fila
	}


	/**
	 * Verifica se a fila está vazia.
	 * @return true se a fila estiver vazia, false caso contrário.
	 */
	@Override
	public boolean isEmpty() {
		// Retorna true se a diferença entre cauda e cabeça for igual a zero
		return (cauda - cabeca + tamanho) % tamanho == 0; 
	}


	/**
	 * Verifica se a fila está cheia.
	 * @return true se a fila estiver cheia, false caso contrário.
	 */
	@Override
	public boolean isFull() {
		// Retorna true se a diferença entre cauda e cabeça for igual a tamanho - 1
		return (cauda - cabeca + tamanho) % tamanho == tamanho - 1; 
	}


}
