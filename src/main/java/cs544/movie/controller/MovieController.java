package cs544.movie.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.movie.DAO.MovieDAO;


@Controller
public class MovieController {
	@Resource
	private MovieDAO movieDao;
	@RequestMapping("/")
	public String redirectRoot() {
		return "index";
	}
	@RequestMapping(value="/movie", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("movie", movieDao);
		return "movieList";
	}
}
