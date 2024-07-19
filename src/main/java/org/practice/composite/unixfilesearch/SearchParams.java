package org.practice.composite.unixfilesearch;

import lombok.Data;
@Data
public class SearchParams {
    String extension;
    Integer minSize;
    Integer maxSize;
    String name;
}
