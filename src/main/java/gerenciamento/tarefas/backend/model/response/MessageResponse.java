package gerenciamento.tarefas.backend.model.response;

import lombok.Data;

@Data
public class MessageResponse {

    private static final String SUCCESS_MESSAGE = "Usuário adicionado com sucesso";
    private static final String ERRO_MESSAGE = "Houve um erro na operação. Verifique os dados";
    private static final String PERSON_NOT_FOUND_MESSAGE = "Houve um erro ao pesquisar a pessoa";
    private static final String BAD_REQUEST_MESSAGE = "Houve um erro na tentativa de acessar o servidor";
    private static final String SUCCESS_DELETE_MESSAGE = "Usuário deletado com sucesso";
    private static final String DEPARTMENT_NOT_FOUND = "Verifique o departamento informado";

    public static String getSuccessMessage(){
        return SUCCESS_MESSAGE;
    }
    public static String getErroMessage(){
        return ERRO_MESSAGE;
    }
    public static String getBadRequestMessage(){
        return BAD_REQUEST_MESSAGE;
    }

    public static String getPersonNotFoundMessage(){
        return PERSON_NOT_FOUND_MESSAGE;
    }
    public static String getSuccessDeleteMessage(){
        return SUCCESS_DELETE_MESSAGE;
    }

    public static java.lang.String getDepartmentNotFound() {
        return DEPARTMENT_NOT_FOUND;
    }
}
