package deBugAula.Model;

import deBugAula.dao.UserModelDao;
import deBugAula.exception.EmptyStoregeException;
import deBugAula.exception.UserNotFoundExeption;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private long nextId = 1L;

    private List<UserModelDao> models = new ArrayList<>();


    public UserModelDao save(final UserModelDao model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModelDao update(final UserModelDao model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id){
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModelDao findById(final long id) {
        verifyStoroge();
        var message = String.format("Não existe o usuário com o id %s cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundExeption(message));
    }

    public List<UserModelDao> findAll(){
        List<UserModelDao> result;
        try {
            verifyStoroge();
            result = models;
        } catch (EmptyStoregeException e) {
            e.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStoroge(){
        if (models.isEmpty()) throw new EmptyStoregeException("O armazenamento está vazio.");
    }
}

