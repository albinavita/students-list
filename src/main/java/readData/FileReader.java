package readData;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReader {
    private static final String UNIVER = "Университеты";
    private static final String STUDENT = "Студенты";

    private FileReader(){
        System.out.println("Вызов приватного конструктора");
    }

    public static List<University> readSheetUniversity(Workbook book) {
        List<University> universities = new ArrayList<>();

        Sheet sheet = book.getSheet(UNIVER);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row current = rows.next();
            University university = new University();
            university.setId(current.getCell(0).getStringCellValue());
            university.setFullName(current.getCell(1).getStringCellValue());
            university.setShortName(current.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)current.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(current.getCell(4).getStringCellValue()));

            universities.add(university);
        }
        return universities;
    }

    public static List<Student> readSheetStudent(Workbook book) {
        List<Student> studenties = new ArrayList<>();

        Sheet sheet = book.getSheet(STUDENT);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row current = rows.next();
            Student student = new Student();
            student.setFullName(current.getCell(0).getStringCellValue());
            student.setUniversityId(current.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) current.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) current.getCell(3).getNumericCellValue());

            studenties.add(student);
        }
        return studenties;
    }

}
