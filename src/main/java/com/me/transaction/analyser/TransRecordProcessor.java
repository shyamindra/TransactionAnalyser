package com.me.transaction.analyser;

import com.me.transaction.analyser.dao.TransRecord;
import com.me.transaction.analyser.dao.TransactionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class TransRecordProcessor {

	/*
		Returns the list of valid transactions for the given account number between the to and from dates.
		If there is a reversal of the transaction, it would be removed from the original list of transactions,
		irrespective of the date of the reversal
	 */
	public List<TransRecord> getValidTransactions(List<TransRecord> transactionRecords,
												  String accNum, Date fromDate, Date toDate) {

		List<TransRecord> eligTransactions = transactionRecords
				.stream()
				.filter(record -> record.getFromAccountID().equals(accNum) &&
						record.getTransactionType().equals(TransactionType.PAYMENT) &&
						record.getCreateAt().after(fromDate) &&
						record.getCreateAt().before(toDate))
				.collect(Collectors.toList());

		List<String> reversedTransactionIds = new ArrayList<>();
		transactionRecords
				.stream()
				.filter(record -> record.getTransactionType().equals(TransactionType.REVERSAL))
				.forEach(record -> reversedTransactionIds.add(record.getRelatedTransaction()));

		eligTransactions = eligTransactions
				.stream()
				.filter(record -> !reversedTransactionIds.contains(record.getTransactionID()))
				.collect(Collectors.toList());

		return eligTransactions;
	}

	public double getSumTransactions(List<TransRecord> eligRecords) {
		return eligRecords.stream().mapToDouble(i -> i.getAmount()).sum();
	}
}
