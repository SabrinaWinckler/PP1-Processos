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

    int tamanho;
    int posicaoAtual;
    int posicoesPreenchidas;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public ListaCircular(int tamanho) {
        this.tamanho = tamanho;
        this.objetos = new Object[tamanho];
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Publicos">
    public void resetar() {
        this.posicaoAtual = 0;
        this.posicoesPreenchidas = 0;
    }

    public boolean inserir(T objeto) {

        if (posicoesPreenchidas < tamanho) {
            if (posicaoAtual >= tamanho) {
                posicaoAtual = 0;
            }
            objetos[posicaoAtual] = objeto;
            posicaoAtual++;
            posicoesPreenchidas++;
            return true;
        }

        return false;
    }

    public T obter() {
        if (posicoesPreenchidas == 0) {
            return null;
        } else {
            int proximo = posicaoAtual - posicoesPreenchidas;
            if (proximo < 0) {
                proximo += tamanho;
            }
            T objeto = (T) this.objetos[proximo];
            posicoesPreenchidas--;
            return objeto;
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Gets">
    public int getTamanho() {
        return this.tamanho;
    }

    public int getPosicaoAtual() {
        return this.posicaoAtual;
    }

    public int getTamanhoAtual() {
        return this.posicoesPreenchidas;
    }

    public int getDisponivel() {
        return this.tamanho - this.posicoesPreenchidas;
    }
    //</editor-fold>
}
