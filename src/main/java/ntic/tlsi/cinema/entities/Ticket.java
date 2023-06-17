package ntic.tlsi.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String nomClient;
    private double prix ;
    @Column(unique = false,nullable = true)
    private Integer codePayment;
    private boolean reserve;
    @ManyToOne
    private Place place;
    @ManyToOne

    private Projection projection;

}
