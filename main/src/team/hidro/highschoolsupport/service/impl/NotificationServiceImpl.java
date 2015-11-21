package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.NotificationDao;
import team.hidro.highschoolsupport.entities.Notification;
import team.hidro.highschoolsupport.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDao notificationDao;
	
	@Override
	public List<Notification> getAllNotification(int id) {
		
		return notificationDao.getAllNotification(id);
		
	}

	@Override
	public boolean updateNotificationStatus(int id, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNotification(Notification notification) {
		return notificationDao.addNotification(notification);
	}

}
