package cs544.movie.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.movie.model.Artists;
import cs544.movie.service.ArtistService;

@Controller
public class ArtistController {

	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	@Autowired
	private ArtistService artistService;

	public void setArtistService(ArtistService artistService) {
		this.artistService = artistService;
	}

	@RequestMapping(value = "/artists", method = RequestMethod.GET)
	public String index(Model model) {

		List<Artists> artistList = artistService.getAllArtists();
		model.addAttribute("artistList", artistList);

		return "Artist/artistList";
	}

	@RequestMapping(value = "/artists/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute("artist", new Artists());
		return "Artist/addArtist";
	}

	@RequestMapping(value = "/artists/add", method = RequestMethod.POST)
	public String add(@Valid Artists artist, BindingResult result) {

		System.out.println(result.hasErrors());
		if(result.hasErrors())
			return "Artist/addArtist";
		
		artistService.createArtist(artist);
		return "redirect:/artists";
	}
	
	@RequestMapping(value = "/artists/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model){
		
		Artists artist = artistService.getArtistsById(id);
		model.addAttribute("artist", artist);
		
		return "Artist/updateArtist";
	}
	
	@RequestMapping(value = "/artists/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Artists artist,@PathVariable int id, BindingResult result){
		
		if(result.hasErrors())
			return "redirect:/artists/update/" + id;
		
		artistService.updateArtist(id, artist);
		
		return "redirect:/artists";
	}
	
	@RequestMapping(value = "/artists/delete/{id}", method = RequestMethod.POST )
	public String delete(@PathVariable int id){
		
		artistService.deleteArtists(id);
		return "redirect:/artists";
	}
	

}
