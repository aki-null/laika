import org.jibble.pircbot.*;

public class RespectChangeRegEx extends RegExTask {
	public RespectChangeRegEx(String aPattern) {
		super(aPattern);
	}
	
	public boolean execute(LaikaBot aBot, String aChannel, String aTarget, String aSender) {
		if (aTarget.matches(fPattern)) {
			try {
				int lCurrentRespect = Integer.parseInt(aTarget.split(" ")[1]);
				aBot.getChainDetail().setLastRespect(lCurrentRespect);
				aBot.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Total respect gained: " + 
								(lCurrentRespect - aBot.getChainDetail().getStartRespect()));
				aBot.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Average respect gain per hit: ~" + 
								((float)(lCurrentRespect - aBot.getChainDetail().getStartRespect()) / 
								(float)(aBot.getChainDetail().getChainCount())));
			} catch (Exception e) {
				aBot.sendMessage(aChannel, Colors.BOLD + Colors.RED + aTarget.split(" ")[1] + " is not a number.");
			}
			return true;
		}
		return false;
	}
}