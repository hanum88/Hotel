public class Room {
    private int roomNr;
    private int countOfBeds;
    private int pricePerNight;
    private boolean hasBalcony;
    private boolean seaView;

    public Room(int roomNr, boolean seaView, boolean hasBalcony, int pricePersonNight, int countOfBeds) {
        this.roomNr = roomNr;
        this.seaView = seaView;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePersonNight;
        this.countOfBeds = countOfBeds;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public int getRoomPrice() {
        return pricePerNight;
    }

    public String hasSeaView() {
        if (this.seaView == true) {
            return "ano";
        } else {
            return "ne";
        }
    }
}
