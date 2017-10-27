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
import junit.framework.Assert;
import org.junit.Test;

public class TestCountLines {
    private int expectedLineOfCodes;
    private int expectedBlankLines;
    private int expectedComments;
    private int expectedActualLineOfCodes;
    private int expectedTotal;
    String line;
    private CountJavaKeywords javaKeywords;
    
    String directory = System.getProperty("user.dir");
    String testFile = directory + "/src/main/java/Assignment2/MyThread1.java";
    
    public void fileForTest(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(testFile));
        javaKeywords = new CountJavaKeywords(file);
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                expectedBlankLines++;
            }
            if (line.contains("//")) {
                expectedComments++;
            } else if (line.contains("/*")) {
                expectedComments++;
                while (!line.contains("*/") && !(line = reader.readLine()).contains("*/")) {
                }
            }
            expectedLineOfCodes++;
        }
        expectedActualLineOfCodes = expectedLineOfCodes - expectedBlankLines - expectedComments;
        expectedTotal = javaKeywords.getNumberOfJavaKeywords() + expectedActualLineOfCodes;
    }
    
    @Test
    public void testGetLineOfCodes(){
        CountLines cl = new CountLines();
        int lineOfCodes = cl.getLineOfCodes();
        Assert.assertEquals(expectedLineOfCodes, lineOfCodes);
    }
    
    @Test
    public void testGetBlankLines(){
        CountLines cl = new CountLines();
        int blankLines = cl.getBlankLines();
        Assert.assertEquals(expectedBlankLines, blankLines);
    }
    
    @Test
    public void testGetComments(){
        CountLines cl = new CountLines();
        int comments = cl.getComments();
        Assert.assertEquals(expectedComments, comments);
    }
    
    @Test
    public void testGetActualLineOfCodes(){
        CountLines cl = new CountLines();
        int actualLineOfCodes = cl.getActualLineOfCodes();
        Assert.assertEquals(expectedActualLineOfCodes, actualLineOfCodes);
    }
    
    @Test
    public void testGetTotal(){
        CountLines cl = new CountLines();
        int total = cl.getTotal();
        Assert.assertEquals(expectedTotal, total);
    }
    
    @Test
    public void testGetCountLines() throws IOException{
        File targetFile = new File(testFile);
        CountLines cl = new CountLines();
        cl.GetCountLines(targetFile);
    }
}
