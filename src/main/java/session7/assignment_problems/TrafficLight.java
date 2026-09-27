public class TrafficLight {
    private final String id;
    private String currentColor;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = "RED"; // Default starting color
    }

    public void next() {
        if (currentColor.equals("RED")) {
            currentColor = "GREEN";
        } else if (currentColor.equals("GREEN")) {
            currentColor = "YELLOW";
        } else if (currentColor.equals("YELLOW")) {
            currentColor = "RED";
        }
    }

    public String getColor() {
        return currentColor;
    }

    public String getId() {
        return id;
    }
}
