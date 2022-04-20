package dataProviders;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.SearchTerm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String searchTermsFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "SearchTerm.json";
    private List<SearchTerm> searchTerms;

    public JsonDataReader(){
        searchTerms = getSearchData();
    }

    private List<SearchTerm> getSearchData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(searchTermsFilePath));
            SearchTerm[] searchTerms = gson.fromJson(bufferReader, SearchTerm[].class);
            return Arrays.asList(searchTerms);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + searchTermsFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final SearchTerm getSearchTermByName(String searchTerm){
        return searchTerms.stream().filter(x -> x.searchTerm.equalsIgnoreCase(searchTerm)).findAny().get();
    }
}
