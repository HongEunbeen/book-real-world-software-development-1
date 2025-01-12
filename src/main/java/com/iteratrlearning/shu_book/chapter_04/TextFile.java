package com.iteratrlearning.shu_book.chapter_04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    TextFile(Map<String, String> attributes, List<String> lines){
        this.attributes = attributes;
        this.lines = lines;
    }

    public TextFile(File file) throws IOException {
        this.attributes = new HashMap<>();
        this.lines = Files.readAllLines(file.toPath());
    }

    void addLineSuffix(final String prefix, final String attributeName){
        for(final String line:lines){
            if(line.startsWith(prefix)){
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }

    int addLines(final int start, final Predicate<String> isEnd, final String attributeName){
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for(lineNumber = start; lineNumber < lines.size(); lineNumber++){
            final String line= lines.get(lineNumber);
            if(isEnd.test(line)){
                break;
            }

            accumulator.append(line);
            accumulator.append("\n");
        }
        attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
