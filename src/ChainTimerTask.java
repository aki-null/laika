import java.util.TimerTask;
import org.jibble.pircbot.*;

public class ChainTimerTask extends TimerTask {
	String fTime;
	boolean fEndTask;
	LaikaBot fBot = null;
	String fChannel;
	boolean fWarn;
	
	ChainTimerTask(String aTimeString, boolean aEndTask, boolean aWarn, LaikaBot aBot, String aChannel) {
		fTime = aTimeString;
		fEndTask = aEndTask;
		fBot = aBot;
		fChannel = aChannel;
		fWarn = aWarn;
	}
	
	public void run() {
		if (!fEndTask) {
			fBot.sendMessage(fChannel, Colors.BOLD + Colors.RED + fTime + " remaining until the chain is broken.");
			if (fWarn && (fBot.getChainDetail().getRotationList().size() != 0))
				fBot.sendMessage(fChannel, Colors.BOLD + Colors.PURPLE + "Hey " + fBot.getChainDetail().getCurrentRotationString() + "! Do not forget to make a hit!");
		} else {
			fBot.sendMessage(fChannel, Colors.BOLD + Colors.RED + "The chain is broken!");
			fBot.setChaining(false);
			fBot.sendMessage(fChannel, Colors.BOLD + Colors.BLUE + "Report:");
			fBot.sendMessage(fChannel, Colors.BOLD + Colors.BLUE + "Start respect: " + fBot.getChainDetail().getStartRespect());
			fBot.sendMessage(fChannel, Colors.BOLD + Colors.BLUE + "Total number of hits: " + fBot.getChainDetail().getChainCount());
			fBot.quitChain();
		}
	}
}