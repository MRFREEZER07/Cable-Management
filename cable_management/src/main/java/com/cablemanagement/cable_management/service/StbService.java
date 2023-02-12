package com.cablemanagement.cable_management.service;

import com.cablemanagement.cable_management.entity.Stb;

public interface StbService {

    Stb addStbDetails(long id,Stb stb);
    Stb updateStbDetails(long id,Stb stb);
    Stb getStbDetails(long id);
}
