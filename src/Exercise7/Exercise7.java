package Exercise7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise7 {
    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction(1, 100.0, "USD"),
                new Transaction(2, 150.0, "EUR"),
                new Transaction(3, 200.0, "USD"),
                new Transaction(4, 75.0, "GBP"),
                new Transaction(5, 120.0, "EUR"),
                new Transaction(6, 300.0, "GBP")
        );
        // Calculate the total sum of all transaction amounts

        double totalSum = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.println("Total sum of all transactions: " + totalSum);
        // Group transactions by currency and calculate sum for each currency
        Map<String, Double> addingAmount = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency,
                        Collectors.summingDouble(Transaction::getAmount)));
        addingAmount.forEach((currency, sum) ->
                System.out.println("Total amount in " + currency + ": " + sum));


        //Find the highest transaction amount.

        Optional<Transaction> highestTransaction = transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount));
        // Find the average transaction amount
        double averageOfTransaction = transactions.stream()
                .collect(Collectors.averagingDouble(Transaction::getAmount));


    }


}

