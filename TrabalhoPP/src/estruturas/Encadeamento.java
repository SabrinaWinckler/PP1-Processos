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
public class Encadeamento {
    public int chegada;
    public int duracao;
    public Encadeamento nextLink;

    public Encadeamento(int info1, int info2) {
        this.chegada = info1;
        this.duracao = info2;
    }
    
    public void exibir() {
        System.out.print("{" + chegada + ", " + duracao + "}");
    }   
}
