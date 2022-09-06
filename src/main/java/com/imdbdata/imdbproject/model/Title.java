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
public class Title {
    @Id
    private String tconst;
    private String titleType;
    private String primaryTitle;
    @Column(columnDefinition="TEXT")
    private String originalTitle;
    private String isAdult;
    private String startYear;
    private String endYear;
    private int runtimeMinutes;
    @Column(columnDefinition="TEXT")
    private String genres;

    public Title(String[] data){
        this.tconst = data[0];
        this.titleType = data[1];
        this.primaryTitle = data[2];
        this.originalTitle = data[3];
        this.isAdult = data[4];
        this.startYear = data[5];
        this.endYear = data[6];
        try{this.runtimeMinutes=Integer.parseInt(data[7]);}catch(Exception e){this.runtimeMinutes=0;};
        this.genres = data[8];
    }

}

