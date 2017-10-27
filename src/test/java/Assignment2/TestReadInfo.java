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

public class TestReadInfo {
    private String expectedSemester;
    private String expectedCourse;
    private int expectedMatricNumber;
    private String expectedGroup;
    private String expectedTask;
    String line;
    
    String directory = System.getProperty("user.dir");
    String testFile = directory + "/src/main/java/Assignment2/MyThread1.java";
    
    public void fileForTest(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(testFile));
        while ((line = reader.readLine()) != null) {
            if (line.contains("Semester")) {
                expectedSemester = line.substring(line.lastIndexOf("#") + 1);
            } else if (line.contains("Course")) {
                expectedCourse = line.substring(line.lastIndexOf("#") + 1);
            } else if (line.contains("Matrik")) {
                expectedMatricNumber = Integer.parseInt(line.substring(line.lastIndexOf("#") + 1));
            } else if (line.contains("Group")) {
                expectedGroup = line.substring(line.lastIndexOf("#") + 1);
            } else if (line.contains("Task")) {
                expectedTask = line.substring(line.lastIndexOf("#") + 1);
            }
        }
    }
        
    @Test
    public void testGetSemester(){
        ReadInfo ri = new ReadInfo();
        String semester = ri.getSemester();
        Assert.assertEquals(expectedSemester, semester);
    }
    
    @Test
    public void testGetCourse(){
        ReadInfo ri = new ReadInfo();
        String course = ri.getCourse();
        Assert.assertEquals(expectedCourse, course);
    }
    
    @Test
    public void testGetMatricNumber(){
        ReadInfo ri = new ReadInfo();
        int matricNumber = ri.getMatricNumber();
        Assert.assertEquals(expectedMatricNumber, matricNumber);
    }
    
    @Test
    public void testGetGroup(){
        ReadInfo ri = new ReadInfo();
        String group = ri.getGroup();
        Assert.assertEquals(expectedGroup, group);
    }
    
    @Test
    public void testGetTask(){
        ReadInfo ri = new ReadInfo();
        String task = ri.getTask();
        Assert.assertEquals(expectedTask, task);
    }
    
    @Test
    public void testGetReadInfo() throws IOException{
        File targetFile = new File(testFile);
        ReadInfo ri = new ReadInfo();
        ri.GetReadInfo(targetFile);
    }
}
