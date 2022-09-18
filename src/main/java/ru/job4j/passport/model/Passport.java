package ru.job4j.passport.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "passport")
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int serial;
    private int number;
    private String name;
    private LocalDateTime validityDate;

}
