//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240102
//Name: #Cheryn Lee Shueh Yin

package Assignment2;

import java.io.File;
import java.io.FilenameFilter;

public class GetJavaFiles {
    
    public File[] getJavaFiles(String filePath){
       
        File folder = new File(filePath);
        
        FilenameFilter javaFileFilter = new FilenameFilter()
        {    
            @Override
            public boolean accept(File directory, String name)
            {
                return (!name.equals("PrintOutput.java"))&&(!name.equals("CountLines.java"))
                        &&(!name.equals("CountJavaKeywords.java"))&&(!name.equals("ReadInfo.java"))
                        &&(!name.equals("GetJavaFiles.java"))&&(name.endsWith(".java"));
            }
        };
         
        File[] files = folder.listFiles(javaFileFilter);
        return files;
    }
}
