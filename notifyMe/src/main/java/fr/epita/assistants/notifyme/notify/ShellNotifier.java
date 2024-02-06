package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender {
    /**
     * Constructor
     * @param parStdErr if true, print to stderr, otherwise print to stdout
     */
    boolean stderr;
    public ShellNotifier(final boolean parStdErr)
    {
        stderr = parStdErr;
    }

    @Override
    public void notify(final String parSender, final String parReceiver, final String parMessage) {
        if (stderr)
        {
            System.err.println("Notification from " + parSender + " to " + parReceiver
            + " received: " + parMessage);
        }
        else
        {
            System.out.println("Notification from " + parSender + " to " + parReceiver
                    + " received: " + parMessage);
        }
    }
}
