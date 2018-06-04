package rs.saga.memorygame.memorygame.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2018-06-04
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MemoryGameController.class, secure = false)
public class MemoryGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createGame() throws Exception {

        mockMvc.perform(put(MemoryGameController.MGCONTROLLER))

                .andExpect(status().isOk());


    }

    @Test
    public void startGame() throws Exception {
        mockMvc.perform(get(MemoryGameController.MGCONTROLLER))

                .andExpect(status().isOk());
    }

    @Test
    public void openPair() throws Exception {
        mockMvc.perform(post(MemoryGameController.MGCONTROLLER))

                .andExpect(status().isOk());
    }
}