package tad.pilha;

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {
    
	// nao consegui lidar com esse erro :(
    private PilhaIF<Integer> listaEncadeada = new PilhaIF<Integer>();

    @Override
    public void empilhar(Integer item) throws PilhaCheiaException {
        listaEncadeada.empilhar(item);
    }

    @Override
    public Integer desempilhar() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia. Não é possível desempilhar.");
        }
        return listaEncadeada.desempilhar();
    }

    /**
	 * Retorna o elemento do topo da pilha encadeada.
	 *
	 * @return o elemento do topo da pilha
	 * @throws PilhaVaziaException se a pilha estiver vazia
	 */
	@Override
	public Integer topo(){
		return listaEncadeada.topo();
	}


    /**
 * Retorna uma nova pilha contendo os k elementos do topo da pilha original.
 * Se a pilha original contiver menos de k elementos, a nova pilha conterá
 * todos os elementos da pilha original.
 * 
 * @param k o número de elementos a serem desempilhados da pilha original
 * @return uma nova pilha contendo os k elementos do topo da pilha original
 */
@Override
public PilhaIF<Integer> multitop(int k) {
    // Cria uma nova pilha para armazenar os elementos do topo
    PilhaIF<Integer> pilhaTopo = new MinhaPilhaEncadeada();

    // Desempilha os k elementos da pilha original e empilha na nova pilha
    for (int i = 0; i < k; i++) {
        // Verifica se a pilha original não está vazia
        if (!isEmpty()) {
            try {
                // Desempilha um elemento da pilha original e empilha na nova pilha
                pilhaTopo.empilhar(desempilhar());
            } catch (PilhaVaziaException e) {
                // Se a pilha original estiver vazia, apenas ignora
            }
        } else {
            break; // Se a pilha original estiver vazia, interrompe o loop
        }
    }

    return pilhaTopo; // Retorna a nova pilha com os elementos do topo
}


    @Override
    public boolean isEmpty() {
        return listaEncadeada.isEmpty();
    }

    @Override
    public void redimensionar() {
    }
}
