package com.mycompany.property.management.service.Impl;

import com.mycompany.property.management.converter.UserConverter;
import com.mycompany.property.management.dto.UserDTO;
import com.mycompany.property.management.entity.UserEntity;
import com.mycompany.property.management.repository.UserRepository;
import com.mycompany.property.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
