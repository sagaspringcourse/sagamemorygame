package rs.saga.memorygame.memorygame.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.saga.memorygame.memorygame.domain.MemoryGame;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
public interface MemoryGameRepository extends JpaRepository<MemoryGame, Long> {
}
