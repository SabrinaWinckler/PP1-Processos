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

    //<editor-fold defaultstate="collapsed" desc="Declaração Variaveis">
    Object[] objetos;

    int tamanhoMaximo;
    int tamanhoAtual;
    int posicaoEscrita;
    int posicaoAtual;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public ListaCircular(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.objetos = new Object[tamanhoMaximo];
        this.tamanhoAtual = 0;
        this.posicaoEscrita = 0;
        this.posicaoAtual = 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Publicos">
    public void resetar() {
        this.posicaoEscrita = 0;
        this.tamanhoAtual = 0;
    }

    public boolean inserir(T objeto) {

        if (posicaoEscrita == tamanhoMaximo) {
            posicaoEscrita = 0;
        }
        objetos[posicaoEscrita] = objeto;
        posicaoEscrita++;
        tamanhoAtual++;
        return true;
        
    }

    public T obter() {        
      
        return (T) objetos[posicaoAtual];
        
    }
    
    public T remover(){
        
        T objeto = (T) objetos[posicaoAtual];
        
        objetos[posicaoAtual] = null;
        
        
        
        
        return objeto;
        
        
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Gets">
    public int getTamanho() {
        return this.tamanhoAtual;
    }

    public int getPosicaoAtual() {
        return this.posicaoAtual;
    }   
    //</editor-fold>
}
