import org.jibble.pircbot.*;

public class ReportCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 1) {
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Report:");
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Start respect: " + aRunOn.getChainDetail().getStartRespect());
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Last reported respect: " + aRunOn.getChainDetail().getLastRespect());
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.BLUE + "Total number of hits: " + aRunOn.getChainDetail().getChainCount());
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !report");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "The report is available only when chaining.");
	}
}