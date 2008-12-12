import org.jibble.pircbot.*;

public class ChainCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aMessages.length == 1) {
			if (aRunOn.isChaining()) {
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "We are already chaining!");
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "We are not chaining at the moment...");
		} else if (aMessages.length == 2) {
			if (aMessages[1].toLowerCase().equals("on")) {
				if (!aRunOn.isChaining()) {
					aRunOn.setChaining(true);
					aRunOn.getChainDetail().setChainCount(0);
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "The chain is starting...");
				} else
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "The chain is already in progress...");
			} else if (aMessages[1].toLowerCase().equals("off")) {
				if (aRunOn.isChaining()) {
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "The chain has ended...");
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Report:");
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Start respect: " + aRunOn.getChainDetail().getStartRespect());
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Last reported respect: " + aRunOn.getChainDetail().getLastRespect());
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Total number of hits: " + aRunOn.getChainDetail().getChainCount());
					aRunOn.quitChain();
				} else
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "No chain is in progress...");
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !chain [ on | off ]");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !chain [ on | off ]");
	}
}