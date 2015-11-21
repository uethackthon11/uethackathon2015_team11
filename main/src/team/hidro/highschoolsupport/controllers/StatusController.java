package team.hidro.highschoolsupport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatusController {
	@RequestMapping(value = "/group/{idGroup}/status/{idStatus}", method = RequestMethod.GET)
	public ModelAndView getGroupView(@PathVariable("idGroup") int groupId,@PathVariable("idStatus") int statusId) {
		ModelAndView model = new ModelAndView("status");
		model.addObject("groupId", groupId);
		model.addObject("statusId", statusId);
		return model;
	}

}
