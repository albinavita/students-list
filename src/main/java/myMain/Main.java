package myMain;

import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import readData.FileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) {
        try (FileInputStream stream = new FileInputStream(FILE_NAME)) {
            Workbook book = new XSSFWorkbook(stream);

            List<Student> studenties = FileReader.readSheetStudent(book);
            studenties.forEach(System.out::println);
            List<University> universities = FileReader.readSheetUniversity(book);
            universities.forEach(System.out::println);

            book.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
