import org.jibble.pircbot.*;

public class ReportHospCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 1) {
				if (aRunOn.getChainDetail().isRegistered(aSender)) {
					aRunOn.getChainDetail().resetTimer(aChannel, aRunOn);
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Good work hospitalizing!");
					aRunOn.getChainDetail().setChainCount(aRunOn.getChainDetail().getChainCount() + 1);
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + 	aRunOn.getChainDetail().getChainCount() + " hits have been made in the chain.");
					aRunOn.getChainDetail().nextRotation();
					String lNextPerson = aRunOn.getChainDetail().getCurrentRotationString();
					if (lNextPerson != null)
						aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + aRunOn.getChainDetail().getCurrentRotationString() + " is hitting next.");
					aRunOn.getChainDetail().updateLastHospTime();
				} else
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You (" + aSender + ") are not in the current rotation list!");
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !911");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can report hospitalization only when chaining.");
	}
}