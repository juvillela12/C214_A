import org.junit.Test;
import static org.junit.Assert.*;

public class testeAplicativo {

    //Teste assertivo

    @Test
    public void testeBuscaRenan(){

        servico servico = new testeMock();
        aplicativo app = new aplicativo(servico);

        professor Renan = app.buscaProfessor(1);

        assertEquals("Renan", Renan.getNome());
        assertEquals(15, Renan.getHorarioAtendimento());
        assertEquals("integral", Renan.getPeriodo());
    }

    @Test
    public void testeBuscaChristopher(){

        servico servico = new testeMock();
        aplicativo app = new aplicativo(servico);

        professor Christopher = app.buscaProfessor(2);

        assertEquals("Christopher", Christopher.getNome());
        assertEquals(17, Christopher.getHorarioAtendimento());
        assertEquals("integral", Christopher.getPeriodo());
    }

    @Test
    public void testeBuscaMarcelo(){

        servico servico = new testeMock();
        aplicativo app = new aplicativo(servico); //Instanciando Classe e passando o parametro que

        professor Marcelo = app.buscaProfessor(3);

        assertEquals("Marcelo", Marcelo.getNome());
        assertEquals(19, Marcelo.getHorarioAtendimento());
        assertEquals("noturno", Marcelo.getPeriodo());
    }


    //Teste de erro

    @Test
    public void testeErroNome(){

        servico servico = new testeMock();
        aplicativo app = new aplicativo(servico);

        professor erroNome = app.buscaProfessor(4);

        assertNotEquals("Renan", erroNome.getNome());
        assertEquals(15, erroNome.getHorarioAtendimento());
        assertEquals("integral", erroNome.getPeriodo());
    }

    @Test
    public void testeErroHorario(){

        servico servico = new testeMock();
        aplicativo app = new aplicativo(servico);

        professor erroHorario = app.buscaProfessor(5);

        assertEquals("Christopher", erroHorario.getNome());
        assertNotEquals(19, erroHorario.getHorarioAtendimento());
        assertEquals("integral", erroHorario.getPeriodo());
    }

    @Test
    public void testeErroPeriodo(){

        servico service = new testeMock();
        aplicativo app = new aplicativo(service);

        professor erroPeriodo = app.buscaProfessor(6);

        assertEquals("Marcelo", erroPeriodo.getNome());
        assertEquals(19, erroPeriodo.getHorarioAtendimento());
        assertNotEquals("noturno", erroPeriodo.getPeriodo());
    }

}
