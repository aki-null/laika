import org.jibble.pircbot.*;

public class SkipCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 1) {
				String lTarget = aRunOn.getChainDetail().getCurrentRotationString();
				if (lTarget != null) {
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.GREEN + "Skipped " + lTarget + ".");
					aRunOn.getChainDetail().nextRotation();
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "The next person to hit is now " + 
									   aRunOn.getChainDetail().getCurrentRotationString());
				} else
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Nobody is in the rotation list!");
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !skip");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can skip turn only when chaining.");
	}
}