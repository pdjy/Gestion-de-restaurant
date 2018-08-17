package gla.stock.mvc.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import gla.stock.mvc.entities.Article;
import gla.stock.mvc.entities.MvtStk;
import gla.stock.mvc.services.IArticleService;
import gla.stock.mvc.services.IMvtStkService;



@Controller
@RequestMapping(value = "/mvtStk")
public class MvtStkController {

	// Déclaration des services internes
		@Autowired
		private IMvtStkService mvtStkService;
		
		@Autowired
		private IArticleService articleService;

		@RequestMapping(value = "/")
		public String mvtStk(Model model) {

			List<MvtStk> mvtStks = mvtStkService.selectAll();
			if (mvtStks == null) {
				mvtStks = new ArrayList<MvtStk>();
			}
			model.addAttribute("mvtStks", mvtStks);
			return "mvtStk/mvtStk";
		}

		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterMvtStk(Model model) {
			MvtStk mvtStk = new MvtStk();
			List<Article> articles = articleService.selectAll();
			if(articles == null){
				//on l'initialise
				articles = new ArrayList<Article>();
			}
			model.addAttribute("mvtStk", mvtStk);
			model.addAttribute("articles", articles);

			return "mvtStk/ajouterMvtStk";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerMvtStk(Model model, MvtStk mvtStk) {
			if(mvtStk != null) {
				if(mvtStk.getIdMvtStk() != null){
					mvtStkService.update(mvtStk);
				}else {
					mvtStkService.save(mvtStk);
				}
			}
			return "redirect:/mvtStk/";
		}

		@RequestMapping(value = "/modifier/{idMvtStk}")
		public String modifierMvtStk(Model model, @PathVariable Long idMvtStk) {

			if (idMvtStk != null) {
				MvtStk mvtStk = mvtStkService.getById(idMvtStk);
				List<Article> articles = articleService.selectAll();
				if(articles == null){
					articles = new ArrayList<Article>();
				}
				model.addAttribute("articles", articles);
				if (mvtStk != null) {
					model.addAttribute("mvtStk", mvtStk);
				}
			}

			return "mvtStk/ajouterMvtStk";
		}
		
		@RequestMapping(value="/supprimer/{idMvtStk}")
		public String supprimerMvtStk(Model model, @PathVariable Long idMvtStk){
			
			if (idMvtStk != null) {
				MvtStk mvtStk = mvtStkService.getById(idMvtStk);
				if (mvtStk != null) {
					mvtStkService.remove(idMvtStk);
				}
			}
			
			return "redirect:/mvtStk/";
		}
	
}
