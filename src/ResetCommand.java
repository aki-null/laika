import org.jibble.pircbot.*;

public class ResetCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 2) {
				try {
					aRunOn.getChainDetail().setChainCount(Integer.parseInt(aMessages[1]));
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "New total number of hits: " + aMessages[1]);
				} catch (Exception e) {
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + aMessages[1] + " is not a number.");
				}
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !reset [ new total number of hits ]");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can reset only when chaining.");
	}
}