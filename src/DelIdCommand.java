import org.jibble.pircbot.*;

public class DelIdCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aMessages.length == 2) {
			if (aRunOn.getIdManager().delId(aMessages[1]) != null) {
				aRunOn.getIdManager().saveIds();
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Deleted " + aMessages[1] + " from the list of IDs.");
			} else {
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + aMessages[1] + " is not in the list if IDs.");
			}
		} else {
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !delid [ name ]");
		}
	}
}