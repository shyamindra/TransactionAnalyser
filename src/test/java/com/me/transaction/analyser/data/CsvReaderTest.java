package com.me.transaction.analyser.data;

import com.me.transaction.analyser.dao.TransRecord;
import com.me.transaction.utils.CsvReader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CsvReaderTest {

	@Test
	public void testCsvReaderInit() {
		CsvReader csvReader = new CsvReader(new File("data/TestTransactionRecord1.csv"));
		assertNotNull(csvReader);
	}

	@Test
	public void testCsvReader() throws IOException {
		CsvReader csvReader = new CsvReader(new File("data/TestTransactionRecord1.csv"));
		List<TransRecord> transactionRecords = csvReader.readCSVData();
		assertEquals(2, transactionRecords.size());
	}

	@Test
	public void testCSVDataRecordCount() throws IOException {
		CsvReader csvReader = new CsvReader(new File("data/TestTransactionRecord2.csv"));
		List<TransRecord> transactionRecords = csvReader.readCSVData();
		assertEquals(2, transactionRecords.size());
	}

	@Test(expected = IOException.class)
	public void testCSVDataRecordException() throws IOException {
		CsvReader csvReader = new CsvReader(new File("data/TestTransactionRecord7.csv"));
		List<TransRecord> transactionRecords = csvReader.readCSVData();
		assertEquals(1, transactionRecords.size());
	}
}
