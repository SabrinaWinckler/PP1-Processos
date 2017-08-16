/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

import estruturas.ListaEncadeada;
import gerais.Processo;

/**
 *
 * @author Gustavo Bittencourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 */
public class SJF {

    private int numeroDeProcessos = 0;

    private ListaEncadeada emExecucao = new ListaEncadeada();
    private ListaEncadeada emEspera = new ListaEncadeada();
    
    private ListaEncadeada organizador = new ListaEncadeada();

    public void adicionarProcesso(Processo processo) {
        if (processo.getChegada() == 0) {
            emExecucao.adicionar(processo);
        } else {
            emEspera.adicionar(processo);
        }
        numeroDeProcessos++;
    }

    public void executar() {
        int tempo = 0;

        do {
            if (emExecucao.vazio() && !emEspera.vazio()) {
                for(int i = 0; i < emEspera.tamanho() - 1; i++){
                                        
                    Processo processo1 = (Processo) emEspera.pegar(i);
                    Processo processo2 = (Processo) emEspera.pegar(i + 1);
                    
                    if (processo1.getChegada() == tempo && processo2.getChegada() == tempo){
                        int calc = processo1.getTempo() - processo2.getTempo();
                        
                        if (calc > 0){
                            emExecucao.adicionar(processo1);
                        } else if (calc < 0) {
                            emExecucao.adicionar(processo2);
                        } else {
                            emExecucao.adicionar(processo1);
                        }
                    }
                }
                
//                emExecucao.adicionar(emEspera.pegar(0));
            } else {
                
            }
            
            tempo++;
        } while (emExecucao.tamanho() != 0 || emEspera.tamanho() != 0);
    }
}
