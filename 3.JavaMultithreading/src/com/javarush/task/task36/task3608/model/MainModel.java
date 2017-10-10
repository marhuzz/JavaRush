package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;


/**
 * Created by Marhuz on 20.02.2017.
 */
public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    private List<User> getAllUsers(){

        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
    }


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
        //modelData.setDisplayDeletedUserList(false);
    }

    private List<User> filter(List<User> users) {
        return userService.filterOnlyActiveUsers(users);
    }
}
