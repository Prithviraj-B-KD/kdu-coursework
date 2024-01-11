package backend.handson.q1;

public class StudentUtil {
    private StudentUtil() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * Ensures that the lengths of the student ID list and grades list are equal.
     *
     * @param studentIdList The list of student IDs.
     * @param studentsGrades The list of student grades.
     * @throws IllegalArgumentException if the lengths of the two lists are not equal.
     */
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {

        if (studentIdList.length != studentsGrades.length) {
            String formattedMessage = String.format("studentIdList & studentsGrades are out-of-sync. studentIdList.length: %d, studentsGrades.length: %d",
                                studentIdList.length, studentsGrades.length);
            throw new IllegalArgumentException(formattedMessage);
        }

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;

            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    // student is yet to receive a grade
                    // Your code: throw checked exception MissingGradeException with student ID
                    throw new MissingGradeException(studentIdList[i]);
                }
            }

            gpaList[i] = gpa/studentsGrades[i].length;
        }

        return gpaList;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return new int[0];
        }

        double[] gpaList = new double[studentIdList.length];
        // Your code: catch MissingGradeException and re-throw runtime exception InvalidDataException initialized with the cause MissingGradeException
        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e){
            String formattedMessage = String.format("Missing grade for student: %d",e.getStudentId());
            throw new InvalidDataException(formattedMessage, e);
        }


        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }


}
