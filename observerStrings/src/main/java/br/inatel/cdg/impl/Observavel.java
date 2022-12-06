package br.inatel.cdg.impl;
import br.inatel.cdg.interfaces.iObservavel;
import java.util.ArrayList;
import java.util.List;

public class Observavel implements iObservavel {

    private String frase;
    private int qtyPalavras, qtyPalavrasPares, qtyLetrasMaiusculas;
    private List<Observador> clientes;

    public Observavel() {
        clientes = new ArrayList<Observador>();
    }

    @Override
    public void registraObservador(Observador obs) {
        clientes.add(obs);
    }

    @Override
    public void removeObservador(Observador obs) {
        if(clientes.contains(obs))
            clientes.remove(obs);
    }

    @Override
    public void notificaObservadores() {
        for (Observador observador : clientes) {
            observador.update(this);
        }
    }

    private int contaPalavrasPares(String[] palavras) {
        int count = 0;
        for(String s: palavras) {
            if(s.length() % 2 == 0){
                count+=1;
            }
        }
        return count;
    }

    private int contaLetrasMaiusculas(String[] palavras){
        int count = 0;
        for(int j = 0; j<palavras.length; j++){
            char aux = palavras[j].charAt(0);
            if(Character.isUpperCase(aux) == true){
                count+=1;
            }
        }
        return count;
    }
    //Esse método é chamado sempre que os valores se modificacam
    private void novasMedidas(String frase) {
        String[] palavrasAux = frase.split(" ");
        int count1 = 0;
        int count2 = 0;

        setQtyPalavras(palavrasAux.length);

        count1= contaPalavrasPares(palavrasAux);
        setQtyPalavrasPares(count1);

        count2 = contaLetrasMaiusculas(palavrasAux);
        setQtyLetrasMaiusculas(count2);

        System.out.println("--------------------- Nova notificação --------------------");
        notificaObservadores();
    }

    public void setNovaFrase(String frase) {
        this.frase = frase;
        novasMedidas(this.frase);
    }

    //Getters e Setters
    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public void setClientes(List<Observador> clientes) {
        this.clientes = clientes;
    }

    public List<Observador> getClientes() {
        return clientes;
    }

    public int getQtyLetrasMaiusculas() {
        return qtyLetrasMaiusculas;
    }

    public void setQtyLetrasMaiusculas(int qtyLetrasMaiusculas) {
        this.qtyLetrasMaiusculas = qtyLetrasMaiusculas;
    }

    public int getQtyPalavrasPares() {
        return qtyPalavrasPares;
    }

    public void setQtyPalavrasPares(int qtyPalavrasPares) {
        this.qtyPalavrasPares = qtyPalavrasPares;
    }

    public int getQtyPalavras() {
        return qtyPalavras;
    }

    public void setQtyPalavras(int numPalavras) {
        this.qtyPalavras = numPalavras;
    }

}
