import org.jibble.pircbot.*;

public class LostCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 1) {
				String lTarget = aRunOn.getChainDetail().getCurrentRotationString();
				if (lTarget != null && lTarget.equals(aSender))
				{
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + lTarget + " has lost.");
					aRunOn.getChainDetail().nextRotation();
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "The next person to hit is now " + 
									   aRunOn.getChainDetail().getCurrentRotationString());
				} else if (lTarget != null)
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You (" + lTarget + ") are not supposed to be hitting now.");
				else
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Nobody is in the rotation list!");
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !lost");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can use this command only when chaining.");
	}
}