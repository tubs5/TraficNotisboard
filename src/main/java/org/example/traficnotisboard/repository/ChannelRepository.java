package org.example.traficnotisboard.repository;

import org.example.traficnotisboard.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Tobias Heidlund
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {
}
