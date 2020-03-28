package com.home.automation.service;

import com.home.automation.model.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DeviceService {
    private ArrayList<Device> deviceList;

    public static int auto_increment_id = 1;

    public ArrayList<Device> getDeviceList() {
        if(deviceList == null) {
            deviceList = new ArrayList<>();
        }
        return deviceList;
    }

    public void setDeviceListList(ArrayList<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public Device createDevice(Device device){
        device.setId(auto_increment_id);
        auto_increment_id +=1;
        this.deviceList.add(device);
        return this.deviceList.get(this.getDeviceList().size()-1);
    }

    public Device getDevicebyId(int id){
        for(int i=0;i<this.deviceList.size();i++){
            if(this.deviceList.get(i).getId() == id){
                return this.deviceList.get(i);
            }
        }
        return null;
    }

    public boolean deleteDevicebyId(int id){
        for(int i=0;i<this.deviceList.size();i++){
            if(this.deviceList.get(i).getId() == id){
                this.deviceList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateDevicebyId(int id, Device device){
        for(int i=0;i<this.deviceList.size();i++){
            if(this.deviceList.get(i).getId() == id){
                this.deviceList.get(i).setStatus(device.isStatus());
                return true;
            }
        }
        return false;
    }
}

