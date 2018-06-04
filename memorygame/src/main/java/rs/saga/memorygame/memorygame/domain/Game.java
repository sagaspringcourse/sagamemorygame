package rs.saga.memorygame.memorygame.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@Table(name = "T_GAME")
public class Game  extends IdEntity{

    @Column(name = "NAME")
    private String name;

    public Game() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
