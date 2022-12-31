package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {

		System.out.println(repo.findByTechSorted("java"));
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}

	@RequestMapping("/getAllAlien")
	public Iterable<Alien> getAllAlien() {

		return repo.findAll();

	}

	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {

		repo.deleteById(aid);
		return "home.jsp";

	}

	@RequestMapping("/updateAlien")
	public String updateAlien(@RequestParam int aid, String aname) {
		Alien alien = repo.findById(aid).orElse(new Alien());
		alien.setAname(aname);
		repo.save(alien);
		return "home.jsp";

	}

	// The following are REST API representation
	// we dont have to use ResponseBody everywhere
	// we can use @RestController on line 19

	@GetMapping(path="/aliens")
	@ResponseBody
	public List<Alien> getAliensREST() {
		return repo.findAll();
	}


	@PostMapping("/alien")
	@ResponseBody
	public Alien addAlienRest(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PutMapping("/alien")
	@ResponseBody
	public Alien saveOrUpdateAlienRest(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienREST(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	
	@DeleteMapping("/alien/{aid}")
	@ResponseBody
	public String deleteAlienRESFT(@PathVariable int aid)
	{
		Alien a = repo.findById(aid).orElse(null);
		repo.delete(a);
		
		return "deleted";
	}

}
