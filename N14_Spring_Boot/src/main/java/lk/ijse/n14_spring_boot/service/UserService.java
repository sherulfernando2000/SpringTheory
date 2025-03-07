package lk.ijse.n14_spring_boot.service;


import lk.ijse.n14_spring_boot.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}