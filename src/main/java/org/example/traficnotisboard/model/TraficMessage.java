package org.example.traficnotisboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
}