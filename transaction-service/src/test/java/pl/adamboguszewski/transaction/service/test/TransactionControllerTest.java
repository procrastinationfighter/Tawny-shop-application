package pl.adamboguszewski.transaction.service.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;
import pl.adamboguszewski.transaction.service.application.dto.GetTransactionDto;
import pl.adamboguszewski.transaction.service.infrastructure.controller.TransactionController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionController.class)
@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @MockBean
    private TransactionService service;

    private final ObjectMapper mapper = new ObjectMapper();

    private final String defaultUrl = "/transaction-service/api/v1.0/";

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenRequest_whenCreateTransaction_thenReturnResponse() throws Exception {
        CreateTransactionRequest request = createSampleCreateRequest();
        Transaction transaction = new Transaction(CreateTransactionDto.fromRequest(request));

        //[TODO]: Move this somewhere else (@BeforeAll won't work since it must be static).
        mapper.registerModule(new JavaTimeModule());

        Mockito.when(service.createTransaction(Mockito.any(CreateTransactionDto.class))).thenReturn(transaction);

        mvc.perform(post(defaultUrl)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(transaction.getId()));
    }

    private CreateTransactionRequest createSampleCreateRequest() {
        return new CreateTransactionRequest(
                UUID.randomUUID(),
                10000L,
                new CreateTransactionRequest.TransactionInformation(
                        "checkout no. 15",
                        Collections.singletonList(new CreateTransactionRequest.TransactionInformation.PaymentInformation(
                                10000L, 1L, "eur", "card"
                        ))
                ),
                Collections.singletonList(new CreateTransactionRequest.TransactionProduct(
                        UUID.randomUUID(),
                        "kubek",
                        10000L,
                        1L,
                        1L,
                        "do picia",
                        "naczynie"
                )),
                LocalDateTime.now()
        );
    }

    @Test
    public void givenId_whenGetTransactionById_thenReturnResponse() throws Exception {
        Transaction transaction = new Transaction(CreateTransactionDto.fromRequest(createSampleCreateRequest()));
        GetTransactionDto dto = GetTransactionDto.fromTransaction(transaction);

        Mockito.when(service.getByTransactionId(Mockito.any(UUID.class))).thenReturn(dto);

        mvc.perform(get(defaultUrl + transaction.getTransactionId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPrice").value(transaction.getTotalPrice()));
    }

    @Test
    public void deleteOldTransactionsTest() throws Exception {
        mvc.perform(delete(defaultUrl + "/delete-old-transactions"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTransactionTest() throws Exception {
        mvc.perform(delete(defaultUrl + UUID.randomUUID()))
                .andExpect(status().isOk());
    }
}
