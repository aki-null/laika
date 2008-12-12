import java.util.Properties;

public class Laika {
	public static void main(String[] args) throws Exception {
		Properties lPro = PropertyManager.getSettings();
		LaikaBot lBot = new LaikaBot(lPro.getProperty("botName", "Laika"));
		lBot.connect(lPro.getProperty("ircServer", "irc.torncity.com"));
		// bot.setVerbose(true);
		lBot.joinChannel(lPro.getProperty("channel", "#flyinghellfish"));
	}
}