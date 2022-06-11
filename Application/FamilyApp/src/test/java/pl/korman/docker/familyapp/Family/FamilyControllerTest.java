package pl.korman.docker.familyapp.Family;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FamilyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void familyGet_schouldReturnStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/family/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void familyPost_schouldReturnStatus201Created() throws Exception {
        String content = "{\"familyName\":\"Piputuś\",\"nrOfAdults\":1,\"nrOfChildren\":1,\"nrOfInfants\":1," +
                "\"familyMembersList\":[{\"givenName\":\"Mateusz\",\"familyName\":\"Piputuś\",\"age\":0}," +
                "{\"givenName\":\"Andrzej\",\"familyName\":\"Piputuś\",\"age\":15}," +
                "{\"givenName\":\"Izabela\",\"familyName\":\"Piputuś\",\"age\":16}]}";
        mockMvc.perform(MockMvcRequestBuilders.post("/family")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201));
    }



}