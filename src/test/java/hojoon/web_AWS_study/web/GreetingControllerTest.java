package hojoon.web_AWS_study.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void greeting이_나타난다() throws Exception {
        String greeting = "greeting";

        mvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string(greeting));
    }

    @Test
    public void greetingDto가_리턴된다() throws Exception {
        String name = "hojoon";
        int amount = 1000;

        mvc.perform(get("/greeting/dto")
                .param("name",name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
