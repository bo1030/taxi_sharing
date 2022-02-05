package com.taxisharing.server.waiting_room.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoundaryCoordinate {
    private float leftLatitude;
    private float rightLatitude;
    private float leftLongitude;
    private float rightLongitude;

    public BoundaryCoordinate(String[] coordinates)
    {
        this.leftLatitude = Float.parseFloat(coordinates[0]);
        this.rightLatitude = Float.parseFloat(coordinates[1]);
        this.leftLongitude = Float.parseFloat(coordinates[2]);
        this.rightLongitude = Float.parseFloat(coordinates[3]);
    }
}
