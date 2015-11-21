package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.Notification;

public interface NotificationService {

	public List<Notification> getAllNotification(int id);
	public boolean updateNotificationStatus(int id, int status);
	public boolean addNotification(Notification notification);
	
}
