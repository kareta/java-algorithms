package kareta.lab5;

/**
 * Created by vitya on 12.04.17.
 */
public class StudentsArray {
    private Student[] students;
    private int offset;

    public StudentsArray(int size) {
        students = new Student[size];
    }

    public boolean add(Student addedStudent) {
        if (offset == students.length) {
            return false;
        }

        if (offset == 0) {
            students[offset] = addedStudent;
            offset++;
            return true;
        }

        for (Student student : students) {
            if (student == null) {
                continue;
            }

            if (student.getAvarageGrade() == addedStudent.getAvarageGrade()) {
                return false;
            }
        }

        students[offset] = addedStudent;
        offset++;
        return true;
    }

    public Student get(int index) {
        if (index < 0 || index >= students.length) {
            return null;
        }

        return students[index];
    }

    public Student remove(int index) {
        if (index < 0 || index >= students.length) {
            return null;
        }

        Student removedStudent = students[index];

        for (int i = index; i < students.length - 1; i++) {
            students[i] = students[i + 1];
        }

        students[offset] = null;
        offset--;

        return students[index];
    }

    public void sort() {
        for (int i = 0; i < students.length - 1; i++) {
            int index = i;

            if (students[i] == null) {
                continue;
            }

            for (int j = i + 1; j < students.length - 1; j++) {
                if (students[j] == null) {
                    continue;
                }

                if (students[j].getAvarageGrade() < students[index].getAvarageGrade()) {
                    index = j;
                }
            }

            Student smallerStudent = students[index];
            students[index] = students[i];
            students[i] = smallerStudent;
        }
    }


    public static boolean isFound(double averageGrade, double lowAverageGrade, double highAverageGrade) {
        return !(lowAverageGrade < averageGrade && highAverageGrade > averageGrade);
    }

    public static int calculateMid(double averageGrade, Student[] sortedArray, int low, int high) {
        return (int) (
                low
                + ((averageGrade - sortedArray[low].getAvarageGrade()) * (high - low))
                / (sortedArray[high].getAvarageGrade() - sortedArray[low].getAvarageGrade())
        );

    }

    public Student interpolationSearch(double averageGrade) {
        int low = 0;
        int high = offset - 1;

        boolean found = isFound(
                averageGrade, students[low].getAvarageGrade(),
                students[high].getAvarageGrade()
        );

        while (!found) {
            int mid = calculateMid(averageGrade, students, low, high);

            if (students[mid] == null) {
                continue;
            }

            if (students[mid].getAvarageGrade() < averageGrade) {
                low = mid + 1;
            } else if (students[mid].getAvarageGrade() > averageGrade) {
                high = mid - 1;
            } else {
                return students[mid];
            }

            found = isFound(
                    averageGrade, students[low].getAvarageGrade(),
                    students[high].getAvarageGrade()
            );
        }

        if (students[low].getAvarageGrade() == averageGrade) {
            return students[low];
        } else if (students[high].getAvarageGrade() == averageGrade) {
            return students[high];
        } else {
            return null;
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Student student : students) {
            builder.append(student).append("\n");
        }
        return builder.toString();
    }
}
