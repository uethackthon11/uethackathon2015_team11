package team.hidro.highschoolsupport.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import team.hidro.highschoolsupport.entities.Notification;
import team.hidro.highschoolsupport.service.NotificationService;

@Controller
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@RequestMapping("/{id}/notification")
	public @ResponseBody List<Notification> getAllNotification(@PathVariable("id") int id) {

		return notificationService.getAllNotification(id);
	}

	@RequestMapping(value = "/add_notification", method = RequestMethod.POST)
	public @ResponseBody void addNotification(HttpServletRequest request, HttpSession sesion) {

		int type = Integer.parseInt(request.getParameter("type"));
		int recieverId = Integer.parseInt(request.getParameter("recieverId"));
		int senderId = Integer.parseInt(sesion.getAttribute("id").toString());
		String message = "";
		switch (type) {
		case 3:
			message = " đã gửi yêu cầu xem lại " + request.getParameter("message") + " ở cột số " + request.getParameter("col");
			break;
		case 2:
			message = " đã nhận xét về bạn";
			break;
		case 1:
			message = " đã cập nhật điểm của bạn";
			break;
		default:
			break;
		}
		
		Notification notification = new Notification(1, senderId, "", recieverId, "bạn", (new Date()).getTime(), message, 1, type);
		System.out.println(notification.toString());
		notificationService.addNotification(notification);

	}

}
