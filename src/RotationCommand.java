import org.jibble.pircbot.*;
import java.util.LinkedList;

public class RotationCommand implements ICommand {
	public void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages) {
		if (aRunOn.isChaining()) {
			if (aMessages.length == 1) {
				LinkedList<String> lList = aRunOn.getChainDetail().getRotationList();
				if (lList.size() == 0) {
					aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Nobody is in the rotation list!");
					return;
				}
				String lOutput = "";
				for (int i = 0; i < lList.size(); i++) {
					if (aRunOn.getChainDetail().getCurrentRotation() == i)
						lOutput += Colors.BOLD + Colors.RED + " => " + lList.get(i);
					else
						lOutput += Colors.NORMAL + Colors.BLACK + " => " + lList.get(i);
				}
				aRunOn.sendMessage(aChannel, lOutput);
			} else
				aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Syntax: !rotation");
		} else
			aRunOn.sendMessage(aChannel, Colors.BOLD + Colors.RED + "Rotation information is available only when chaining.");
	}
}