package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private final TransactionRepository<Transaction> repository;

    public TransactionService(TransactionRepository<Transaction> repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAll();
    }

    public Optional<Transaction> getById(Long id) {
        return repository.getById(id);
    }

    public Optional<Transaction> createTransaction(TransactionDto dto) {
        return Optional.of(repository.save(Transaction.fromDto(dto)));
    }

    public Optional<Transaction> updateTransaction(Long id, TransactionDto dto) {
        Optional<Transaction> transaction = getById(id);
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

    public List<Transaction> getAllOldTransactions(Long months) {
        LocalDateTime date = LocalDateTime.now().minusMonths(months);
        return repository.findByTransactionDateTimeBefore(date);
    }

    public void deleteOldTransactions(Long months) {
        for(Transaction transaction : getAllOldTransactions(months)) {
            deleteTransaction(transaction.getId());
        }
    }
}
