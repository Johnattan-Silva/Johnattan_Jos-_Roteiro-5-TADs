package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

/**
 * Implementação de uma fila utilizando uma lista encadeada.
 * Esta classe representa uma fila que utiliza uma lista encadeada para armazenar seus elementos.
 * Ela suporta operações de enfileirar, desenfileirar e verificar a cabeça e a cauda da fila.
 * A fila é composta por nós que contêm elementos inteiros e possuem referências para o próximo nó na fila.
 * 
 * <p>O objetivo desta classe é fornecer uma implementação eficiente de uma fila em Java, utilizando uma lista encadeada.</p>
 */
public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
    
    private NodoListaEncadeada<Integer> cabeca;

    /**
     * Adiciona um item à fila.
     * 
     * @param item O nó a ser enfileirado na fila.
     * @throws FilaCheiaException Se a fila estiver cheia e não for possível enfileirar o item.
     */
    @Override
    public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
        if (cabeca == null) {
            cabeca = item; // Se a lista estiver vazia, o ítem se torna a cabeça
        } else {
            NodoListaEncadeada<Integer> atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo(); // Encontrar o último nó da lista
            }
            atual.setProximo(item); // Adicionar o ítem como o proximo do ultimo nodo
        }
    }

    /**
     * Remove e retorna o primeiro item da fila.
     * 
     * @return O nó removido da fila.
     * @throws FilaVaziaException Se a fila estiver vazia e não houver itens para desenfileirar.
     */
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

    /**
     * Retorna o último item da fila (cauda).
     * 
     * @return O nó que representa a cauda da fila.
     */
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

    /**
     * Verifica se a fila está cheia.
     * 
     * @return false, pois uma fila implementada com lista encadeada não tem limite de capacidade.
     */
    @Override
    public boolean isFull() {
        return false;
    }
}
