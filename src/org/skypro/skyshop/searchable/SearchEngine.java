package org.skypro.skyshop.searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    LinkedList<Searchable> products;
    private int count;

    public SearchEngine() {
        products = new LinkedList<>();
        count = 0;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestResult = null;
        for (Searchable element : products) {
            if (element != null) {
                String term = element.searchTerm();
                int count = 0;
                int index = 0;
                int indexSubstring = term.indexOf(search, index);
                while (indexSubstring != -1) {
                    count++;
                    index = indexSubstring + search.length();
                    indexSubstring = term.indexOf(search, index);
                }
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = element;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }

    public void add(Searchable product) {
        products.add(product);
    }

    public Map<String, Searchable> search(String searchTerm) {
        TreeMap<String, Searchable> results = new TreeMap<>();
        for (Searchable element : products) {
            if (element != null && element.searchTerm().contains(searchTerm)) {
                results.put(element.getName(), element);
            }
        }
        return results;
    }



}
