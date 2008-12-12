import java.util.Properties;
import java.io.*;

public class PropertyManager {
	private static void createDefault()
	{
		try
		{
			Properties lPro = new Properties();
			lPro.setProperty("botName", "Laika");
			lPro.setProperty("ircServer", "irc.torncity.com");
			lPro.setProperty("channel", "#flyinghellfish");
			lPro.store(new FileOutputStream("Laika.properties"), "Header");
		}
		catch (IOException e)
		{
			System.out.println("Failed to create the setting file.");
			System.exit(1);
		}
	}
	
	public static Properties getSettings()
	{
		try
		{
			Properties lPro = new Properties();
			lPro.load(new FileInputStream("Laika.properties"));
			return lPro;
		}
		catch (IOException e)
		{
			System.out.println("Property file not found.\nCreating the new property file...");
			createDefault();
			return getSettings();
		}
	}
}