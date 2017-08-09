/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 * @author Gustavo Bittencourt Satheler
 */
public class ListaEncadeada {

    private Encadeamento principal;

    public ListaEncadeada() {
        principal = null;
    }

    public boolean vazio() {
        return principal == null;
    }

    public void add(int i1, int i2) {
        Encadeamento lista = new Encadeamento(i1, i2);
        lista.nextLink = principal;
        principal = lista;
    }

    public Encadeamento rem() {
        Encadeamento temp = principal;
        if (principal == null) {
            return null;
        }
        principal = principal.nextLink;
        return temp;
    }

    public void exibir() {
        Encadeamento listaAtual = principal;
        System.out.println("Lista: ");
        while (listaAtual != null) {
            listaAtual.exibir();
            listaAtual = listaAtual.nextLink;
        }
        System.out.println("");
    }
}
