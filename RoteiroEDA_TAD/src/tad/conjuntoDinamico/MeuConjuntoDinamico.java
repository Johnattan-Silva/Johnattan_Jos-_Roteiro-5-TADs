package tad.conjuntoDinamico;

import java.util.Arrays;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	private Integer[] meusDados = null;
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) {
		if (posInsercao == meusDados.length) {
            meusDados = aumentarArray(meusDados);
        }
        meusDados[posInsercao++] = item;
		// throw new UnsupportedOperationException("Implementar");
		
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

	@Override
	public Integer remover(Integer item) {
		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i].equals(item)){
				Integer removido = meusDados[i];
				for(int j = 0; j < posInsercao; j++){
					meusDados[j] = meusDados[j + 1];
				}
				meusDados[--posInsercao] = null;
				return removido;
			}
		}
		// throw new UnsupportedOperationException("Implementar");
		return null;
	}

	@Override
	public Integer predecessor(Integer item) {
		for(int i = 0; i < posInsercao; i++){
			if (meusDados[i].equals(item)) {
                if (i > 0) {
                    return meusDados[i - 1];
                } else {
                    return null; // caso nao haja predecessor
                }
            }
		}
		return null; // caso o item nao seja encontrado
	}

	@Override
	public Integer sucessor(Integer item) {
		for(int i = 0; i < posInsercao - 1; i++){
			if(meusDados[i].equals(item)) return meusDados[i+1];
		}
		return null;
	}

	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) {
		for(int i = 0; i < meusDados.length; i++){
			if(meusDados[i].equals(item)){
				return meusDados[i];
			}
		}
		return null;
	}

	@Override
	public Integer minimum() {
		if(posInsercao == 0){
			return null;
		}
		int minimo = meusDados[0];
		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i] < minimo){
				minimo = meusDados[i];
			}
		}
		return minimo;
	}

	@Override
	public Integer maximum() {
		if(posInsercao == 0){
			return null;
		}
		int maximo = meusDados[0];
		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i] > maximo){
				maximo = meusDados[i];
			}
		}
		return maximo;
	}

}
