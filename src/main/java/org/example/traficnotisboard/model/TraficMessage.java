package org.example.traficnotisboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tobias Heidlund
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TraficMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Channel channel;
    private String title;

    public boolean hasId() {
        if (id != null){
            return id != 0;
        }
        return false;
    }
}