# BudgetApp

BudgetApp is an application for storing information about home budget. Might be helpful with managment home budget.You have overview for year, monthly, daily expenses trought the reports. Main page is presenting your incomes and expenses and graph which presenting yearly statistic. You will aable to editing list of your incomes and expenses.

/github/workflow/status/:user/:repo/:workflow

## Links to the appliaction

- Registration page
https://budeget.herokuapp.com/registration

- Login page
https://budeget.herokuapp.com/login#

- Home page
https://budeget.herokuapp.com

## Usage

```Java
    public Set<TransactionEntity> getReportOfIncome(Long userId){                                                              #return Set with income report
        Optional<AccountEntity> byUserId = accountRepository.findByUserId(userId);
        Set<TransactionEntity> transactionEntityList = byUserId.get().getTransactionEntityList();
        return transactionEntityList.stream().filter(t -> t.getValue().compareTo(BigDecimal.valueOf(0)) == 1 )  
                .collect(Collectors.toSet());
    }
    public Set<TransactionEntity> getReportOfMoneySpend(Long userId){                                                          #return Set with report spend money
        Optional<AccountEntity> byUserId = accountRepository.findByUserId(userId);
        Set<TransactionEntity> transactionEntityList = byUserId.get().getTransactionEntityList();
        return transactionEntityList.stream().filter(t -> t.getValue().compareTo(BigDecimal.valueOf(0)) == -1 )
                .collect(Collectors.toSet());
    }
    public BigDecimal getBalance(Long userId){                                                                                  #return Set with current Balance
        Set<TransactionEntity> transactionEntityList = accountRepository.findByUserId(userId).get().getTransactionEntityList();
        BigDecimal balance = BigDecimal.valueOf(0);
        transactionEntityList.forEach(t -> balance.add(t.getValue()));
        return balance;
    }
```

## Used technologies

- Java

- Java script

- CSS

- HTML

- Bootstrap

- Spring

- Spring Security

- Spring Data

- PostrgeSQL Database



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
