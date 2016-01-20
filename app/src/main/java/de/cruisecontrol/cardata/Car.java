package de.cruisecontrol.cardata;

import java.util.ArrayList;
import java.util.List;

import de.cruisecontrol.connections.ConnectionType;

/**
 * Created by Admin on 02.10.2015.
 */
public class Car {
    private String licensePlate;
    private List<Refuel> refuels = new ArrayList<>();
    private String password;
    private ConnectionType connectionType;

    public boolean save(){
        return false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<Refuel> getRefuels() {
        return refuels;
    }

    public void setRefuels(List<Refuel> refuels) {
        this.refuels = refuels;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }
}
