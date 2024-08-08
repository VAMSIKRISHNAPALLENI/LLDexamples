package org.practice.example.parkinglot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private double totalAmount;
    public void setExitTime() {
        this.exitTime = LocalDateTime.now();
    }

    public long getParkingDurationInHours() {
        return java.time.Duration.between(entryTime, exitTime).toHours();
    }

}
