package org.skypro.skyshop.searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {


    private Searchable[] products;
    private int count;

    public SearchEngine(int size) {
        products = new Searchable[size];
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
        if (count == products.length) {
            return;
        }
        products[count] = product;
        count++;
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (Searchable element : products) {
            if (element != null && element.searchTerm().contains(searchTerm)) {
                results[foundCount] = element;
                foundCount++;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

}
