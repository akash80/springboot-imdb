package com.imdbdata.imdbproject.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.imdbdata.imdbproject.model.Name;
import static com.imdbdata.imdbproject.config.Configuration.BASE_PATH;

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
            // readFile("name.basics.tsv/data.tsv").lines().skip(1).forEach(a -> {
            //     String[] data = a.split("\\t");
                // Name name = new Name(data);
                // single_instance.names.put(name.getTconst(), name);
            //  });
            FileInputStream inputStream = null;
            Scanner sc = null;
            try {
                inputStream = new FileInputStream(BASE_PATH+"name.basics.tsv/data.tsv");
                sc = new Scanner(inputStream, "UTF-8");
                while(sc.hasNext()){
                    String line = sc.nextLine();
                    String[] data = line.split("\\t");
                    Name name = new Name(data);
                    single_instance.names.put(name.getTconst(), name);
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            }
        }
        return single_instance;
    }
}
