import org.jibble.pircbot.*;

public class SetRespectCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 2) {
				try
				{
					int lStartRespect = Integer.parseInt(aMessages[1]);
					aRunOn.getChainDetail().setStartRespect(lStartRespect);
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Start respect set to " + lStartRespect);
				} catch (Exception e) {
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + aMessages[1] + " is not a number.");
				}
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !respect [ start respect ] | !Respect [ start respect ]");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "You can set start respect only when chaining.");
	}
}