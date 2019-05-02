package com.me.transaction.analyser.dao;

import java.util.Date;

public class TransactionRecord {

	private String transactionID;
	private String fromAccountID;
	private String toAccountID;
	private Date createAt;
	private double amount;
	private TransactionType transactionType;
	private String relatedTransaction;
	
	public TransactionRecord(String transactionID, String fromAccountID, String toAccountID, Date createAt,
			double amount, TransactionType transactionType) {
		this.transactionID = transactionID;
		this.fromAccountID = fromAccountID;
		this.toAccountID = toAccountID;
		this.createAt = createAt;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public TransactionRecord(String transactionID, String fromAccountID, String toAccountID, Date createdAt,
			double amount, TransactionType transactionType, String relatedTransaction) {
		this(transactionID, fromAccountID, toAccountID, createdAt, amount, transactionType);
		this.setRelatedTransaction(relatedTransaction);
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getFromAccountID() {
		return fromAccountID;
	}
	public void setFromAccountID(String fromAccountID) {
		this.fromAccountID = fromAccountID;
	}
	public String getToAccountID() {
		return toAccountID;
	}
	public void setToAccountID(String toAccountID) {
		this.toAccountID = toAccountID;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public String getRelatedTransaction() {
		return relatedTransaction;
	}
	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	
	public String toString() {
		return this.getTransactionID() + "," + this.getFromAccountID() + "," + this.getFromAccountID()
			+ "," + this.getCreateAt() + "," + this.getAmount() + "," + this.getTransactionType() 
			+ "," + this.getRelatedTransaction();
	}
	
}
