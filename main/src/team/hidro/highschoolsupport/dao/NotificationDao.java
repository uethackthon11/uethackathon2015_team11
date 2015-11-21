package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.Notification;

public interface NotificationDao {

	public List<Notification> getAllNotification(int id);
	public boolean updateNotificationStatus(int id, int status);
	public boolean addNotification(Notification notification);
	
}
