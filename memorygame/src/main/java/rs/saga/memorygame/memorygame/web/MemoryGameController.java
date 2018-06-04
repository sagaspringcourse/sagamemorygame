package rs.saga.memorygame.memorygame.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@RestController
@RequestMapping(MemoryGameController.MGCONTROLLER)
public class MemoryGameController {

    public static final String MGCONTROLLER = "/memorygame";

    @PutMapping
    public MemoryGameDTO createGame() {
        return MemoryGameDTOBuilder.getInstance().game();
    }

    @GetMapping
    public MemoryGameDTO startGame() {
        return MemoryGameDTOBuilder.getInstance().game();

    }

    @PostMapping
    public MemoryGameDTO openPair() {
        return MemoryGameDTOBuilder.getInstance().game();
    }
}
