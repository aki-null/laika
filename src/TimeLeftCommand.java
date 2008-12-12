import org.jibble.pircbot.*;

public class TimeLeftCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 1) {
				long lTimeLeft;
				if (aRunOn.getChainDetail().getLastHospTime() == 0)
					lTimeLeft = (long)300000;
				else
					lTimeLeft = (long)300000 - (System.currentTimeMillis() - aRunOn.getChainDetail().getLastHospTime());
				long lMinutes = (lTimeLeft % (1000*60*60)) / (1000*60);
				long lSeconds = ((lTimeLeft % (1000*60*60)) % (1000*60)) / 1000;
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + lMinutes + " minutes and " + lSeconds + " seconds left until the chain is broken.");
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !timeleft");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Time left until a chain is broken is available only when chaining.");
	}
}