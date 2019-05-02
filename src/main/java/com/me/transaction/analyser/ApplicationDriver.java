package com.me.transaction.analyser;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.me.transaction.analyser.dao.TransactionRecord;
import com.me.transaction.utils.DataHelper;

public class ApplicationDriver 
{
    public static void main( String[] args )
    {
		Logger logger = LoggerFactory.getLogger(ApplicationDriver.class);

        try {
        	DataHelper dataHelper = new DataHelper();
        	TransactionAnalysisHelper analysisHelper = new TransactionAnalysisHelper();
			Map<String, TransactionRecord> eligRecords = analysisHelper.findAccountBalance(
					dataHelper.readCSVData(new File(args[0])), 
										args[1], 
										dataHelper.getDate(args[2]), 
										dataHelper.getDate(args[3]));
			
			System.out.println("Relative balance for the period is: " 
					+ analysisHelper.getRelativeBalance(eligRecords));
			System.out.println("Number of transactions included is: " + eligRecords.size());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
        
    }
}
