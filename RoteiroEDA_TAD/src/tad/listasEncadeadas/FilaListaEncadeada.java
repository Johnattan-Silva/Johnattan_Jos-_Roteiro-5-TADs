package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
    
    private NodoListaEncadeada<Integer> cabeca; // referencia para o primeiro no da lista

    @Override
    public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
        if (cabeca == null) {
            cabeca = item; // se a lista estiver vazia, o item se torna a cabeca
        } else {
            NodoListaEncadeada<Integer> atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo(); // encontrar o ultimo no da lista
            }
            atual.setProximo(item); // adicionar o item como o proximo do ultimo nodo
        }
    }

    @Override
    public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        NodoListaEncadeada<Integer> removido = cabeca;
        cabeca = cabeca.getProximo(); // atualiza a cabeca para o proximo nodo
        removido.setProximo(null); // remove a referencia ao proximo nodo do que foi removido
        return removido;
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCauda() {
        if (isEmpty()) {
            return null;
        }
        NodoListaEncadeada<Integer> atual = cabeca;
        while (atual.getProximo() != null) {
            atual = atual.getProximo(); // ate encontrar o ultimo nodo
        }
        return atual;
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCabeca() {
        return cabeca;
    }

    @Override
    public boolean isEmpty() {
        return cabeca == null;
    }

    @Override
    public boolean isFull() {
        return false; // n tem limite
    }
}
