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

	@Override
	public void enfileirar(Integer item) {
		if(isFull()){ // esse metodo sozinho funciona?
			throw new IllegalStateException("Fila cheia!");
		}
		meusDados[cauda] = item;
		cauda = (cauda + 1) % tamanho;
	}

	@Override
	public Integer desenfileirar() {
		if(isEmpty()){
			throw new IllegalStateException("Fila vazia!");
		}
		Integer item = meusDados[cabeca];
		meusDados[cabeca] = null;
		cabeca = (cabeca + 1) % tamanho;
		return item;
	}

	@Override
	public Integer verificarCauda() {
		if(isEmpty()){
			throw new IllegalStateException("Fila vazia");
		}
		return meusDados[(cauda - 1 + tamanho) % tamanho]; // ultimo elemento inserido
	}

	@Override
	public Integer verificarCabeca() {
		if(isEmpty()){
			throw new IllegalStateException("Fila vazia");
		}
		return meusDados[cabeca]; // primeiro elemento inserido	
	}

	@Override
	public boolean isEmpty() {
		return (cauda - cabeca + tamanho) % tamanho == 0;
	}

	@Override
	public boolean isFull() {
		return (cauda - cabeca + tamanho) % tamanho == tamanho - 1;
	}

}
