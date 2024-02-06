package org.example.traficnotisboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
