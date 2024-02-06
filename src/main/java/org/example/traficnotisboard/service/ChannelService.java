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


    public Channel create(String title) {
        return channelRepository.save(new Channel(title));
    }

    public List<Channel> getAll() {
        return channelRepository.findAll();
    }

    public Channel update(Channel channel) {
       return channelRepository.save(channel);

    }

    public void remove(long id) {
        channelRepository.deleteById(id);
    }
}
