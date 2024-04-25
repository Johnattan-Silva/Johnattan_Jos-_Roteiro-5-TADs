package tad.listasEncadeadas;

import java.util.Arrays;
import java.lang.reflect.Array;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {
	
	//TODO: implementar o nó cabeça
	//TODO: implementar o nó cauda 
	//TODO: implementar as sentinelas
	
	NodoListaDuplamenteEncadeada<T> cabeca = null;  
	NodoListaDuplamenteEncadeada<T> cauda = null; 
	
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


	@Override
	public T[] toArray(Class<T> clazz) {
		T[] array = (T[]) Array.newInstance(clazz, 0);
	
		NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
		int indice = 0;
	
		array = Arrays.copyOf(array, size());
	
		while (atual != cauda) {
			array[indice] = atual.getChave();
			atual = atual.getProximo();
			indice++;
		}

		return array;
	}

	@Override
	public void inserePrimeiro(T elemento) { 
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<>(elemento);
		 
		novoNo.setProximo(cabeca.getProximo());
		novoNo.setAnterior(cabeca);
		 
		cabeca.getProximo().setAnterior(novoNo);
		cabeca.setProximo(novoNo);
	}


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
