package com.imdbdata.imdbproject.database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.imdbdata.imdbproject.model.Name;
import com.imdbdata.imdbproject.model.Rating;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;


public class NameData {
    private static NameData single_instance = null;
    public Map<String, Name> names;
    private NameData()
    {
        names = new HashMap<>();
    }
    public static NameData getInstance() throws IOException
    {
        if (single_instance == null){
            single_instance = new NameData();
            readFile("name.basics.tsv/data.tsv").lines().skip(1).forEach(a -> {
                String[] data = a.split("\\t");
                Name name = new Name(data);
                single_instance.names.put(name.getTconst(), name);
             });
        }
        return single_instance;
    }
}
