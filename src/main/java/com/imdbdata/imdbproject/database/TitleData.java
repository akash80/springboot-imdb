package com.imdbdata.imdbproject.database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.imdbdata.imdbproject.model.Title;
import com.imdbdata.imdbproject.model.Rating;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;


public class TitleData {
    private static TitleData single_instance = null;
    public Map<String, Title> titles;
    private TitleData()
    {
        titles = new HashMap<>();
    }
    public static TitleData getInstance() throws IOException
    {
        if (single_instance == null){
            single_instance = new TitleData();
            readFile("title.basics.tsv/data.tsv").lines().skip(1).forEach(a -> {
                String[] data = a.split("\\t");
                Title title = new Title(data);
                single_instance.titles.put(title.getTconst(), title);
             });
        }
        return single_instance;
    }
}
