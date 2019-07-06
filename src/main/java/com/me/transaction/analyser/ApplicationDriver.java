package com.me.transaction.analyser;

import com.me.transaction.analyser.dao.TransRecord;
import com.me.transaction.utils.CsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class ApplicationDriver {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ApplicationDriver.class);

		try {
			CsvReader dataHelper = new CsvReader(new File(args[0]));
			TransRecordProcessor analysisHelper = new TransRecordProcessor();
			List<TransRecord> eligRecords = analysisHelper.getValidTransactions(
					dataHelper.readCSVData(),
					args[1],
					dataHelper.getDate(args[2]),
					dataHelper.getDate(args[3]));

			System.out.println("Relative balance for the period is: "
					+ analysisHelper.getSumTransactions(eligRecords));
			System.out.println("Number of transactions included is: " + eligRecords.size());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
}
