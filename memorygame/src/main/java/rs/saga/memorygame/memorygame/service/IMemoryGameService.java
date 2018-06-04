package rs.saga.memorygame.memorygame.service;

import org.springframework.web.bind.annotation.PathVariable;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
public interface IMemoryGameService {
    Long createGame(Integer pairCount, String playerOne, String playerTwo);

    MemoryGameDTO startGame(@PathVariable Long id);

    MemoryGameDTO openPair(MemoryGameDTO memoryGameDTO, String playerName);
}
