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
    public Long createGame(Integer pairCount, String playerOne, String playerTwo) {
        return 1l;   }

    @Override
    public MemoryGameDTO startGame(Long id) {

        MemoryGameDTO game = MemoryGameDTOBuilder.getInstance().game();
        game.setStatus("info");
        game.setMessage("Game started. " + game.getOne().getPlayerName() + " VS. " + game.getTwo().getPlayerName());
        return game;
    }

    @Override
    public MemoryGameDTO openPair(MemoryGameDTO memoryGameDTO, String playerName) {
        return MemoryGameDTOBuilder.getInstance().game();
    }
}
