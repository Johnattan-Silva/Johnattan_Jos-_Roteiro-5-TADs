package tad.conjuntoDinamico;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

    private No<Integer> inicio; 
    private int tamanho;

    public MeuConjuntoDinamicoEncadeado() {
        inicio = null; 
        tamanho = 0; 
    }

    @Override
    public void inserir(Integer item) {
        if (buscar(item) != null) { 
            No<Integer> novoNo = new No<>(item); 
            novoNo.proximo = inicio; 
			inicio = novoNo;
            tamanho++; 
        }
    }

    @Override
    public Integer remover(Integer item) {
        No<Integer> anterior = null;
        No<Integer> atual = inicio;

        while (atual != null && !atual.dado.equals(item)) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual != null) {
            if (anterior != null) {
                anterior.proximo = atual.proximo;
            } else {
                inicio = atual.proximo;
            }
            tamanho--;
            return atual.dado; // encontrado
        } else {
            return null; // nao encontrado
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

    @Override
    public Integer buscar(Integer item) {
        No<Integer> atual = inicio;

        while (atual != null) {
            if (atual.dado.equals(item)) {
                return atual.dado; // encontrado
            }
            atual = atual.proximo;
        }

        return null; // nao encontrado
    }

    @Override
    public Integer minimum() {
        return minimum();
    }

    @Override
    public Integer maximum() {
        return maximum();
    }

    private static class No<T> { // representa o No
        T dado;
        No<T> proximo;

        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }
}
