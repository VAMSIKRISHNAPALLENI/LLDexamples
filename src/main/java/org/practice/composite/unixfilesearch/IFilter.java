package org.practice.composite.unixfilesearch;

public interface IFilter {

    boolean isValid(SearchParams params, File file);

}
