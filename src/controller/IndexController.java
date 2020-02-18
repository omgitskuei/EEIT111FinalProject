package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class IndexController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Get the "<td><input type="text" name="name"></td>" from form.jsp
		String name = request.getParameter("SearchBar");
		
		
		// Declare Map object for storing error messages
		Map<String, String> map = new HashMap<String, String>();
		// Check if name from form.jsp is empty
		if (name == null || name.length() == 0) {
			map.put("name", "name is required");
		}
		//
		request.setAttribute("errors", map);
		//If there's an error message inside Map<> map, ...
		if (map != null && !(map.isEmpty())) {
			//... then direct to /form.jsp
			//return new ModelAndView("/form.jsp");
			return new ModelAndView("form"); //dont need to write "/"xxx".jsp" since we set up a ViewResolver
		}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);

//		return new ModelAndView("/success.jsp"); is used for directing to success.jsp
		return new ModelAndView("success"); //don't need to write /xxxx.jsp since we have set up a ViewResolver
	}

}
