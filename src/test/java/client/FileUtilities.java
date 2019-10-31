package client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilities implements ElemetRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtilities.class);

	public static String getDriverProperty(String propertyName) {

		return getProperty(DRIVERFILE, propertyName);
	}

	public static String getAUTProperty(String propertyName) {

		return getProperty(AUTFILE, propertyName);
	}

	private static String getProperty(String fileName, String propertyName) {

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		Properties properties = new Properties();
		try {
			properties.load(input);
			return properties.get(propertyName).toString();

		} catch (IOException e) {
			LOGGER.error("Exception occured while Reading file in path :: ", fileName);
		}

		return null;

	}

}
