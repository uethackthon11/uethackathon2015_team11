package team.hidro.highschoolsupport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.service.StatusService;

@Controller
public class GroupController  {
	
	@Autowired
	private StatusService statusService;
	@RequestMapping(value= "/group/{idGroup}", method=RequestMethod.GET)
	public @ResponseBody List<StatusDetail> getStatus(@PathVariable("idGroup") int groupId){
		return statusService.getListStatusByGroupId(groupId);
	}
}