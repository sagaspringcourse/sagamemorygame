package rs.saga.memorygame.memorygame.service;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import rs.saga.memorygame.memorygame.dao.PlayerRepository;
import rs.saga.memorygame.memorygame.domain.Player;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemoryGameServiceImplIT {

    @Autowired
    private IMemoryGameService memoryGameService;

    @Autowired
    private PlayerRepository playerRepository;

    @Before
    public void before() {
        Player ana = new Player();
        ana.setFirstName("Ana");
        ana.setLastName("Dimitrijevic");
        playerRepository.save(ana);

        Player manja = new Player();
        manja.setFirstName("Manja");
        manja.setLastName("Miljevic");
        playerRepository.save(manja);
    }

    @Test
    public void createGame() {
        Long id = memoryGameService.createGame(9, "Ana", "Manja");

        assertThat(id, Matchers.notNullValue());
    }

    @Test
    public void startGame() {
        // prepare
        Long id = memoryGameService.createGame(9, "Ana", "Manja");

        // test
        MemoryGameDTO memGame = memoryGameService.startGame(id);
        assertThat(memGame.getOne().getPlayerName(),is("Ana"));
        assertThat(memGame.getTwo().getPlayerName(),is("Manja"));

    }

    @Test
    public void openPair() {
        MemoryGameDTO game = MemoryGameDTOBuilder.getInstance().game();
        MemoryGameDTO gameDTO = memoryGameService.openPair(game, "Manja");

        assertThat(gameDTO.getTwo().getPairCount(), is(1));
    }


}