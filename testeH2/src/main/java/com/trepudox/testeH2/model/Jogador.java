package com.trepudox.testeH2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_jogador")
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer overall;

    private Integer pace;

    private Integer passing;

    private Integer shooting;

    private Integer dribbling;

}
