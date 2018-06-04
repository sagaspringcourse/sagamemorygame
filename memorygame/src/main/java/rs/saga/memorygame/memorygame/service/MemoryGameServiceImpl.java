package rs.saga.memorygame.memorygame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.saga.memorygame.memorygame.dao.MemoryGameRepository;
import rs.saga.memorygame.memorygame.dao.PlayerRepository;
import rs.saga.memorygame.memorygame.domain.MemoryGame;
import rs.saga.memorygame.memorygame.domain.Player;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;
import rs.saga.memorygame.memorygame.dto.PlayerDTO;
import rs.saga.memorygame.memorygame.dto.PlayerDTOBuilder;

import java.util.Optional;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@Service
@Transactional
public class MemoryGameServiceImpl implements IMemoryGameService {

    private final MemoryGameRepository memoryGameRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public MemoryGameServiceImpl(MemoryGameRepository memoryGameRepository, PlayerRepository playerRepository) {
        this.memoryGameRepository = memoryGameRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Long createGame(Integer pairCount, String playerOne, String playerTwo) {
        Player one = playerRepository.findByFirstName(playerOne);
        Player two = playerRepository.findByFirstName(playerTwo);

        MemoryGame game  = new MemoryGame();
        game.setName("Memory Game");
        game.setOne(one);
        game.setTwo(two);
        game.setPairCount(pairCount);
        game = memoryGameRepository.save(game);

        return game.getId();
    }

    @Override
    public MemoryGameDTO startGame(Long id) {
        Optional<MemoryGame> oGame = memoryGameRepository.findById(id);
        MemoryGame game = oGame.get();

        PlayerDTO first = PlayerDTOBuilder.getInstance().setPlayerName(game.getOne().getFirstName()).createPlayerDTO();
        PlayerDTO second = PlayerDTOBuilder.getInstance().setPlayerName(game.getTwo().getFirstName()).createPlayerDTO();
        MemoryGameDTO memoryGameDTO = MemoryGameDTOBuilder.getInstance().setOne(first).setTwo(second).setPairCount(game.getPairCount()).createMemoryGameDTO();


        memoryGameDTO.setStatus("info");
        memoryGameDTO.setMessage("Game started. " + memoryGameDTO.getOne().getPlayerName() + " VS. " + memoryGameDTO.getTwo().getPlayerName());
        return memoryGameDTO;
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
