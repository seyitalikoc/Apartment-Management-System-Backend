package com.seyitkoc.service;

import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import com.seyitkoc.entity.user.User;

public interface IUserService {
    String createNewUser(DtoUserCreate dtoUserCreate);

    DtoUser getUserByTokenAndId(String token, Long id);

    String updateUser(String token, DtoUserUpdate dtoUserUpdate);

    String deleteUser(String token);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void checkUserIsMemberOfBuilding(String email, Long buildingId);

    void checkUserIsManagerOfBuilding(User user, Long buildingId);
    void checkUserIsManagerOfBuilding(String email, Long buildingId);

    void checkUserIsOwnerOrTenantOfApartment(User user, Long apartmentId);
    void checkUserIsOwnerOrTenantOfApartment(String email, Long apartmentId);

    void checkUserIsOwnerOfApartment(String email, Long apartmentId);
}
