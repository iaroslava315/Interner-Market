package org.skypro.skyshop.exception;

import java.io.IOException;

public class BestResultNotFound extends Exception {
    public String search;

    public BestResultNotFound(String search) {
        super("Не найдены результаты для строки: " + search);
        this.search = search;
    }
}
