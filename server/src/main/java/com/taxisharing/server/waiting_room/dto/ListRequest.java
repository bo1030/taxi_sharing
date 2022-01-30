package com.taxisharing.server.waiting_room.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
public class ListRequest {
    private String departure_time;
    private String departure_address;
    private String departure_boundary;
    private String destination_address;
    private String destination_boundary;

    @Override
    public String toString() {
        return "ListRequest{" +
                "departureTime=" + departure_time +
                ", departureAddress=" + departure_address +
                ", departureBoundary=" + departure_boundary +
                ", destinationAddress=" + destination_address +
                ", destinationBoundary=" + destination_boundary +
                '}';
    }

    public ListRequest(String departure_time, String departure_address, String departure_boundary, String destination_address, String destination_boundary) {
        this.departure_time = Optional.ofNullable(departure_time).orElseGet(()-> "None");
        this.departure_address = Optional.ofNullable(departure_address).orElseGet(()-> "None");
        this.departure_boundary = Optional.ofNullable(departure_boundary).orElseGet(()-> "None");
        this.destination_address = Optional.ofNullable(destination_address).orElseGet(()-> "None");
        this.destination_boundary = Optional.ofNullable(departure_boundary).orElseGet(()-> "None");
    }

}