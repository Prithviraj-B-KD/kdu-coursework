package backend.handson.q1;

import backend.handson.LogBack;

import static backend.handson.q1.StudentUtil.calculateGPA;


public class Main {
    public static void main (String[] args){
        try {
            int[] studentIdList1 = {1001, 1002};
            char[][] studentsGrades1 = {{'A', 'A', 'A', 'B'}};
            calculateGPA(studentIdList1, studentsGrades1);
        } catch (IllegalArgumentException | MissingGradeException exception) {
            String errorMessage = String.format("IllegalArgumentException caught: %s",exception.getMessage());
            LogBack.outputLogger(errorMessage,"ERROR");
        }
        try {
            int[] studentIdList1 = {1001};
            char[][] studentsGrades2 = { {'A', ' ', 'B'} };
            calculateGPA(studentIdList1, studentsGrades2);
        } catch (MissingGradeException exception) {
            String formattedMessage = String.format("Missing grade for student: %d",exception.getStudentId());
            throw new InvalidDataException(formattedMessage, exception);
        }

    }


        // Test MissingGradeException for missing grade



}
