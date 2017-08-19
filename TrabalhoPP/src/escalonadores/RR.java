/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

import estruturas.ListaCircular;
import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class RR {

    private ListaCircular<Processo> listaProcessos;
    private ArrayList<Processo> listaEntrada;
    private int tamanhoQuantum;

    public RR(ArrayList listaEntrada, int tamanhoQuantum) {

        int quantidadeProcessos;

        this.listaEntrada = listaEntrada;
        this.tamanhoQuantum = tamanhoQuantum;
        quantidadeProcessos = listaEntrada.size();

        this.listaProcessos = new ListaCircular(quantidadeProcessos);

    }

    public void executar() {

        int tempoClock = 0;
        int quantum = 0;

        while (listaProcessos.getTamanho() > 0 && listaEntrada.size() > 0) {

            for (int i = 0; i < listaEntrada.size(); i++) {
                if (listaEntrada.get(i).getChegada() == tempoClock) {
                    listaProcessos.inserir(listaEntrada.remove(i));
                }
            }
            
            if(listaProcessos.getTamanho() > 0){
                listaProcessos.obter().executar();
            }
            
            if(listaProcessos.obter().getTempo() == 0){
                
            }
            
            quantum++;
            tempoClock++;
            
            if(quantum == this.tamanhoQuantum){
                quantum = 0;
            }
            
            if(quantum == 0){
//                listaProcessos.;
            }
            

        }

    }

}
