/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author Lucas
 */
public class ListaCircular<T> {
    
    Object[] objetos;
    
    int tamanho;
    int posicaoAtual;
    int posicoesLivres;
    
    public ListaCircular(int tamanho){
        this.tamanho = tamanho;
        this.objetos = new Object[tamanho];
    }
    
    public void resetar(){
        this.posicaoAtual = 0;
        this.posicoesLivres = 0;
    }
    
    public boolean inserir(T objeto ){
        this.objetos[0] = objeto;
        return true;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }
    
    public int getPosicaoAtual(){
        return this.posicaoAtual;
    }
    
    public int getPosicoesLivres(){
        return this.posicoesLivres;
    }
}

