package pl.korman.docker.familymemberapp.FamilyMember;

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
public class FamilyMemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void familyMemberGet_schouldReturnStatus200oK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/familymember/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void familyMemberPost_schouldReturnStatus201Created() throws Exception {
        String content = "{\"familyId\":2,\"givenName\":\"Andrzej\",\"familyName\":\"Kowalski\",\"age\":15}";
        mockMvc.perform(MockMvcRequestBuilders.post("/familymember")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    void familyMemberPost_blankGivenName_schouldReturnStatus400BadRequest() throws Exception {
        String content = "{\"familyId\":2,\"givenName\":\"\",\"familyName\":\"Kowalski\",\"age\":15}";
        mockMvc.perform(MockMvcRequestBuilders.post("/familymember")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void familyMemberPost_blankFamilyName_schouldReturnStatus400BadRequest() throws Exception {
        String content = "{\"familyId\":2,\"givenName\":\"Andrzej\",\"familyName\":\"\",\"age\":15}";
        mockMvc.perform(MockMvcRequestBuilders.post("/familymember")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().is(400));
    }






}