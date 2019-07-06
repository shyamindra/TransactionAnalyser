package com.me.transaction.utils;

import com.me.transaction.analyser.dao.TransRecord;
import org.simpleflatmapper.csv.CsvMapperFactory;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.map.MapperBuildingException;
import org.simpleflatmapper.util.CloseableIterator;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvReader {

	private final File file;

	public CsvReader(final File file) {
		this.file = file;
	}

	/*
		reads data from a CSV, expects the order to match TransRecord class
	 */
	public List<TransRecord> readCSVData() throws MapperBuildingException, IOException {
		List<TransRecord> transactionRecords = new ArrayList<TransRecord>();
		try (CloseableIterator<TransRecord> it =
					 CsvParser
							 .mapWith(
									 CsvMapperFactory
											 .newInstance()
											 .defaultDateFormat("dd/MM/yyyy hh:mm:ss")
											 .newMapper(TransRecord.class))
							 .iterator(this.file)) {
			while (it.hasNext()) {
				transactionRecords.add(it.next());
			}
		}
		return transactionRecords;
	}

	public Date getDate(String timeStamp) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(timeStamp);
	}

}
