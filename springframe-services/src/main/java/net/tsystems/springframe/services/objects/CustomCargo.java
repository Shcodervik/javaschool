/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.objects;

public class CustomCargo {
    private int idCargo;
    private String description;
    private Double weight;
    private CargostateEntitySO cargoStateIdCargoState;
    private String road;
    private double roadLength;
    private double roadSpeed;
    private double timeInRoad;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public CargostateEntitySO getCargoStateIdCargoState() {
        return cargoStateIdCargoState;
    }

    public void setCargoStateIdCargoState(CargostateEntitySO idCargoState) {
        cargoStateIdCargoState = idCargoState;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public double getRoadLength() {
        return roadLength;
    }

    public void setRoadLength(double roadLength) {
        this.roadLength = roadLength;
    }

    public double getRoadSpeed() {
        return roadSpeed;
    }

    public void setRoadSpeed(double roadSpeed) {
        this.roadSpeed = roadSpeed;
    }

    public double getTimeInRoad() {
        return timeInRoad;
    }

    public void setTimeInRoad(double timeInRoad) {
        this.timeInRoad = timeInRoad;
    }
}
