package rs.saga.memorygame.memorygame.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTO;
import rs.saga.memorygame.memorygame.dto.MemoryGameDTOBuilder;
import rs.saga.memorygame.memorygame.service.IMemoryGameService;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @MockBean
    private IMemoryGameService memoryGameService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createGame() throws Exception {
        when(memoryGameService.createGame(any(Integer.class), any(String.class), any(String.class))).thenReturn(1l);

        MockHttpServletRequestBuilder put = put(MemoryGameController.MGCONTROLLER)
                .param("pairCount", "2")
                .param("playerOne", "Ana")
                .param("playerTwo", "Manja");

        mockMvc.perform(put)

                .andDo(print())

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", is(1)));
    }

    @Test
    public void startGame() throws Exception {
        when(memoryGameService.startGame(any(Long.class))).thenReturn(MemoryGameDTOBuilder.getInstance().game());

        MockHttpServletRequestBuilder get = get(MemoryGameController.MGCONTROLLER + "/1");

        mockMvc.perform(get)

                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.pairCount", is(2)))
                .andExpect(jsonPath("$.one.playerName", is("Ana")))
                .andExpect(jsonPath("$.two.playerName", is("Manja")));
    }

    @Test
    public void openPair() throws Exception {
        when(memoryGameService.openPair(any(MemoryGameDTO.class), any(String.class))).thenReturn(MemoryGameDTOBuilder.getInstance().game());

        MockHttpServletRequestBuilder post = post(MemoryGameController.MGCONTROLLER + "/1")
                .param("playerName", "Ana")
                .content(mapper.writeValueAsString(MemoryGameDTOBuilder.getInstance().game()))
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        mockMvc.perform(post)

                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.pairCount", is(2)))
                .andExpect(jsonPath("$.one.playerName", is("Ana")))
                .andExpect(jsonPath("$.two.playerName", is("Manja")));
    }
}