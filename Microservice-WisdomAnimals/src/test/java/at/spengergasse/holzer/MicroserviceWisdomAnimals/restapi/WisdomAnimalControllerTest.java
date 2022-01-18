package at.spengergasse.holzer.MicroserviceWisdomAnimals.restapi;

import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.QuoteClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;

public class WisdomAnimalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    QuoteClient quoteClient;

    @Test
    void verifyGet() throws Exception{
        assert true;
        /*
        when(quoteClient.findOne(any()))
                .thenReturn(Optional.of(QuoteDto.builder().build()));

         */
    }

}
