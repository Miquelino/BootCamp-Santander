package deBugAula.validator;

import deBugAula.dao.UserModelDao;
import deBugAula.exception.ValidatorException;

public class UserValidator {

    private UserValidator(){
    }

    public static void VerifyModel(final UserModelDao model) throws ValidatorException {
        if(stringIsBlank(model.getName()))
            throw new ValidatorException("Iforme um nome valido");
        if(model.getName().length() <= 2)
            throw new ValidatorException("O ome deve ter mais que 1 caracter");
        if(stringIsBlank(model.getEmail()))
            throw new ValidatorException("Informe um email válido");
        if ((!model.getEmail().contains("@")) || (!model.getEmail().contains(".")))
            throw new ValidatorException("Informe um email válido");
    }

    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
