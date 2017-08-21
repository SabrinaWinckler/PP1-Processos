/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

import estruturas.Fila;
import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class FCFS {

    ArrayList<Processo> listaEntrada;
    Fila lista;

    public FCFS(ArrayList listaEntrada) {
        int tamanhoLista;
        this.listaEntrada = listaEntrada;
        tamanhoLista = listaEntrada.size();
        this.lista = new Fila(tamanhoLista);
    }

    public void executar() {
        int tempoAtual = 0;

        while (listaEntrada.size() > 0 || lista.getTamanho() > 0) {
            for (int i = listaEntrada.size()-1; i >= 0; i--) {
                if(tempoAtual == listaEntrada.get(i).getChegada()){
                    lista.add(listaEntrada.remove(i));
                }                
            }
            if (lista.getTamanho() > 0) {
                lista.get().executar();
                System.out.println(tempoAtual+" "+lista.get().getNome());
                if (lista.get().getTempo() == 0) {
                    lista.remove();
                }
            }else{
                System.out.println(tempoAtual+" "+"-");
            }
            tempoAtual++;
        }

    }
}
