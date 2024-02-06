package org.example.traficnotisboard.controller;

import org.example.traficnotisboard.model.TraficMessage;
import org.example.traficnotisboard.service.TraficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tobias Heidlund
 */
@RestController
@RequestMapping("/channels/{channelId}")
public class TrafficController {
    @Autowired
    TraficService traficService;

    @GetMapping
    public ResponseEntity<List<TraficMessage>> getallMessages(@PathVariable Long channelId){
        List<TraficMessage> traficMessages =  traficService.getAll(channelId);
        if(traficMessages.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(traficMessages);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(traficMessages);
        }
    }

    //TODO: MAKE SURE THAT ONLY REQUIED FILEDS ARE SENT
    @DeleteMapping()
    public ResponseEntity<String> deleteMessage(@PathVariable Long channelId, @RequestBody TraficMessage message){
        if (traficService.delete(channelId,message)){
            return ResponseEntity.status(200).body("Success");
        }else {
            return ResponseEntity.status(400).body("Failed");
        }
    }
    @PatchMapping()
    public ResponseEntity<String> updateMessage(@PathVariable Long channelId, @RequestBody TraficMessage message){
        if (traficService.save(channelId,message)){
            return ResponseEntity.status(200).body("Success");
        }else {
            return ResponseEntity.status(400).body("Failed");
        }
    }

    @PutMapping()
    public ResponseEntity<String> addMessage(@PathVariable Long channelId, @RequestBody TraficMessage message){
        if (traficService.save(channelId,message)){
            return ResponseEntity.status(200).body("Success");
        }else {
            return ResponseEntity.status(400).body("Failed");
        }
    }



}
