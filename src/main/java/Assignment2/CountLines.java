//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240102
//Name: #Cheryn Lee Shueh Yin

package Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountLines {
    private int lineOfCodes;
    private int blankLines;
    private int comments;
    private int actualLineOfCodes;
    private int total;
    String line;
    private CountJavaKeywords javaKeywords;
    
    public void GetCountLines(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        javaKeywords = new CountJavaKeywords(file);
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                blankLines++;
            }
            if (line.contains("//")) {
                comments++;
            } else if (line.contains("/*")) {
                comments++;
                while (!line.contains("*/") && !(line = reader.readLine()).contains("*/")) {
                }
            }
            lineOfCodes++;
        }
        actualLineOfCodes = lineOfCodes - blankLines - comments;
        total = javaKeywords.getNumberOfJavaKeywords() + actualLineOfCodes;
    }

    public int getLineOfCodes() {
        return lineOfCodes;
    }

    public int getBlankLines() {
        return blankLines;
    }

    public int getComments() {
        return comments;
    }

    public int getActualLineOfCodes() {
        return actualLineOfCodes;
    }

    public int getTotal() {
        return total;
    }
}

