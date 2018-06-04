package rs.saga.memorygame.memorygame.dto;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
public class MemoryGameDTO {

    private Integer pairCount;

    private PlayerDTO one;
    private PlayerDTO two;

    public MemoryGameDTO() {
    }

    public MemoryGameDTO(Integer pairCount, PlayerDTO one, PlayerDTO two) {
        this.pairCount = pairCount;
        this.one = one;
        this.two = two;
    }

    public Integer getPairCount() {
        return pairCount;
    }

    public void setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
    }

    public PlayerDTO getOne() {
        return one;
    }

    public void setOne(PlayerDTO one) {
        this.one = one;
    }

    public PlayerDTO getTwo() {
        return two;
    }

    public void setTwo(PlayerDTO two) {
        this.two = two;
    }

}
