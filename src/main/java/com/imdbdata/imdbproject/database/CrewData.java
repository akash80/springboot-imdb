package com.imdbdata.imdbproject.database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.imdbdata.imdbproject.model.Crew;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;


public class CrewData {
    private static CrewData single_instance = null;
    public Map<String, Crew> crews;
    private CrewData()
    {
        crews = new HashMap<>();
    }
    public static CrewData getInstance() throws IOException
    {
        if (single_instance == null){
            single_instance = new CrewData();
            readFile("title.crew.tsv/data.tsv").lines().skip(1).forEach(a -> {
                String[] data = a.split("\\t");
                Crew crew = new Crew(data);
                single_instance.crews.put(crew.getTconst(), crew);
             });
        }
        return single_instance;
    }
}
