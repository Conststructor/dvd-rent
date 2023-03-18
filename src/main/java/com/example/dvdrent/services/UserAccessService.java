package com.example.dvdrent.services;

import com.example.dvdrent.entities.UserAccess;

public interface UserAccessService {
    UserAccess getUserAccess(String login);
}
