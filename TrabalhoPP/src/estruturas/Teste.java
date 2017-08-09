/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author Gustavo Bittencourt Satheler
 */
public class Teste {
     public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.add(0, 9);
        lista.add(1, 4);
        lista.add(2, 2);

        lista.exibir();
        
        lista.rem();
        
//        while(!lista.vazio()) {
//            Encadeamento remover = lista.rem();
//            System.out.print("Removido: ");
//            remover.exibir();
//            System.out.println("");
//        }

        lista.exibir();
    }
}
