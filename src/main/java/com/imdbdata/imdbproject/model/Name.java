package com.imdbdata.imdbproject.model;

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
public class Name {
    @Id
    private String tconst;
    private String primaryName;
    private String birthYear;
    private String deathYear;
    private String[] primaryProfession;
    private String[] knownForTitles;

    public Name(String[] data){
        this.tconst = data[0];
        this.primaryName = data[1];
        this.birthYear = data[2];
        this.deathYear = data[3];
        this.primaryProfession = data[4].split(",");
        this.knownForTitles = data[5].split(",");
    }

}

