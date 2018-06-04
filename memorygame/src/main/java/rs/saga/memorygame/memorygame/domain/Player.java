package rs.saga.memorygame.memorygame.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@Table(name = "T_PLAYER")
@Entity
public class Player extends User {

    @Transient
    private Integer pairCount;

    public Player() {
        pairCount = 0;
    }

    public Integer getPairCount() {
        return pairCount;
    }

    public void setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
    }
}
