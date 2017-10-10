package com.javarush.task.task36.task3608.model;

/**
 * Created by Marhuz on 19.02.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long id);
    void deleteUserById(long id);

}
