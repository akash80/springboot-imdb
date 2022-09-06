package com.imdbdata.imdbproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Rating {
    @Id
    private String tconst;
    private String averageRating;
    private String numVotes;

    public Rating(String[] data){
        this.tconst = data[0];
        this.averageRating = data[1];
        this.numVotes = data[2];
    }
}
