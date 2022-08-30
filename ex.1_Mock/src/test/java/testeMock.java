public class testeMock implements servico {

    @Override
    public String busca(int id) { //Simula os números do servidor

        if (id == 1) {
            return professorConst.Renan;
        }
        if (id == 2) {
            return professorConst.Christopher;
        }
        if (id == 3) {
            return professorConst.Marcelo;
        }

        if (id == 4) {
            return professorConst.erroNome;
        }
        if (id == 5) {
            return professorConst.erroHorario;
        }
        if (id == 6) {
            return professorConst.erroPeriodo;
        }
        return null;
    }
}