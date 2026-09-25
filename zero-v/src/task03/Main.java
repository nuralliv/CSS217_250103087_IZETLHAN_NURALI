package task03;

public class Main {
    public static void main(String[] args) {
        StudentDirectoryAdapter directory = new StudentDirectoryAdapter(new LegacyStudentDirectory());
        System.out.println("Size: " + directory.size());
        for (int i = 0; i < directory.size(); i++) {
            System.out.println(i + " -> " + directory.get(i));
        }
        try {
            directory.get(directory.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly rejected out-of-bounds index: " + e.getMessage());
        }
    }
}
