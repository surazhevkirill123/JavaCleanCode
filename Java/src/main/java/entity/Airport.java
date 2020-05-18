package entity;

import collection.MilitaryType;

import java.util.*;
import java.util.stream.Collectors;


public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }


    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream().filter(plane -> plane instanceof PassengerPlane)
                              .map(plane -> (PassengerPlane) plane)
                              .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(plane -> plane instanceof MilitaryPlane)
                              .map(plane -> (MilitaryPlane) plane)
                              .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {

        return getPassengerPlanes().stream().max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity)).get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(militaryPlane -> militaryPlane.getType() == MilitaryType.TRANSPORT)
                                           .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(militaryPlane -> militaryPlane.getType() == MilitaryType.BOMBER)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "entity.Airport{" + "planes=" + planes +
                '}';
    }
}
