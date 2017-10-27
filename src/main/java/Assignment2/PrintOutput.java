//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240102
//Name: #Cheryn Lee Shueh Yin

package Assignment2;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PrintOutput {
    public static void main(String[] args) throws WriteException, IOException {
        try {
            String directory = System.getProperty("user.dir");
            directory = directory.replace("\\", "/");
        
            String filePath = "", packageName = "";
            PrintOutput p = new PrintOutput();
       
            try {
                packageName = p.getClass().getPackage().getName(); //to retrieve package name of this class
                packageName = packageName.replace(".","/");
                filePath = directory+"/src/main/java/"+packageName+"/"; //for file that inside a package
            
            }catch (Exception e){
                filePath = directory+"/src/main/java"; //for file that inside default package
            }
            
        final String excelLocation = filePath + "\\FileInfoResults.xls"; //create excel file in the same package
        WritableWorkbook excel = Workbook.createWorkbook(new File(excelLocation));
        WritableSheet sheet1 = excel.createSheet("First Sheet", 0);
        sheet1.mergeCells(1, 1, 2, 1); //merge the cells
        sheet1.mergeCells(1, 3, 2, 3);
        sheet1.mergeCells(5, 5, 6, 5);
        sheet1.setColumnView(3, 10); //set the column length
        sheet1.setColumnView(4, 12);
        
        GetJavaFiles javaFiles = new GetJavaFiles();
        File[] targetFiles = javaFiles.getJavaFiles(filePath);
        
        LinkedList<String> fullJavaKeywords = new LinkedList<>();
        LinkedList<String> listJavaKeywords = new LinkedList<>();
        LinkedList<String> results = new LinkedList<>();
        
        int x = 0;
        for (File file : targetFiles) {
            x++; int row = 6+x; 
            
            String targetFile = filePath + file.getName();
            File inFile = new File(targetFile);
            
            ReadInfo info = new ReadInfo();
            info.GetReadInfo(inFile);
            
            Label labelS = new Label(0, 0, "Semester ");
            sheet1.addCell(labelS);
            Label semester = new Label(1, 0, "" + info.getSemester());
            sheet1.addCell(semester);
            Label labelC = new Label(0, 1, "Course");
            sheet1.addCell(labelC);
            Label course = new Label(1, 1, info.getCourse());
            sheet1.addCell(course);
            Label labelG = new Label(0, 2, "Group");
            sheet1.addCell(labelG);
            Label group = new Label(1, 2, info.getGroup());
            sheet1.addCell(group);
            Label labelT = new Label(0, 3, "Task");
            sheet1.addCell(labelT);
            Label task = new Label(1, 3, info.getTask());
            sheet1.addCell(task);
            Label labelJK = new Label(5, 5, "java keyword");
            sheet1.addCell(labelJK);
            Label labelM = new Label(0, 6, "Matrik");
            sheet1.addCell(labelM);
            Label matric = new Label(0, row, "" + info.getMatricNumber());
            sheet1.addCell(matric);
            
            CountLines countLines = new CountLines();
            countLines.GetCountLines(inFile);
            
            Label labelLOC = new Label(1, 6, "LOC");
            sheet1.addCell(labelLOC);
            Label LOC = new Label(1, row, "" + countLines.getLineOfCodes());
            sheet1.addCell(LOC);
            Label labelB = new Label(2, 6, "Blank");
            sheet1.addCell(labelB);
            Label blank = new Label(2, row, "" + countLines.getBlankLines());
            sheet1.addCell(blank);
            Label labelCM = new Label(3, 6, "Comment");
            sheet1.addCell(labelCM);
            Label comment = new Label(3, row, "" + countLines.getComments());
            sheet1.addCell(comment);
            Label labelALOC = new Label(4, 6, "Actual LOC");
            sheet1.addCell(labelALOC);
            Label actualLOC = new Label(4, row, "" + countLines.getActualLineOfCodes());
            sheet1.addCell(actualLOC);
            
            CountJavaKeywords javaKeywords = new CountJavaKeywords(inFile);
            fullJavaKeywords = javaKeywords.getCountJavaKeywords(); 

            Set<String> unique = new HashSet<>(fullJavaKeywords);

            for (String key : unique) {
                listJavaKeywords.add(key); //store the keywords in a list
                results.add("" + Collections.frequency(fullJavaKeywords, key)); //get the occurance number of a keyword
            }                                                                   //and store it in a list   
            
            String[] listOfJavaKeywords;
            listOfJavaKeywords = listJavaKeywords.toArray(new String[0]); //convert linked list to String type array 

            String[] numOfJavaKeywords;
            numOfJavaKeywords = results.toArray(new String[0]); 
            
            int listOfKeywords = listJavaKeywords.size(); //get the size of the list for looping time
            
            for (int i = 0; i < listOfKeywords; i++) {
                Label labelJKNames = new Label(5 + i, 6, "" + listOfJavaKeywords[i]);
                sheet1.addCell(labelJKNames);
                Label numOfJK = new Label(5 + i, row, "" + numOfJavaKeywords[i]);
                sheet1.addCell(numOfJK);
            }
            listJavaKeywords.clear(); 
            results.clear(); //clear the list once it has finished executing to avoid repetition of results
            
            Label labelTotal = new Label(5+listOfKeywords, 6, "total");
            sheet1.addCell(labelTotal);
            Label total = new Label(5+listOfKeywords, row, ""+countLines.getTotal());
            sheet1.addCell(total);
        } 
        excel.write();
        excel.close();
            
        System.out.println("Completed Printing...\nPlease refer to the excel file named \"File Info Results\" in the current Java Package." );

        }catch (IOException ex) {
            Logger.getLogger(PrintOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

