package at.spengergasse.holzer.MicroserviceWisdomAnimals.restapi;

import at.spengergasse.holzer.MicroserviceWisdomAnimals.wisdomclient.QuoteClient;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.wisdomclient.QuoteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
