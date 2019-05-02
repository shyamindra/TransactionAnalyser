package com.me.transaction.analyser;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.me.transaction.analyser.dao.TransactionRecord;
import com.me.transaction.analyser.dao.TransactionType;


public class TransactionAnalysisHelper {
	
	public Map<String, TransactionRecord> findAccountBalance(List<TransactionRecord> transactionRecords, String accNum, Date fromDate, Date toDate) {
		
		Map<String,TransactionRecord> eligTransactions = new HashMap<String, TransactionRecord>();
		for(TransactionRecord record : transactionRecords) {
			if(record.getFromAccountID().equals(accNum)
					&& record.getTransactionType().equals(TransactionType.PAYMENT) 
					&& record.getCreateAt().after(fromDate)
					&& record.getCreateAt().before(toDate)) {
				eligTransactions.put(record.getTransactionID(), record);
			} else if(record.getTransactionType().equals(TransactionType.REVERSAL)) {
					eligTransactions.remove(record.getRelatedTransaction());
			}
		}
		return eligTransactions;
	}
	
	public double getRelativeBalance(Map<String, TransactionRecord> eligRecords) {
		return eligRecords.values().stream().mapToDouble(i -> i.getAmount()).sum();
	}
}
