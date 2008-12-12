import org.jibble.pircbot.*;

public class WaitingToHospCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining())
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + aSender + " is waiting to hospitalize!");
	}
}