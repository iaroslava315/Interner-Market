package org.skypro.skyshop.Searchable;

public interface Searchable {

    String getName();

    String searchTerm();

    String searchType();

    default String getStringRepresentation() {
        return "Имя объекта: " + searchTerm() + "\n" + "Тип объекта: " + searchType();
    }

}
