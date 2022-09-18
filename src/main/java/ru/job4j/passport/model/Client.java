package ru.job4j.passport.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "client")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
}
