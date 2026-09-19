class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = parts[1].charAt(0) + ".";
    }

    public String getNickname() {
        return firstName + " " + lastInitial;
    }
}

public class Main {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("getNickname() -> \"" + tag.getNickname() + "\"");
    }
}
