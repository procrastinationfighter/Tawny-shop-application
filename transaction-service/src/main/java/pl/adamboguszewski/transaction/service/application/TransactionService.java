package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;
import pl.adamboguszewski.transaction.service.infrastructure.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    // [TODO]
/*
    First things first -- we need database to work with so install postgres https://www.postgresql.org/ and read
    how to do this. Try to create some tables in client (I know that pgAdmin exists, you can try with other), get used
    to postgres. Idk if you had contact with MySql but it is very similar database.
    Next thing is to access data with our application. We will use JPA and Hibernate. Read about this and about ORM,
    then you can follow this guide to extend JpaRepository https://spring.io/guides/gs/accessing-data-jpa/
    Next job is to inject our Repository to this service and call suitable methods to get/insert data to connected
    datasource. It is one of the hardest step to understand in developing this application. Other references:
    https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
    https://www.baeldung.com/spring-data-repositories
*/

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Optional<Transaction> getByTransactionId(Long id) {
        return repository.findById(id);
    }

    public Optional<Transaction> createTransaction(TransactionDto dto) {
        return Optional.of(repository.save(Transaction.fromDto(dto)));
    }

    public Optional<Transaction> updateTransaction(Long id, TransactionDto dto) {
        Optional<Transaction> transaction = getByTransactionId(id);
        if(transaction.isPresent()) {
            // [TODO]: Method for updating already existing transaction.
            return Optional.empty();
        }
        else {
            return createTransaction(dto);
        }
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }

    public List<Transaction> getAllOldTransactions() {
        final int HOW_MANY_YEARS = 2;
        LocalDate boundaryDate = LocalDate.now().minusYears(HOW_MANY_YEARS);
        return repository.findByTransactionInformation_TransactionDateTime_DateBefore(boundaryDate);
    }

    public void deleteOldTransactions() {
        for(Transaction transaction : getAllOldTransactions()) {
            deleteTransaction(transaction.getId());
        }
    }
}
