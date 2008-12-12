import org.jibble.pircbot.*;

public class ReportHospRegEx extends RegExTask {
	public ReportHospRegEx(String aPattern) {
		super(aPattern);
	}
	
	public boolean execute(LaikaBot aBot, String aChannel, String aTarget, String aSender) {
		if (aTarget.matches(fPattern)) {
			if (aBot.getChainDetail().isRegistered(aSender)) {
				aBot.getChainDetail().resetTimer(aChannel, aBot);
				String[] lSplitted = aTarget.split(" ");
				aBot.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Good work hospitalizing " + lSplitted[4] + "!");
				aBot.getChainDetail().setChainCount(aBot.getChainDetail().getChainCount() + 1);
				aBot.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + 	aBot.getChainDetail().getChainCount() + " hits have been made in the chain.");
				aBot.getChainDetail().nextRotation();
				String lNextPerson = aBot.getChainDetail().getCurrentRotationString();
				if (lNextPerson != null)
					aBot.sendMessage(aChannel, Colors.BOLD + Colors.RED + aBot.getChainDetail().getCurrentRotationString() + " is hitting next.");
				aBot.getChainDetail().updateLastHospTime();
				return true;
			} else {
				aBot.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You (" + aSender + ") are not in the current rotation list!");
			}
		}
		return false;
	}
}