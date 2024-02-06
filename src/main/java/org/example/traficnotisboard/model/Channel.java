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

    private String title;

    public Channel(Long id ){
        this.id = id;
    }
    public Channel(String title ){
        this.title = title;
    }


    public boolean hasTitle() {
        if(title != null){
            return !title.isEmpty();
        }
        return false;
    }
}
