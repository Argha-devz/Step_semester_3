import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        int[] sampleBooks = {30, 10, 40, 20};
        shelf(sampleBooks);

        System.out.println();

        int[] customBooks = {55, 12, 34, 7, 23};
        shelf(customBooks);
    }
}