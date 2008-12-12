import org.jibble.pircbot.*;

public class HelpCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		aRunOn.sendMessage(aSender, Colors.BOLD + "Laika documentation is available from:");
		aRunOn.sendMessage(aSender, Colors.BLUE + "http://aki.geekstemplar.org.au/laika_doc.htm");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.BLUE + "Help:");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.BROWN + "--- General chain commands ---");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!chain [ on | off ]");
		// aRunOn.sendMessage(aSender, "Turns chaining status on or off.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!w2h | w2h");
		// aRunOn.sendMessage(aSender, "Notifies everybody that you are waiting to hospitalize.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!timeleft");
		// aRunOn.sendMessage(aSender, "Shows the time left until the chain is broken.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!report");
		// aRunOn.sendMessage(aSender, "Reports the current chain status.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!respect [ start respect ] | !Respect [ start respect ]");
		// aRunOn.sendMessage(aSender, "Sets the start respect to the specified value.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!reset [ new total number of hits ]");
		// aRunOn.sendMessage(aSender, "Sets the total number of hits made.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.BROWN + "--- Rotation commands ---");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!register [ user name (optional) ]");
		// aRunOn.sendMessage(aSender, "Registers the user name to the chain rotation list.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!unregister [ user name (optional) ]");
		// aRunOn.sendMessage(aSender, "Unregisters the user name from the chain rotation list.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!skip");
		// aRunOn.sendMessage(aSender, "Skips the current member.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!rotation");
		// aRunOn.sendMessage(aSender, "Shows the current chain rotation list.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.BROWN + "--- ID database commands ---");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!id [ name ]");
		// aRunOn.sendMessage(aSender, "Looks up the ID of the specified user name.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!addid [ name ] [ ID ]");
		// aRunOn.sendMessage(aSender, "Adds the specified detail to the ID database");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "!delid [ name ]");
		// aRunOn.sendMessage(aSender, "Deletes the specified user ID detail from the database.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.BROWN + "--- Other commands ---");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "To report hospitalization:");
		// aRunOn.sendMessage(aSender, "Copy and paste the text reporting the hospitalization.");
		// aRunOn.sendMessage(aSender, "e.g. You continue to beat someone on the ground.");
		// aRunOn.sendMessage(aSender, Colors.BOLD + Colors.RED + "To check the respect gain:");
		// aRunOn.sendMessage(aSender, "Copy and paste the text showing the current respect.");
		// aRunOn.sendMessage(aSender, "e.g. Respect: 1937.");
	}
}