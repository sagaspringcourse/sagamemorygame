package rs.saga.memorygame.memorygame.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@Table(name = "T_MEMORY_GAME")
@Entity
public class MemoryGame extends Game {

    @Column(name = "PAIR_COUNT")
    private Integer pairCount;

    @OneToOne(cascade = CascadeType.ALL)
    private Player one;

    @OneToOne(cascade = CascadeType.ALL)
    private Player two;

    public MemoryGame() {
        setName("MEMORY GAME");
    }

    public Integer getPairCount() {
        return pairCount;
    }

    public void setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
    }

    public Player getOne() {
        return one;
    }

    public void setOne(Player one) {
        this.one = one;
    }

    public Player getTwo() {
        return two;
    }

    public void setTwo(Player two) {
        this.two = two;
    }
}
