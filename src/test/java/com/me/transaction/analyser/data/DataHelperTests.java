package com.me.transaction.analyser.data;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.simpleflatmapper.map.MapperBuildingException;

import com.me.transaction.analyser.dao.TransactionRecord;
import com.me.transaction.utils.DataHelper;

public class DataHelperTests {

	@Test
	public void testCSVDataRecordCount() {
		DataHelper dataHelper = new DataHelper();
		try {
			List<TransactionRecord> transactionRecords = dataHelper.readCSVData(new File("data/TestTransactionRecord1.csv"));
			Assert.assertTrue(transactionRecords.size()==2);
			transactionRecords = dataHelper.readCSVData(new File("data/TestTransactionRecord2.csv"));
			Assert.assertFalse(transactionRecords.size()==1);
		} catch (MapperBuildingException e) {
			fail();
		} catch (IOException e) {
			fail();
		} 
									
	}

}
