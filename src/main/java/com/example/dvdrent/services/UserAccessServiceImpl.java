package com.example.dvdrent.services;

import com.example.dvdrent.entities.UserAccess;
import com.example.dvdrent.repositories.UserAccessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccessServiceImpl implements UserAccessService {

    private final UserAccessRepository userAccessRepository;

    public UserAccessServiceImpl(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    @Override
    public UserAccess getUserAccess(String login) {
        List<UserAccess> userAccessesList = userAccessRepository.findByUserLogin(login);
        return userAccessesList.size()==1?userAccessesList.get(0):null;
    }
}
