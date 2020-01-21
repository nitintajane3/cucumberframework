package manager;

import java.io.IOException;

import dataProviders.ConfigFileReader;

public class FileReaderManager 
{

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	
	private FileReaderManager()
	{
		
	}
	
	public static FileReaderManager getInstance() 
	{
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() throws IOException 
	{
		return (configFileReader== null) ? new ConfigFileReader() : configFileReader;
	}
}
