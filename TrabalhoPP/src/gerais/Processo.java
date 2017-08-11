/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

/**
 *
 * @author Lucas
 */
public class Processo {

    private int tempo;
    private int prioridade;
    private boolean finalizado;

    public void Processo(int tempo, int prioridade) {
        this.tempo = tempo;
        this.prioridade = prioridade;
        this.finalizado = false;
    }

    public void executar() {
        if (this.tempo > 0) {
            this.tempo--;
            if (this.tempo == 0) {
                this.finalizado = true;
            }
        }
    }

    public boolean estaFinalizado() {
        return this.finalizado;
    }

    public int getPrioridade() {
        return this.prioridade;
    }

}
