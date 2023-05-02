package com.maybank.demo;

import com.maybank.demo.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BatchProcessor {
	private static final Logger logger = LogManager.getLogger(BatchProcessor.class);

	final static String FILE_LOCATION_PROP_NAME = "file.location";
	final static String FILE_NAME_PROP_NAME = "file.name";
	final static String DEFAULT_FILE_LOCATION = "C:\\Users\\user\\Downloads";
	final static String DEFAULT_FILE_NAME = "dataSource.txt";

	// define regular expression, based on sample data :
	//     8872838283|123.00|FUND TRANSFER|2019-09-12|11:11:11|222
	final static String REGEXP = "(\\d+)\\|(\\d+.\\d{2})\\|(.+)\\|(\\d{4}-\\d{2}-\\d{2})\\|(\\d{2}\\:\\d{2}:\\d{2})\\|(\\d+)";

	static Pattern pattern;
	static Matcher matcher;

	private static EntityManager em;

	public static void main(String[] args) {
		logger.debug("Start transaction");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccountTransactionPU");
		em = emf.createEntityManager();

		Properties prop = loadProperties();
		logger.debug("FILE_LOCATION_PROP_NAME : {}",prop.getProperty(FILE_LOCATION_PROP_NAME));
		logger.debug("FILE_NAME_PROP_NAME : {}",prop.getProperty(FILE_NAME_PROP_NAME));

		try {
			processFile(prop);
		} catch (IOException e) {
			logger.error("Error processing file : {}", e.toString());
		}
		
		logger.debug("End transaction");
	}

	private static void processFile(Properties prop) throws NumberFormatException, IOException {
		int validLine = 0;
		int invalidLine = 0;

		File f = new File(prop.getProperty(FILE_LOCATION_PROP_NAME)+"\\"+prop.getProperty(FILE_NAME_PROP_NAME));
		pattern = Pattern.compile(REGEXP);

		BufferedReader b = new BufferedReader(new FileReader(f));

		String readLine = "";
		while ((readLine = b.readLine()) != null) {
			matcher = pattern.matcher(readLine);
			if (matcher.find()) { 
				validLine++;
				
				AccountTransaction account = new AccountTransaction(Long.valueOf(matcher.group(1)), 
						Long.valueOf(matcher.group(6)), 
						Double.valueOf(matcher.group(2)), 
						matcher.group(3),
						matcher.group(4)+" "+matcher.group(5));
				
				createAccount(account);
			} else {
				invalidLine++;
			}
		}
		
		b.close();

		logger.debug("Valid line : {}", validLine);
		logger.debug("Invalid line : {}", invalidLine);
	}

	private static void createAccount(AccountTransaction acct) {
		em.getTransaction().begin();
		em.persist(acct);
		em.getTransaction().commit();
	}

	private static Properties loadProperties() {
		try (InputStream input = BatchProcessor.class.getClassLoader().getResourceAsStream("config.properties")) {

			Properties prop = new Properties();

			if (input == null) {
				logger.debug("Unable to find config.properties. Setting default values :");
				return defaultProperties();
			}

			//load a properties file
			prop.load(input);
			return prop;

		} catch (IOException ex) {
			logger.error("Error reading properties file : {}", ex.toString());
			logger.error("Setting default properties");
			return defaultProperties();
		}
	}

	private static Properties defaultProperties() {
		Properties prop = new Properties();
		prop.setProperty(FILE_LOCATION_PROP_NAME, DEFAULT_FILE_LOCATION);
		prop.setProperty(FILE_NAME_PROP_NAME, DEFAULT_FILE_NAME);
		return prop;
	}
}
