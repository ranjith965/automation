package com.home.automation.controller;

import java.net.URI;
import java.util.ArrayList;

import com.home.automation.model.Device;
import com.home.automation.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/devices")
public class DeviceController
{
    @Autowired
    DeviceService service;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Device>> getAllDevices() {
        ArrayList<Device> list = service.getDeviceList();

        return new ResponseEntity<ArrayList<Device>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") int id){
        Device entity = service.getDevicebyId(id);

        return new ResponseEntity<Device>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(path = "/",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device updated = service.createDevice(device);
        return new ResponseEntity<Device>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(path = "/{id}",consumes = "application/json", produces = "application/json")
    public HttpStatus updateDevice(@PathVariable("id") int id, @RequestBody Device device) {
        if(service.updateDevicebyId(id, device)){
            return HttpStatus.OK;
        }
        return HttpStatus.FORBIDDEN;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public HttpStatus deleteDeviceById(@PathVariable("id") int id){
        if(service.deleteDevicebyId(id)){
            return HttpStatus.OK;
        }
        return HttpStatus.FORBIDDEN;
    }

}

