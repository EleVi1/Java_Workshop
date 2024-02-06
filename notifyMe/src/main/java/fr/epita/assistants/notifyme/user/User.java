package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;
import fr.epita.assistants.notifyme.notify.ShellNotifier;

import java.util.ArrayList;
import java.util.List;

public class User implements IMultiNotificationSender {
    List<INotificationSender> notifiers;
    String name;

    public User(final String username, final List<INotificationSender> parNotificationList) {
        this.notifiers = parNotificationList;
        name = username;
    }
    public User(final String username) {
        this.notifiers = new ArrayList<>();
        name = username;
    }

    public String getUsername()
    {
        return name;
    }

    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
        for (INotificationSender notifier: notifiers)
        {
            notifier.notify(name, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        if (parNotifier != null) {
            notifiers.add(parNotifier);
        }
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return notifiers;
    }
}
