package br.inatel.cdg.impl;

import br.inatel.cdg.interfaces.iObservador;

public class Observador implements iObservador {

    int id;

    public Observador(int id)
    {
        this.id = id;
    }

    @Override
    public void update(Observavel palavrasMain) {

        System.out.println("Cliente: "+this.id);
        System.out.println("Frase: " + palavrasMain.getFrase());
        System.out.println("Número de palavras da frase: " + palavrasMain.getQtyPalavras());
        System.out.println("Quantidade de palavras pares: " + palavrasMain.getQtyPalavrasPares());
        System.out.println("Quantidade de palavras que começam com letra maiúscula: " + palavrasMain.getQtyLetrasMaiusculas() + "\n");
    }

}
