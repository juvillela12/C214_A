import br.inatel.cdg.impl.Observador;
import br.inatel.cdg.impl.Observavel;
import br.inatel.cdg.palavrasMain;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteObserver {

    //Testando a existência de 1 cliente
    @Test
    public void testeInscritos(){
        Observavel palavras = new Observavel();
        Observador obs1 = new Observador(1);
        palavras.registraObservador(obs1);
        assertTrue(!palavras.getClientes().isEmpty());
    }

    //Testando 2 clientes enquanto 1 é removido
    @Test
    public void teste2Inscritos(){
        Observavel palavras = new Observavel();

        Observador obs1 = new Observador(1);
        Observador obs2 = new Observador(2);
        Observador obs3 = new Observador(3);

        palavras.registraObservador(obs1);
        palavras.registraObservador(obs2);
        palavras.registraObservador(obs3);

        palavras.removeObservador(obs1);

        assertEquals(palavras.getClientes().size(), 2);
    }

    //Testando 3 clientes
    @Test
    public void teste3Inscritos(){
        Observavel netflix = new Observavel();

        Observador obs1 = new Observador(1);
        Observador obs2 = new Observador(2);
        Observador obs3 = new Observador(3);

        netflix.registraObservador(obs1);
        netflix.registraObservador(obs2);
        netflix.registraObservador(obs3);

        assertEquals(netflix.getClientes().size(), 3);
    }

    //Testando a frase setada com os métodos de leitura da mesma criados
    @Test
    public void testeFrase() {
        Observavel palavras = new Observavel();

        Observador obs1 = new Observador(1);

        palavras.registraObservador(obs1);

        palavras.setNovaFrase("materia Engenharia de Software");

        assertEquals(palavras.getQtyPalavras(), 4);
        assertNotEquals(palavras.getQtyPalavrasPares(), 1);
        assertEquals(palavras.getQtyLetrasMaiusculas(), 2);
    }

}
