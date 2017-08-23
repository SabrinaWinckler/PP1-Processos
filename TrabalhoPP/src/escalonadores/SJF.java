/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

import estruturas.ListaEncadeada;
import gerais.Processo;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gustavo Bittencourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 */
public class SJF {

    private int numeroDeProcessos = 0;
    private ArrayList<String> listaPlot;
    private ListaEncadeada emExecucao;
    private ListaEncadeada emEspera;

    public SJF(ArrayList<Processo> listaEntrada) {
        this.listaPlot = new ArrayList();
        this.emExecucao = new ListaEncadeada();
        this.emEspera = new ListaEncadeada();
        this.listaPlot = new ArrayList();
        for (int i = 0; i < listaEntrada.size(); i++) {
            if (listaEntrada.get(i).getChegada() == 0) {
                emExecucao.adicionar(listaEntrada.get(i));
            } else {
                emEspera.adicionar(listaEntrada.get(i));
            }
            numeroDeProcessos++;
        }

    }

    public ArrayList<String> executar() {
        int tempo = 0;
        int tempoInicial = 0;
        int tique = 0;

        ordenarDuracao(emExecucao);
        ordenarDuracao(emEspera);
        ordenarChegada(emEspera);

        Processo processoAtual = null;
        Processo novoProcesso = null;

        while (!emExecucao.vazio() || !emEspera.vazio()) {

            if (!emExecucao.vazio()) {
                processoAtual = (Processo) emExecucao.pegar(0);

                if (processoAtual.getTempo() == 0) {
                    for (int i = 0; i < (tempo - tempoInicial); i++) {
                        System.out.println(processoAtual.getNome() + " " + tique);
                        listaPlot.add(processoAtual.getNome());
                        tique++;
                    }
                    tempoInicial = tempo;
                    emExecucao.remover(0);
                } else {
                    processoAtual.executar();
                }
            }

            if (!emEspera.vazio()) {
                novoProcesso = (Processo) emEspera.pegar(0);
                if (novoProcesso.getChegada() == tempo) {
                    if (processoAtual.getTempo() > novoProcesso.getTempo()) {
                        for (int i = 0; i < (tempo - tempoInicial); i++) {
                            System.out.println(processoAtual.getNome() + " " + tique);
                            listaPlot.add(processoAtual.getNome());
                            tique++;
                        }
                        tempoInicial = tempo;
                    }

                    emExecucao.adicionarNoComeco(new Processo(novoProcesso.getNome(), novoProcesso.getChegada(), novoProcesso.getTempo()));
                    emEspera.remover(0);
                    ordenarDuracao(emExecucao);
                }
            }

            tempo++;

        }

        return listaPlot;

    }

    private ListaEncadeada ordenarDuracao(ListaEncadeada lista1) {
        ArrayList<Processo> lista2 = new ArrayList();
        while (!lista1.vazio()) {
            lista2.add((Processo) lista1.pegar(0));
            lista1.remover(0);
        }

        Collections.sort(lista2, (o1, o2) -> {
            return ((Processo) o1).getTempo() - ((Processo) o2).getTempo();
        });

        while (!lista2.isEmpty()) {
            lista1.adicionar(lista2.get(0));
            lista2.remove(0);
        }

        return lista1;
    }

    private ListaEncadeada ordenarChegada(ListaEncadeada lista1) {
        ArrayList<Processo> lista2 = new ArrayList();
        while (!lista1.vazio()) {
            lista2.add((Processo) lista1.pegar(0));
            lista1.remover(0);
        }

        Collections.sort(lista2, (o1, o2) -> {
            return ((Processo) o1).getChegada() - ((Processo) o2).getChegada();
        });

        while (!lista2.isEmpty()) {
            lista1.adicionar(lista2.get(0));
            lista2.remove(0);
        }

        return lista1;
    }
}
