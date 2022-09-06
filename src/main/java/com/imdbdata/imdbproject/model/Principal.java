package com.imdbdata.imdbproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Principal {
    @Id
    private String tconst;
    private String ordering;
    private String nconst;
    private String category;
    private String job;
    @Column(columnDefinition="TEXT")
    private String characters;

    public Principal(String[] data){
        this.tconst = data[0];
        this.ordering = data[1];
        this.nconst = data[2];
        this.category = data[3];
        this.job = data[4];
        this.characters = data[5];
    }

}

