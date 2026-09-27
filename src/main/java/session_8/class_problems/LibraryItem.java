import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getLoanPeriod();

    public String calculateDueDate(String currentDateStr) {
        LocalDate currentDate = LocalDate.parse(currentDateStr);
        LocalDate dueDate = currentDate.plusDays(getLoanPeriod());
        return dueDate.toString();
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getLoanPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getLoanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getLoanPeriod() {
        return 3;
    }
}