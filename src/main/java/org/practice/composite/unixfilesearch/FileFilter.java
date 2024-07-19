package org.practice.composite.unixfilesearch;

import java.util.*;

public class FileFilter {
    private final List<IFilter> filters = new ArrayList<>();

    public FileFilter() {
        filters.add(new NameFilter());
        filters.add(new ExtensionFilter());
    }

    public boolean isValid(SearchParams params, File file) {
        for (IFilter filter : filters) {
            if (!filter.isValid(params, file)) {
                return false;
            }
        }

        return true;
    }

}









//public class MinSizeFilter implements IFilter {
//
//    @Override
//    public boolean isValid(SearchParams params, File file) {
//        if (params.minSize == null) {
//            return true;
//        }
//
//        return file.getSize() >= params.minSize;
//    }
//
//}
//
//public class MaxSizeFilter implements IFilter {
//
//    @Override
//    public boolean isValid(SearchParams params, File file) {
//        if (params.maxSize == null) {
//            return true;
//        }
//
//        return file.getSize() <= params.maxSize;
//    }
//
//}
//
