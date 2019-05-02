package com.me.transaction.utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleflatmapper.csv.CsvMapperFactory;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.map.MapperBuildingException;
import org.simpleflatmapper.util.CloseableIterator;

import com.me.transaction.analyser.dao.TransactionRecord;

public class DataHelper {
	
	public List<TransactionRecord> readCSVData(File file) throws MapperBuildingException, IOException{
		
		List<TransactionRecord> transactionRecords = new ArrayList<TransactionRecord>();
		try (CloseableIterator<TransactionRecord> it =
	             CsvParser
	             .mapWith(
	                     CsvMapperFactory
	     			.newInstance()
	     			.defaultDateFormat("dd/MM/yyyy hh:mm:ss")
	     			.newMapper(TransactionRecord.class))
	             	.iterator(file)) {
		    while(it.hasNext()) {
		        transactionRecords.add(it.next());
	    	}
		}
		return transactionRecords;
	}
	
	public Date getDate(String timeStamp) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(timeStamp);
	}

}
