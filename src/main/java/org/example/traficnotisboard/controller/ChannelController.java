package org.example.traficnotisboard.controller;

import org.example.traficnotisboard.model.Channel;
import org.example.traficnotisboard.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Channel> createMessage(@RequestBody Channel channel){
        System.out.println(channel.toString());
        if(channel.getTitle().isEmpty()){
            return ResponseEntity.status(400).build();
        }
        channel = channelService.create(channel.getTitle());
        if(channel.getId()!=-1){
            return ResponseEntity.status(201).body(channel);
        }else {
            return ResponseEntity.status(400).build();
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

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeChannel(@PathVariable long id){
        channelService.remove(id);
       return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Channel> updateChannel(@PathVariable long id,@RequestBody Channel channel){
        if (!channel.hasTitle()){
            return ResponseEntity.status(404).build();
        }
        channel.setId(id);
        Channel newChannel = channelService.update(channel);
        return ResponseEntity.status(HttpStatus.OK).body(newChannel);

    }






}
