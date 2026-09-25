package task16;

public class Main {
    public static void main(String[] args) {
        LocalStorageBlobAdapter storage = new LocalStorageBlobAdapter(new LocalDiskFileSystem());
        boolean result = storage.uploadBlob("my-bucket/", "/folder/file.txt", new byte[]{1, 2, 3, 4});
        System.out.println("Upload success: " + result);
    }
}
