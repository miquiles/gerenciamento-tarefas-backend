package gerenciamento.tarefas.backend.model.enums;

public class DepartmentsEnum {

    public static int departments (String dp){
        int number = 0;
        switch (dp){
            case "desenvolvimento" :
                number = 1;
                break;
            case "rh" :
                number = 2;
                break;
            case "diretoria" :
                number = 3;
                break;
            default:
               throw new NumberFormatException("Department not foud");
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
                department = "rh";
                break;
            case 3 :
                department = "diretoria";
                break;
            default:
                department = null;
        }
        return department;
    }

}
