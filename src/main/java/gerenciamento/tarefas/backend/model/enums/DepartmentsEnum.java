package gerenciamento.tarefas.backend.model.enums;

public class DepartmentsEnum {

    public static int departments (String dp){
        int number = 0;
        switch (dp){
            case "desenvolvimento" :
                number = 1;
                break;
            case "financeiro" :
                number = 2;
                break;
            case "comercial" :
                number = 3;
                break;
            default:
               throw new NumberFormatException("Department not found");
        }
        return number;
    }


    public static String departments (int option){
        String department = null;
        switch (option){
            case 1 :
                department = "desenvolvimento";
                break;
            case 2 :
                department = "financeiro";
                break;
            case 3 :
                department = "comercial";
                break;
            default:
                department = null;
        }
        return department;
    }

}
