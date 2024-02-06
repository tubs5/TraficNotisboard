package org.example.traficnotisboard.service;

import org.example.traficnotisboard.model.Channel;
import org.example.traficnotisboard.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tobias Heidlund
 */
@Service
public class ChannelService {
    @Autowired
    ChannelRepository channelRepository;


    public Long create() {
        return channelRepository.save(new Channel()).getId();
    }

    public List<Channel> getAll() {
        return channelRepository.findAll();
    }
}
