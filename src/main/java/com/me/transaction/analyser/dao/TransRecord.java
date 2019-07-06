package com.me.transaction.analyser.dao;

import org.springframework.lang.Nullable;

import java.util.Date;

public class TransRecord {

	private String transactionID;
	private String fromAccountID;
	private String toAccountID;
	private Date createAt;
	private double amount;
	private TransactionType transactionType;
	@Nullable
	private String relatedTransaction;

	public TransRecord(String transactionID, String fromAccountID, String toAccountID, Date createAt,
					   double amount, TransactionType transactionType) {
		this.transactionID = transactionID;
		this.fromAccountID = fromAccountID;
		this.toAccountID = toAccountID;
		this.createAt = createAt;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public TransRecord(String transactionID, String fromAccountID, String toAccountID, Date createdAt,
					   double amount, TransactionType transactionType, String relatedTransaction) {
		this(transactionID, fromAccountID, toAccountID, createdAt, amount, transactionType);
		this.setRelatedTransaction(relatedTransaction);
	}

	public String getTransactionID() {
		return transactionID;
	}

	public String getFromAccountID() {
		return fromAccountID;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public double getAmount() {
		return amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public String getRelatedTransaction() {
		return relatedTransaction;
	}

	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}

	@Override
	public String toString() {
		return "TransRecord{" +
				"transactionID='" + transactionID + '\'' +
				", fromAccountID='" + fromAccountID + '\'' +
				", toAccountID='" + toAccountID + '\'' +
				", createAt=" + createAt +
				", amount=" + amount +
				", transactionType=" + transactionType +
				", relatedTransaction='" + relatedTransaction + '\'' +
				'}';
	}

}
