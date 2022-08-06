package com.imdbdata.imdbproject.database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.imdbdata.imdbproject.model.Principal;
import com.imdbdata.imdbproject.model.Rating;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;


public class PrincipalData {
    private static PrincipalData single_instance = null;
    public Map<String, Principal> principals;
    private PrincipalData()
    {
        principals = new HashMap<>();
    }
    public static PrincipalData getInstance() throws IOException
    {
        if (single_instance == null){
            single_instance = new PrincipalData();
            readFile("title.principals.tsv/data.tsv").lines().skip(1).forEach(a -> {
                String[] data = a.split("\\t");
                Principal principal = new Principal(data);
                single_instance.principals.put(principal.getTconst(), principal);
             });
        }
        return single_instance;
    }
}
