package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Members;

@Controller
public class MembersController {
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String showForm(Model model) {
		Members members = new Members();
		model.addAttribute("members", members);
		return "members";
	}

	@RequestMapping(value = "/addMembers", method = RequestMethod.POST)
	public String submit(@ModelAttribute("members") Members members, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "membersError";
		}
		model.addAttribute("memberName", members.getMemberName());
		model.addAttribute("gender", members.getGender());
		model.addAttribute("age", members.getAge());
		return "membersResult";
	}
}
