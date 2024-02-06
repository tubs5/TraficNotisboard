package org.example.traficnotisboard.repository;

import org.example.traficnotisboard.model.Channel;
import org.example.traficnotisboard.model.TraficMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tobias Heidlund
 */
@Repository
public interface TraficRepository extends JpaRepository<TraficMessage, Long> {
    //TraficMessage deleteTraficMessageByChannelAndId(Long channel,Long id);

   // TraficMessage updateTraficMessageByIdAndChannel(TraficMessage message,Long id,Long channel);

    List<TraficMessage> getAllByChannel(Channel channel);
    TraficMessage getByChannelAndId(Channel channel,Long id);

}
