package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {
	
	private int tamanho = 10;
	private Integer[] meusDados = null;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public MinhaPilha() {
	}

	@Override
	public void empilhar(Integer item) {
		if (meusDados == null) {
			meusDados = new Integer[tamanho];
		}
		if (tamanho == meusDados.length) {
			redimensionar();
		}
		meusDados[tamanho++] = item;
	}


	@Override
	public Integer desempilhar() {
		return meusDados[--tamanho];
	}


	@Override
	public Integer topo() {
		return meusDados[tamanho - 1];
	}


	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (isEmpty()) {
			throw new IllegalArgumentException("A pilha está vazia");
		}
		if (k <= 0 || k > tamanho) {
			throw new IllegalArgumentException("O valor de k é inválido");
		}
		PilhaIF<Integer> multiTopPilha = new MinhaPilha(k);
		for (int i = 0; i < k; i++) {
			empilhar(meusDados[tamanho - k + i]);
		}
		return multiTopPilha;
	}


	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}

	public void redimensionar() {
		int novoTamanho = tamanho * 2;
		Integer[] novoArray = new Integer[novoTamanho]; 
	
		for (int i = 0; i < tamanho; i++) {
			novoArray[i] = meusDados[i];
		}
	
		meusDados = novoArray; 
		tamanho = novoTamanho;
	}
	

}
