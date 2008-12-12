import org.jibble.pircbot.*;

public class IdCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aMessages.length == 2) {
			String lId = aRunOn.getIdManager().getId(aMessages[1]);
			if (lId != null)
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + aMessages[1] + " [" + lId + "]");
			else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Cannot find " + aMessages[1] + " in the list of IDs.");			
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !id [ name ]");
	}
}