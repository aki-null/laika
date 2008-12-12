import org.jibble.pircbot.*;

public class RegisterCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			String lTarget = null;
			if (aMessages.length == 1)
				lTarget = aSender;
			else if (aMessages.length == 2)
				lTarget = aMessages[1];
			else {
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !register [ user name (optional) ]");
				return;
			}
		
			if (aRunOn.getChainDetail().registerRotation(lTarget))
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.GREEN + "Registered " + lTarget + " to the rotation.");
			else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.MAGENTA + lTarget + " is already registered!");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can register only when chaining.");
	}
}