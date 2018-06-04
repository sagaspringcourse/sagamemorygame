package rs.saga.memorygame.memorygame.service;

import org.springframework.stereotype.Service;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;
import rs.saga.memorygame.memorygame.dto.PlayerDTO;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@Service
public class MemoryGameServiceImpl implements IMemoryGameService {
    @Override
    public Long createGame(Integer pairCount, String playerOne, String playerTwo) {
        return 1l;
    }

    @Override
    public MemoryGameDTO startGame(Long id) {
        MemoryGameDTO game = MemoryGameDTOBuilder.getInstance().game();
        game.setStatus("info");
        game.setMessage("Game started. " + game.getOne().getPlayerName() + " VS. " + game.getTwo().getPlayerName());
        return game;
    }

    @Override
    public MemoryGameDTO openPair(MemoryGameDTO game, String playerName) {

        PlayerDTO firstPlayer = game.getOne();
        PlayerDTO secondPlayer = game.getTwo();

        PlayerDTO player = firstPlayer.getPlayerName().equals(playerName) ? firstPlayer : secondPlayer;
        player.setPairCount(player.getPairCount() + 1);

        if (firstPlayer.getPairCount() + secondPlayer.getPairCount() == game.getPairCount()) {
            String winner = (firstPlayer.getPairCount() > secondPlayer.getPairCount() ? firstPlayer.getPlayerName() : secondPlayer.getPlayerName()) + " wins!";
            game.setStatus("success");
            game.setMessage("End of the game!"  + winner);
        } else {
            game.setStatus("success");
            game.setMessage(playerName + " bravo! Play again");
        }
        return game;
    }
}
