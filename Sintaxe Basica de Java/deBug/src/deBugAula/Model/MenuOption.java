package deBugAula.Model;

import deBugAula.dao.UserModelDao;

import java.util.function.Consumer;

public enum MenuOption {
    SAVE,
    UPDATE,
    DELETE,
    FIND_BY_ID,
    FIND_ALL,
    EXIT;

//    public MenuOption(final Consumer<UserModel> callback){
//        this.callback = callback;
//    }

    private Consumer calback;

    private  Runnable callback;

    MenuOption() {

    }
}
