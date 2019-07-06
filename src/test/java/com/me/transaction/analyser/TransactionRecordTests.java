package com.me.transaction.analyser;

import com.me.transaction.analyser.dao.TransRecord;
import com.me.transaction.utils.CsvReader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionRecordTests {


	@Test
	public void testTransRecordProcessoreInit() {
		TransRecordProcessor transRecordProcessor = new TransRecordProcessor();
		assertNotNull(transRecordProcessor);
	}

	@Test
	public void testTransactionCount() throws IOException, ParseException {
		CsvReader dataHelper = new CsvReader(new File("data/TestTransactionRecord1.csv"));
		List<TransRecord> transactionRecords = dataHelper.readCSVData();
		assertEquals(2, transactionRecords.size());

	}

	@Test
	public void testTransactionBalance1() throws IOException, ParseException {
		CsvReader dataHelper = new CsvReader(new File("data/TestTransactionRecord1.csv"));
		TransRecordProcessor transaRecordProcessor = new TransRecordProcessor();
		List<TransRecord> transactionRecords = dataHelper.readCSVData();
		List<TransRecord> transactionList = transaRecordProcessor
				.getValidTransactions(transactionRecords,
						"ACC334455",
						dataHelper.getDate("20/10/2018 12:00:00"),
						dataHelper.getDate("20/10/2018 19:00:00"));
		assertEquals(1, transactionList.size());
		assertEquals(25, transaRecordProcessor.getSumTransactions(transactionList), 0.0);


	}

	@Test
	public void testTransactionBalance2() throws IOException, ParseException {
		CsvReader dataHelper = new CsvReader(new File("data/TestTransactionRecord2.csv"));
		TransRecordProcessor transaRecordProcessor = new TransRecordProcessor();
		List<TransRecord> transactionRecords = dataHelper.readCSVData();
		List<TransRecord> transactionList = transaRecordProcessor
				.getValidTransactions(transactionRecords,
						"ACC334455",
						dataHelper.getDate("20/10/2018 12:00:00"),
						dataHelper.getDate("20/10/2018 16:00:00"));
		assertEquals(1, transactionList.size());
		assertNotEquals(35.50, transaRecordProcessor.getSumTransactions(transactionList));


	}

//	@Test
	public void testTransactionBalance() throws IOException, ParseException {
		CsvReader dataHelper = new CsvReader(new File("data/TestTransactionRecord1.csv"));
		List<TransRecord> transactionRecords = dataHelper.readCSVData();
		TransRecordProcessor transaRecordProcessor = new TransRecordProcessor();
		List<TransRecord> transactionList = transaRecordProcessor
				.getValidTransactions(transactionRecords,
						"ACC334455",
						dataHelper.getDate("20/10/2018 12:00:00"),
						dataHelper.getDate("20/10/2018 19:00:00"));
		assertEquals(1, transactionList.size());
		assertEquals(25, transaRecordProcessor.getSumTransactions(transactionList), 0.0);
	}

	@Test
	public void testTransactionReversal() throws IOException, ParseException {
		CsvReader dataHelper = new CsvReader(new File("data/TestTransactionRecord4.csv"));
		TransRecordProcessor transaRecordProcessor = new TransRecordProcessor();
		List<TransRecord> transactionRecords = dataHelper.readCSVData();
		List<TransRecord> transactionList = transaRecordProcessor
				.getValidTransactions(transactionRecords,
						"ACC334455",
						dataHelper.getDate("20/10/2018 12:00:00"),
						dataHelper.getDate("20/10/2018 20:00:00"));
		assertEquals(0, transactionList.size());
		assertEquals(0, transaRecordProcessor.getSumTransactions(transactionList), 0.0);

	}

}
