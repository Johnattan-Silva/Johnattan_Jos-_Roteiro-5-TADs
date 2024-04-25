package tad.conjuntoDinamico;

public interface ConjuntoDinamicoIF<E> {
	
	public void inserir(E item); //adiciona um elemento ao conjunto dinâmico
	
	public E remover(E item); //remove um elemento do conjunto dinâmico. Se o elemento não estiver presente, geralmente retorna null ou lança uma exceção
	
	public E predecessor(E item); //Retorna o predecessor imediato do elemento especificado no conjunto
	
	public E sucessor(E item); //Retorna o sucessor imediato do elemento especificado
	
	public int tamanho(); //Retorna o número de elementos presentes no conjunto dinâmico
	
	public E buscar(E item); //Retorna o elemento especificado no conjunto, se presente. Caso contrário, retorna null ou lança uma exceção
	
	public E minimum(); //Retorna o elemento mínimo no conjunto, ou seja, o menor elemento presente
	
	public E maximum(); //Retorna o elemento máximo no conjunto, ou seja, o maior elemento presente

}
