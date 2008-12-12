import org.jibble.pircbot.*;

public class AddIdCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aMessages.length == 3) {
			aRunOn.getIdManager().addId(aMessages[1], aMessages[2]);
			aRunOn.getIdManager().saveIds();
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Added " + aMessages[1] + " as [" + aMessages[2] + "] to the list of IDs.");
		} else {
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !addid [ name ] [ ID ]");
		}
	}
}