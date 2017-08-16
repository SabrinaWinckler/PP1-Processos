/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

import estruturas.ListaEncadeada;
import gerais.Processo;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Gustavo Bittencourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 */
public class SJF {

    private int numeroDeProcessos;

    private ListaEncadeada processos = new ListaEncadeada();
    private ListaEncadeada naFila = new ListaEncadeada();
    private ListaEncadeada foraDaFila = new ListaEncadeada();

    public void adicionarProcesso(Processo meuProcesso) {
        if (meuProcesso.getChegada() == 0) {
            naFila.adicionar(meuProcesso);
        } else {
            foraDaFila.adicionar(meuProcesso);
        }
        numeroDeProcessos++;
    }

    public void organizar() {
        int tempo = 0;
        int iniciarProcesso = 0;
        
        Processo agora = null;
        Processo novo = null;
        do {
            tempo += 1;

            if (naFila.tamanho() != 0) {
                agora = (Processo) naFila.pegar(0);

                if (agora.getTempo() == 1) {
                    System.out.println(agora.getNome() + " executou entre o tempo " + iniciarProcesso + " e " + tempo);
                    iniciarProcesso = tempo;
                    naFila.remover(0);
                } else {
                    agora.executar();
                }
            }
            if (foraDaFila.tamanho() != 0) {
                novo = (Processo) foraDaFila.pegar(0);
                if (novo.getChegada() == tempo) {
                    if (agora.getTempo() > novo.getTempo()) {
                        System.out.println(agora.getNome() + " executou entre o tempo " + iniciarProcesso + " e " + tempo);
                        iniciarProcesso = tempo;
                    }
                    naFila.adicionar(novo.clonar());
                    foraDaFila.remover(0);
                }
            }
        } while (foraDaFila.tamanho() != 0 || naFila.tamanho() != 0);
    }
}
