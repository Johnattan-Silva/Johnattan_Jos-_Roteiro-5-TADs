package tad.conjuntoDinamico;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

    private No<Integer> inicio; 
    private int tamanho;

    public MeuConjuntoDinamicoEncadeado() {
        inicio = null; 
        tamanho = 0; 
    }

    /**
     * Insere um novo elemento no início da lista, desde que o elemento não esteja presente na lista.
     * 
     * @param item O elemento a ser inserido na lista.
     */
    @Override
    public void inserir(Integer item) {
        if (buscar(item) == null) { // Verifica se o elemento já está presente na lista
            No<Integer> novoNo = new No<>(item); 
            novoNo.proximo = inicio; // O próximo do novo nó aponta para o atual início da lista
            inicio = novoNo;  
            tamanho++;  
        }
    }

    /**
     * Remove o primeiro nodo que contém o elemento especificado da lista, se presente.
     * 
     * @param item O elemento a ser removido da lista.
     * @return O elemento removido, se encontrado; caso contrário, retorna null.
     */
    @Override
    public Integer remover(Integer item) {
        No<Integer> anterior = null;
        No<Integer> atual = inicio;

        // Percorre a lista até encontrar o nodo com o elemento especificado
        while (atual != null && !atual.dado.equals(item)) {
            anterior = atual;
            atual = atual.proximo;
        }

        // Se o nodo com o elemento especificado for encontrado
        if (atual != null) {
            // Remove o nodo atual da lista
            if (anterior != null) {
                anterior.proximo = atual.proximo;
            } else {
                inicio = atual.proximo;
            }
            tamanho--;  
            return atual.dado; // Retorna o elemento removido
        } else {
            return null; // Retorna null se o elemento não for encontrado na lista
        }
    }


    @Override
    public Integer predecessor(Integer item) {
        return predecessor(item);
    }

    @Override
    public Integer sucessor(Integer item) {
        return sucessor(item);
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    /**
     * Busca o elemento especificado na lista.
     * 
     * @param item O elemento a ser buscado na lista.
     * @return O elemento buscado, se encontrado; caso contrário, retorna null.
     */
    @Override
    public Integer buscar(Integer item) {
        No<Integer> atual = inicio;

        // Percorre a lista até encontrar o elemento especificado
        while (atual != null) {
            if (atual.dado.equals(item)) {
                return atual.dado; 
            }
            atual = atual.proximo; // Avança para o próximo nodo
        }

        return null; // Retorna null se o elemento não for encontrado na lista
    }


    @Override
    public Integer minimum() {
        return minimum();
    }

    @Override
    public Integer maximum() {
        return maximum();
    }

    /**
     * Classe interna que representa um nó na lista encadeada.
     * @param <T> O tipo de dado armazenado no nó.
     */
    private static class No<T> { 
        T dado; // O dado armazenado no nó
        No<T> proximo; // Referência para o próximo nó

        /**
         * Construtor para criar um novo nó com o dado especificado.
         * @param dado O dado a ser armazenado no nó.
         */
        public No(T dado) {
            this.dado = dado;
            this.proximo = null; // Inicialmente, o próximo nó é nulo
        }
    }

}
