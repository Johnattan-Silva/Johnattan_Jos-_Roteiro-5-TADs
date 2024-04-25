package tad.pilha;

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {
    
	// nao consegui lidar com esse erro :(
    private ListaEncadeadaIF<Integer> listaEncadeada = new MinhaListaEncadeada<Integer>();

    @Override
    public void empilhar(Integer item) throws PilhaCheiaException {
        listaEncadeada.inserir(item);
    }

    @Override
    public Integer desempilhar() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia. Não é possível desempilhar.");
        }
        return listaEncadeada.removerUltimo();
    }

    @Override
    public Integer topo() {
        return listaEncadeada.getUltimo().getElemento();
    }

    @Override
    public PilhaIF<Integer> multitop(int k) {
        PilhaIF<Integer> pilhaTopo = new MinhaPilhaEncadeada();
        for (int i = 0; i < k; i++) {
            if (!isEmpty()) {
                try {
                    pilhaTopo.empilhar(desempilhar());
                } catch (PilhaVaziaException e) {
                    // apenas ignota
                }
            }
        }
        return pilhaTopo;
    }

    @Override
    public boolean isEmpty() {
        return listaEncadeada.estaVazia();
    }

    @Override
    public void redimensionar() {
    }
}
