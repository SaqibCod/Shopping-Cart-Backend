package com.Saq.fashionZShop.service.user;

import com.Saq.fashionZShop.model.User;
import com.Saq.fashionZShop.request.CreateUserRequest;
import com.Saq.fashionZShop.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);


}
