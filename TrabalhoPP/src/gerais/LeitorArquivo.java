/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class LeitorArquivo {

    public static ArrayList lerArquivo() {
        ArrayList<Processo> listaProcessos;
        LeitorArquivo leitor = new LeitorArquivo();

        listaProcessos = leitor.montarLista(leitor.carregarArquivo());

        return listaProcessos;
    }

    private BufferedReader carregarArquivo() {

        try {
            JFileChooser chooser = new JFileChooser();
            int retorno = chooser.showOpenDialog(null);

            if (retorno == JFileChooser.APPROVE_OPTION) {
                FileReader reader = new FileReader(chooser.getSelectedFile());
                JOptionPane.showMessageDialog(null, "Arquivo importado com sucesso");
                BufferedReader bufferedReader = new BufferedReader(reader);
                return bufferedReader;

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeitorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private ArrayList montarLista(BufferedReader br) {

        ArrayList<Processo> listaProcessos = new ArrayList();
        String[] processoStringArray;
        String processoString;
        String nome;
        int chegada;
        int tamanho;

        try {

            while ((processoString = br.readLine()) != null) {
                processoStringArray = processoString.split(",");

                nome = processoStringArray[0];
                chegada = Integer.parseInt(processoStringArray[1]);
                tamanho = Integer.parseInt(processoStringArray[2]);

                listaProcessos.add(new Processo(nome, chegada, tamanho));

            }

        } catch (IOException ex) {
            Logger.getLogger(LeitorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.sort(listaProcessos, new Comparator<Processo>() {
            @Override
            public int compare(Processo o1, Processo o2) {
                return o1.getChegada() - o2.getChegada();
            }
        });

        return listaProcessos;
    }

}
