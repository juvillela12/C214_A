import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class aplicativo {

    //Busca o professor de forma remota
    servico servico;

    public aplicativo(servico servico){
        this.servico = servico;
    }

    public professor buscaProfessor(int id){

        String professorJson = servico.busca(id);

        //Convertendo a string professorJson para um JsonObject usando a dependência Gson
        JsonObject jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();

        return new professor(jsonObject.get("nomeProfessor").getAsString(),
                jsonObject.get("horarioAtendimento").getAsInt(),
                jsonObject.get("periodo").getAsString());
    }

}
