package org.example.traficnotisboard.service;

import org.example.traficnotisboard.model.Channel;
import org.example.traficnotisboard.model.TraficMessage;
import org.example.traficnotisboard.repository.TraficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tobias Heidlund
 */
@Service
public class TraficService {
    @Autowired
    private TraficRepository traficRepository;

    public List<TraficMessage> getAll(Long channel){
        return traficRepository.getAllByChannel(new Channel(channel));
    }
    public boolean delete(Long channel, TraficMessage message){
        message.setChannel(new Channel(channel));
        traficRepository.delete(message);
        return get(channel,message.getId()) == null;
    }

    public boolean save(Long channel, TraficMessage message){
        message.setChannel(new Channel(channel));
        return (traficRepository.save(message).equals(message));
    }
    public TraficMessage get(Long channel,Long id){
        return traficRepository.getByChannelAndId(new Channel(channel),id);
    }
}
