import java.util.ArrayList;
import java.util.List;

public class ObterTarefasServico {


    public List<String> obterTodos(){
        List<String> lista = new ArrayList<>();
        for(int i = 1; i < 20; i++){
            lista.add(i+"Tarefa - Prioridade: Alta");
        }



        return lista;
    }

}

