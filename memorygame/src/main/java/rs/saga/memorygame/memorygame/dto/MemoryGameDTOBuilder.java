package rs.saga.memorygame.memorygame.dto;

public class MemoryGameDTOBuilder {
    private Integer pairCount;
    private PlayerDTO one;
    private PlayerDTO two;

    public static MemoryGameDTOBuilder getInstance() {
        return new MemoryGameDTOBuilder();
    }

    public MemoryGameDTO createMemoryGameDTO() {
        return new MemoryGameDTO(pairCount, one, two);
    }

    public MemoryGameDTOBuilder setOne(PlayerDTO one) {
        this.one = one;
        return this;
    }

    public MemoryGameDTOBuilder setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
        return this;
    }

    public MemoryGameDTOBuilder setTwo(PlayerDTO two) {
        this.two = two;
        return this;
    }


    public MemoryGameDTO game() {
        setPairCount(2);
        setOne(PlayerDTOBuilder.getInstance().ana());
        setTwo(PlayerDTOBuilder.getInstance().manja());
        return createMemoryGameDTO();
    }
}