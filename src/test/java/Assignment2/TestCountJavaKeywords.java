//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240102
//Name: #Cheryn Lee Shueh Yin

package Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import junit.framework.Assert;
import org.junit.Test;

public class TestCountJavaKeywords {
    
    String directory = System.getProperty("user.dir");
    String testFile = directory + "/src/main/java/Assignment2/MyThread1.java";
    
    @Test
    public void testGetNumberOfJavaKeywords1() throws FileNotFoundException{
        File targetFile = new File(testFile);
        CountJavaKeywords cjk = new CountJavaKeywords(targetFile);
        int numberOfJavaKeywords = cjk.getNumberOfJavaKeywords();
        Assert.assertNotNull(numberOfJavaKeywords);
    }
     
    @Test
    public void testGetNumberOfJavaKeywords2() throws FileNotFoundException{
        File targetFile = new File(testFile);
        CountJavaKeywords cjk = new CountJavaKeywords(targetFile);
        int numberOfJavaKeywords = cjk.getNumberOfJavaKeywords();
        Assert.assertEquals(9, numberOfJavaKeywords);
    }
     
    @Test
    public void testGetCountJavaKeywords1() throws FileNotFoundException{
        File targetFile = new File(testFile);
        CountJavaKeywords cjk = new CountJavaKeywords(targetFile);
        LinkedList<String> javakey = cjk.getCountJavaKeywords();
        Assert.assertNotNull(javakey);
    }
    
    @Test
    public void testGetCountJavaKeywords2() throws FileNotFoundException{
        File targetFile = new File(testFile);
        CountJavaKeywords cjk = new CountJavaKeywords(targetFile);
        LinkedList<String> javakey = cjk.getCountJavaKeywords();
        Assert.assertEquals(9, javakey.size());
    }
}
