public class Room {
    private int roomNr;
    private int countOfBeds;
    private int pricePersonNight;
    private boolean hasBalcony;
    private boolean seaView;

    public Room(int roomNr, boolean seaView, boolean hasBalcony, int pricePersonNight, int countOfBeds) {
        this.roomNr = roomNr;
        this.seaView = seaView;
        this.hasBalcony = hasBalcony;
        this.pricePersonNight = pricePersonNight;
        this.countOfBeds = countOfBeds;
    }

    public int getRoomNr() {
        return roomNr;
    }
}
