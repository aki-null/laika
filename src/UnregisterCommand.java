import org.jibble.pircbot.*;

public class UnregisterCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			String lTarget = null;
			if (aMessages.length == 1)
				lTarget = aSender;
			else if (aMessages.length == 2)
				lTarget = aMessages[1];
			else {
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !unregister [ user name (optional) ]");
				return;
			}
		
			switch (aRunOn.getChainDetail().unregisterRotation(lTarget)) {
				case -1:
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.MAGENTA + lTarget + " is not registered!");
					break;
				case 0:
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.GREEN + "Unregistered " + lTarget + " from the rotation.");
					break;
				case 1:
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.GREEN + "Unregistered " + lTarget + " from the rotation.");
					if (aRunOn.getChainDetail().getRotationList().size() != 0)
						aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "The next person to hit is now " + 
						aRunOn.getChainDetail().getCurrentRotationString());
					else
						aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Nobody is in the rotation list!");
			}
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can unregister only when chaining.");
	}
}