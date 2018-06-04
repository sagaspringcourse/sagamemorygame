package rs.saga.memorygame.memorygame.dto;

public class PlayerDTOBuilder {
    private Integer pairCount = 0;
    private String playerName;

    public PlayerDTO createPlayerDTO() {
        return new PlayerDTO(pairCount, playerName);
    }

    public PlayerDTOBuilder setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
        return this;
    }

    public PlayerDTOBuilder setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public static PlayerDTOBuilder getInstance() {
        return new PlayerDTOBuilder();
    }

    public PlayerDTO ana() {
        return this.setPlayerName("Ana").createPlayerDTO();
    }

    public PlayerDTO manja() {
        return this.setPlayerName("Manja").createPlayerDTO();
    }
}