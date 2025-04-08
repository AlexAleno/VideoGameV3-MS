package com.champsoft.usermanagement.BusinessLogic;

import com.example.videogamev3.UserManagement.DataAccess.User;
import com.example.videogamev3.UserManagement.DataAccess.UserRepository;
import com.example.videogamev3.UserManagement.DataMapper.UserRequestMapper;
import com.example.videogamev3.UserManagement.DataMapper.UserResponseMapper;
import com.example.videogamev3.UserManagement.Presentation.UserRequestModel;
import com.example.videogamev3.UserManagement.Presentation.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    public UserService(UserRepository userRepository, UserResponseMapper userResponseMapper, UserRequestMapper userRequestMapper) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
    }

    public List<UserResponseModel> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userResponseMapper.userToUserResponseModel(users);
    }

    public UserResponseModel getUserById(String uuid) {
        User user = userRepository.findUserByUserId_uuid(uuid);
        System.out.println(user.getGames());
        return userResponseMapper.userToUserResponseModel(user);
    }

    public User getUserEntityById(String uuid) {
        User user = userRepository.findUserByUserId_uuid(uuid);
        return user;
    }

    public UserResponseModel addUser(UserRequestModel userRequestModel) {
        User user = userRequestMapper.userRequestModelToUser(userRequestModel);
        userRepository.save(user);
        return userResponseMapper.userToUserResponseModel(user);
    }

    public UserResponseModel updateUser(UserRequestModel userRequestModel, String uuid) {
        User user = userRepository.findUserByUserId_uuid(uuid);
        user.setUsername(userRequestModel.getUsername());
        user.setEmail(userRequestModel.getEmail());
        user.setPassword(userRequestModel.getPassword());
        userRepository.save(user);
        return userResponseMapper.userToUserResponseModel(user);
    }

    public void deleteUser(String uuid) {
        User user = userRepository.findUserByUserId_uuid(uuid);
        userRepository.delete(user);
    }
}
