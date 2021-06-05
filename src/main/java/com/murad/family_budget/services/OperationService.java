package com.murad.family_budget.services;

import com.murad.family_budget.entity.FamilyWallet;
import com.murad.family_budget.entity.User;
import com.murad.family_budget.models.Operation;
import com.murad.family_budget.repositories.FamilyWalletRepository;
import com.murad.family_budget.repositories.UserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 04/06/2021 - 7:24
 * @project family_budget
 */
@Service
@Transactional
public class OperationService {
    private final UserRepository           userRepository;
    private final FamilyWalletRepository   familyWalletRepository;
    @Autowired
    private       ObjectFactory<Operation> operationObjectFactory;

    @Autowired
    public OperationService(UserRepository userRepository,
                            FamilyWalletRepository familyWalletRepository) {
        this.userRepository = userRepository;
        this.familyWalletRepository = familyWalletRepository;
    }

    private User getUser(String email) {
        User user = userRepository.findFirstByEmail(email);
        return user;
    }

    public List<Operation> getMyTransaction(String myEmail) {

        List<FamilyWallet> familyWallets = familyWalletRepository.findByUserIdOrderByFamilyId(getUser(myEmail).getId());
        List<Operation>    operations    = new ArrayList<>();
        for (FamilyWallet familyWallet : familyWallets) {
            Operation operation = operationObjectFactory.getObject();
            operation.setScore(familyWallet.getScore());
            operation.setOperationDateTime(familyWallet.getOperationDateTime());
            operations.add(operation);
        }
        return operations;
    }

    public synchronized void moneyOperation(String myEmail, BigDecimal score) throws Exception {
        FamilyWallet familyWallet = familyWallet();
        familyWallet.setFamilyId(getUser(myEmail).getFamilyId());
        familyWallet.setUserId(getUser(myEmail).getId());
        familyWallet.setScore(score);
        familyWalletRepository.save(familyWallet);
    }

    public synchronized void inMoney(String myEmail, BigDecimal score) throws Exception {
        moneyOperation(myEmail, score);
    }

    public synchronized String outMoney(String myEmail, BigDecimal score) throws Exception {
        LocalDateTime start   = LocalDateTime.of(LocalDate.from(LocalDate.now()), LocalTime.of(0, 0, 0));
        LocalDateTime end     = LocalDateTime.of(LocalDate.from(LocalDate.now()), LocalTime.of(23, 59, 59));
        User          user    = getUser(myEmail);
        BigDecimal    b       = familyWalletRepository.getSumOutMoney(user.getFamilyId(), user.getId(), start, end);
        BigDecimal    balance = familyWalletRepository.getFamilyBalance(user.getFamilyId());

        if (b != null)
            if (b.negate().add(score).floatValue() >= user.getPriceLimit())
                return "You have crossed the daily limit";
        if (balance.compareTo(score) == 0 || balance.compareTo(score) == 1) {
            moneyOperation(myEmail, score.negate());
        } else return "Insufficient funds in the family budget";


        return "successful operation";
    }

    @Bean
    private FamilyWallet familyWallet() {
        return new FamilyWallet();
    }


}
