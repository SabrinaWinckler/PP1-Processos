/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

import estruturas.ListaEncadeada;

/**
 *
 * @author Lucas
 */
public class FCFS {
    
    public FCFS(){
        
    
    }
    
    ListaEncadeada lista = new ListaEncadeada();
    
        public void enqueue(Object elemento)
	// Post: An item is added to the back of the queue.
	{
		// Append the item to the end of our linked list.
		lista.adicionar(elemento);
	}

	public Object dequeue()
	// Pre: this.isEmpty() == false
	// Post: The item at the front of the queue is returned and 
	//         deleted from the queue. Returns null if precondition
	//         not met.
	{
		// Store a reference to the item at the front of the queue
		//   so that it does not get garbage collected when we 
		//   remove it from the list.
		// Note: list.get(...) returns null if item not found at
		//   specified index. See postcondition.
		Object elemento = lista.pegar(1);
		// Remove the item from the list.
		// My implementation of the linked list is based on the
		//   J2SE API reference. In both, elements start at 1,
		//   unlike arrays which start at 0.
		lista.remover(1);
		
		// Return the item
		return elemento;
	}

	public Object peek()
	// Pre: this.isEmpty() == false
	// Post: The item at the front of the queue is returned and 
	//         deleted from the queue. Returns null if precondition
	//         not met.
	{
		// This method is very similar to dequeue().
		// See Queue.dequeue() for comments.
		return lista.pegar(1);
	}
}
