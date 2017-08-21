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

    public RR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void executar() {

        int tempoClock = 0;
        int quantum = 0;

        while (listaProcessos.getTamanho() > 0 || listaEntrada.size() > 0) {

            for (int i = listaEntrada.size()-1; i >= 0 ; i--) {
                if (listaEntrada.get(i).getChegada() == tempoClock) {
                    listaProcessos.inserir(listaEntrada.remove(i));
                }
            }

            if (listaProcessos.getTamanho() > 0) {
                listaProcessos.obter().executar();
                System.out.println(tempoClock +" "+listaProcessos.obter().getNome() + " ");
                if (listaProcessos.obter().getTempo() == 0) {
                    listaProcessos.remover();
                }
                quantum++;

            } else {
                System.out.println(tempoClock +" "+"-");
                quantum = 0;
            }
            
            tempoClock++;

            if (quantum == this.tamanhoQuantum) {
                quantum = 0;
            }

            if (quantum == 0 && listaProcessos.getTamanho()>0) {
                listaProcessos.proximo();
            }

        }

    }

}
