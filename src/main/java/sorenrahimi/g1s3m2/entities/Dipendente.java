package sorenrahimi.g1s3m2.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String immagine;

    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Dispositivo> dispositivoList;
}
