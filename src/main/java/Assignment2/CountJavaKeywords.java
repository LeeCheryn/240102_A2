//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240102
//Name: #Cheryn Lee Shueh Yin

package Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class CountJavaKeywords {
    private final File newFile;
    private LinkedList<String> list;
    private int numberOfJavaKeywords = 0;
    private Set<String> javaKeywordSet;
    private Scanner input;
    
    protected final String[] keywordString = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

    public CountJavaKeywords(File newFile) {
        this.newFile = newFile;
    }

    public LinkedList getCountJavaKeywords() throws FileNotFoundException {
        javaKeywordSet = new HashSet<>(Arrays.asList(keywordString)); 
        input = new Scanner(newFile);
        list = new LinkedList<>();
        while (input.hasNext()) {
            String word = input.next();
            if (javaKeywordSet.contains(word)) {
                list.add(word);
                numberOfJavaKeywords++;
            }
        }
        return list;
    }

    public int getNumberOfJavaKeywords() throws FileNotFoundException {
        getCountJavaKeywords();
        return numberOfJavaKeywords;
    }
}
