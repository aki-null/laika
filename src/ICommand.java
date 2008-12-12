public interface ICommand {
	void execute(LaikaBot aRunOn, String aChannel, String aSender, String[] aMessages);
}