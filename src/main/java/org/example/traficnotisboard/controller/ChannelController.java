package org.example.traficnotisboard.controller;

import org.example.traficnotisboard.model.Channel;
import org.example.traficnotisboard.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Tobias Heidlund
 */
@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    ChannelService channelService;

    @PostMapping()
    public ResponseEntity<String> createMessage(){
        long id = channelService.create();
        if(id!=-1){
            return ResponseEntity.status(201).body("Created with id "+id);
        }else {
            return ResponseEntity.status(400).body("Failed");
        }
    }
    @GetMapping
    public ResponseEntity<List<Channel>> getAllChannels(){
        List<Channel> channelList = channelService.getAll();
        if(channelList.isEmpty()){
            return ResponseEntity.status(204).body(channelList);
        }else {
            return ResponseEntity.status(200).body(channelList);
        }
    }
}
