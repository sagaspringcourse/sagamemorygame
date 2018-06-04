package rs.saga.memorygame.memorygame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.service.IMemoryGameService;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@RestController
@RequestMapping(MemoryGameController.MGCONTROLLER)
public class MemoryGameController {

    public static final String MGCONTROLLER = "/memorygame";

    private final IMemoryGameService memoryGameService;

    @Autowired
    public MemoryGameController(IMemoryGameService memoryGameService) {
        this.memoryGameService = memoryGameService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public MemoryGameDTO createGame(@RequestParam Integer pairCount, @RequestParam String playerOne, @RequestParam String playerTwo) {
        return memoryGameService.createGame(pairCount, playerOne, playerTwo);
    }

    @GetMapping("/{id}")
    public MemoryGameDTO startGame(@PathVariable Long id) {
        return memoryGameService.startGame(id);

    }

    @PostMapping("/{id}")
    public MemoryGameDTO openPair(@PathVariable Long id, @RequestBody MemoryGameDTO memoryGameDTO, @RequestParam String playerName) {
        return memoryGameService.openPair(memoryGameDTO, playerName);
    }
}
