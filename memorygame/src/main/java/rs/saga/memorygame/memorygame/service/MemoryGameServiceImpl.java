package rs.saga.memorygame.memorygame.service;

import org.springframework.stereotype.Service;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@Service
public class MemoryGameServiceImpl implements IMemoryGameService {
    @Override
    public MemoryGameDTO createGame(Integer pairCount, String playerOne, String playerTwo) {
        return MemoryGameDTOBuilder.getInstance().game();    }

    @Override
    public MemoryGameDTO startGame(Long id) {

        return MemoryGameDTOBuilder.getInstance().game();
    }

    @Override
    public MemoryGameDTO openPair(MemoryGameDTO memoryGameDTO, String playerName) {
        return MemoryGameDTOBuilder.getInstance().game();
    }
}
