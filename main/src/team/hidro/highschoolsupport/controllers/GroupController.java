package team.hidro.highschoolsupport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.InitialStatusDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.service.CommentService;
import team.hidro.highschoolsupport.service.StatusService;

@Controller
public class GroupController {

	@Autowired
	private StatusService statusService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/groupdata/initial/{idGroup}", method = RequestMethod.GET)
	public @ResponseBody InitialStatusDetail getInitialStatus(@PathVariable("idGroup") int groupId) {
		return statusService.getListInitialStatusByGroupId(groupId);
	}

	@RequestMapping(value = "/group/{idGroup}", method = RequestMethod.GET)
	public ModelAndView getGroupView(@PathVariable("idGroup") int groupId) {
		ModelAndView model = new ModelAndView("group");
		model.addObject("groupId", groupId);
		return model;
	}
	
	@RequestMapping(value = "/groupdata/{idGroup}", method = RequestMethod.GET)
	public @ResponseBody List<StatusDetail> getStatus(@PathVariable("idGroup") int groupId) {
		return statusService.getListStatusByGroupId(groupId);
	}
	
	@RequestMapping(value = "/groupdata/{idGroup}/status/{statusId}", method = RequestMethod.GET)
	public @ResponseBody StatusDetail getComments(@PathVariable("idGroup") int groupId) {
		return statusService.getById(groupId);
	}

	@RequestMapping(value = "/groupdata/{idGroup}/{userId}/newStatus", method = RequestMethod.POST)
	public @ResponseBody boolean createStatus(@PathVariable("idGroup") int groupId, @PathVariable("userId") int userId,
			@RequestParam("content") String content, @RequestParam("title") String title,@RequestParam("type") int type) {
		long dateTime = System.currentTimeMillis();
		StatusDetail statusDetail = new StatusDetail(0, groupId, userId, content, dateTime, null, null, 1, type, title);
		return statusService.save(statusDetail);
	}
	
	@RequestMapping(value = "/statusdata/{statusId}", method = RequestMethod.GET)
	public @ResponseBody StatusDetail getStatus2(@PathVariable("statusId") int statusId) {
		return statusService.getById(statusId);
	}
	
	
	
}