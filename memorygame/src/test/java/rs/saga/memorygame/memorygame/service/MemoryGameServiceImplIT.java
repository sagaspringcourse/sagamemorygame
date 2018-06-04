package rs.saga.memorygame.memorygame.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
public class MemoryGameServiceImplIT {

    @Autowired
    private IMemoryGameService memoryGameService;

    @Test
    public void createGame() {
    }

    @Test
    public void startGame() {
    }

    @Test
    public void openPair() {
        MemoryGameDTO game = MemoryGameDTOBuilder.getInstance().game();
        MemoryGameDTO gameDTO = memoryGameService.openPair(game, "Manja");

        assertThat(gameDTO.getTwo().getPairCount(), is(1));
    }

    @Configuration
    static class TestConfig {

        @Bean
        public IMemoryGameService memoryGameService() {
            return new MemoryGameServiceImpl();
        }

    }
}