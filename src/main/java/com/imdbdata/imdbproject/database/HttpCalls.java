package com.imdbdata.imdbproject.database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.imdbdata.imdbproject.model.Crew;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;


public class HttpCalls {
    private static HttpCalls single_instance = null;
    public int calls;
    private HttpCalls()
    {
        calls = 1;
    }

    public static HttpCalls getInstance() throws IOException
    {
        if (single_instance == null){
            single_instance = new HttpCalls();
        }else{
            single_instance.calls = single_instance.calls+1;
        }
        return single_instance;
    }
}
