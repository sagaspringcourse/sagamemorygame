package rs.saga.memorygame.memorygame.dto;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
public class PlayerDTO {

    private Integer pairCount;
    private String playerName;

    public PlayerDTO() {
    }

    public PlayerDTO(Integer pairCount, String playerName) {
        this.pairCount = pairCount;
        this.playerName = playerName;
    }

    public Integer getPairCount() {
        return pairCount;
    }

    public void setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
