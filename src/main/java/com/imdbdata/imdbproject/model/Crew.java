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
public class Crew {
    @Id
    private String tconst;
    @Column(columnDefinition="TEXT")
    private String directors;
    @Column(columnDefinition="TEXT")
    private String writers;

    public Crew(String[] data){
        this.tconst = data[0];
        this.directors = data[1];
        this.writers = data[2];
    }

}

