package org.practice.example.parkinglot.service;

import org.practice.example.parkinglot.dao.BookedSpotDAO;
import org.practice.example.parkinglot.enums.VehicleType;
import org.practice.example.parkinglot.entity.ParkingLot;
import org.practice.example.parkinglot.entity.ParkingSpot;
import org.practice.example.parkinglot.entity.Ticket;
import org.practice.example.parkinglot.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ParkingManager {
    private static final Logger log = LoggerFactory.getLogger(ParkingManager.class);
    @Autowired
    ParkingLot parkingLot;
    @Autowired
    BookedSpotDAO bookedSpotDAO;
    @Autowired
    PaymentService paymentService;
    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void addParking(){
        parkingLot.addParkingSpot(new ParkingSpot(1,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(2,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(3,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));


        parkingLot.addParkingSpot(new ParkingSpot(1,true,new Vehicle(), VehicleType.FOUR_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(2,true,new Vehicle(), VehicleType.FOUR_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(3,true,new Vehicle(), VehicleType.FOUR_WHEELER.getVehicleType()));
    }

    public void removeParkingSpot(){
        parkingLot.removeParkingSpot(new ParkingSpot(1,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));
    }

    public void vehicleEnter(){
        Vehicle vehicle = new Vehicle(VehicleType.FOUR_WHEELER,"AP029696");
        /*-----Find the nearest Parking Spot-------------*/
        ParkingSpot nearestParkingSpot = parkingLot.getEntryPoint().getNearestParkingSpot(vehicle.getVehicleType());
        /*-----Generate a Ticket-------------*/
        Ticket ticket = new Ticket("1234", LocalDateTime.now(),null,vehicle,nearestParkingSpot,0);
        /*------Add into Booking Table-------*/
        bookedSpotDAO.addTicket(ticket);
    }

    public void vehicleExit(){
       Ticket ticket = bookedSpotDAO.findTicket("1234");
       if(ticket!=null) {
           /* ------Exit------------------------*/
           parkingLot.prePaymentProcess(ticket);
           /*-----Payment Process---------------*/
           String paymentStatus = paymentService.processPayment(ticket);
           if("SUCCESS".equals(paymentStatus)) {
              String existStatus =  parkingLot.postPaymentProcess(ticket);
              log.info("Vehicle Exist Status: {}",existStatus);
           }
           else{
               log.error("Failed Payment");
           }
       }
    }
}
