package com.mycompany.property.management.service.Impl;

import com.mycompany.property.management.converter.UserConverter;
import com.mycompany.property.management.dto.UserDTO;
import com.mycompany.property.management.entity.UserEntity;
import com.mycompany.property.management.exception.BusinessException;
import com.mycompany.property.management.exception.ErrorModel;
import com.mycompany.property.management.repository.UserRepository;
import com.mycompany.property.management.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

            Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
            if (optUe.isPresent()){
                List<ErrorModel> errorModelList = new ArrayList<>();
                ErrorModel errorModel = new ErrorModel();
                errorModel.setCode("EMAIL_ALREADY_EXIST");
                errorModel.setMessage("The email with which you are trying to register is already exist");
                errorModelList.add(errorModel);

                throw new BusinessException(errorModelList);
            }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email,password);
        UserDTO userDTO = null;
        if (optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

           throw new BusinessException(errorModelList);
        }
        return userDTO;
    }


}
