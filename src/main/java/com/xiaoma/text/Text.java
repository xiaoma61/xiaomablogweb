package com.xiaoma.text;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Text {
	
	@RequestMapping("/index1")
	public String Gethome(ModelMap map)
	{
		map.addAttribute("name","thex");
		return "thymeleaf/share";
		
	}


}
