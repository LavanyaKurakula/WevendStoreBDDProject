package configfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private String propertyFilePath = "config//configuration.properties";

	public ConfigFileReader() throws IOException {

		FileInputStream fis = new FileInputStream(propertyFilePath);
		properties = new Properties();
		properties.load(fis);
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser is not specified");
	}

	public String getUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url is not specified");
	}

}
