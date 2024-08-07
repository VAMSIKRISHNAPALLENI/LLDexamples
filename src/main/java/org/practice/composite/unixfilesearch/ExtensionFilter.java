package org.practice.composite.unixfilesearch;

public class ExtensionFilter implements IFilter {

    @Override
    public boolean isValid(SearchParams params, File file) {
        if (params.extension == null) {
            return true;
        }

        return file.getExtension().equals(params.extension);
    }

}
