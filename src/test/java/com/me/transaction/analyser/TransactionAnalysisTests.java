package com.me.transaction.analyser;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.simpleflatmapper.map.MapperBuildingException;

import com.me.transaction.analyser.dao.TransactionRecord;
import com.me.transaction.utils.DataHelper;

public class TransactionAnalysisTests {

	@Test
	public void testTransactionCount() throws MapperBuildingException, IOException, ParseException {
		DataHelper dataHelper = new DataHelper();
		TransactionAnalysisHelper analysisHelper = new TransactionAnalysisHelper();
		List<TransactionRecord> transactionRecords1 = dataHelper.readCSVData(
				new File("data/TestTransactionRecord1.csv"));
		List<TransactionRecord> transactionRecords2 = dataHelper.readCSVData(
				new File("data/TestTransactionRecord2.csv"));
		List<TransactionRecord> transactionRecords3 = dataHelper.readCSVData(
				new File("data/TestTransactionRecord3.csv"));
		List<TransactionRecord> transactionRecords4 = dataHelper.readCSVData(
				new File("data/TestTransactionRecord4.csv"));
		Map<String, TransactionRecord> transactionMap1 = analysisHelper
				.findAccountBalance(transactionRecords1, 
					"ACC334455", 
					dataHelper.getDate("20/10/2018 12:00:00"), 
					dataHelper.getDate("20/10/2018 19:00:00"));
		Assert.assertTrue(transactionMap1.size()==1);
		Assert.assertTrue(analysisHelper.getRelativeBalance(transactionMap1) == 25);
		Map<String, TransactionRecord> transactionMap2 = analysisHelper
				.findAccountBalance(transactionRecords2, 
					"ACC998877", 
					dataHelper.getDate("20/10/2018 12:00:00"), 
					dataHelper.getDate("20/10/2018 19:00:00"));
		Assert.assertTrue(transactionMap2.size()==0);
		Assert.assertTrue(analysisHelper.getRelativeBalance(transactionMap2) != 35.50);
		Map<String, TransactionRecord> transactionMap3 = analysisHelper
				.findAccountBalance(transactionRecords3, 
					"ACC998877", 
					dataHelper.getDate("20/10/2018 12:00:00"), 
					dataHelper.getDate("20/10/2018 19:00:00"));
		Assert.assertTrue(transactionMap3.size()==1);
		Assert.assertTrue(analysisHelper.getRelativeBalance(transactionMap3) == 5.00);
		Map<String, TransactionRecord> transactionMap4 = analysisHelper
				.findAccountBalance(transactionRecords4, 
					"ACC334455", 
					dataHelper.getDate("20/10/2018 12:00:00"), 
					dataHelper.getDate("20/10/2018 19:00:00"));
		Assert.assertTrue(transactionMap4.size()==0);
		Assert.assertFalse(analysisHelper.getRelativeBalance(transactionMap4) != 0);
	}

}
