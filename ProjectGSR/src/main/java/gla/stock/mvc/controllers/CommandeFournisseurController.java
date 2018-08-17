package gla.stock.mvc.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gla.stock.mvc.entities.Article;
import gla.stock.mvc.entities.CommandeFournisseur;
import gla.stock.mvc.services.IArticleService;
import gla.stock.mvc.services.ICommandeFournisseurService;
import gla.stock.mvc.services.IFournisseurService;
import gla.stock.mvc.services.IMvtStkService;



@Controller
@RequestMapping(value = "/commandeFournisseur")
public class CommandeFournisseurController {

	// Déclaration des services internes
		@Autowired
		private ICommandeFournisseurService commandeFournisseurService;
		
		@Autowired
		private IFournisseurService FournisseurService;
		
		@Autowired
		private IMvtStkService mvtStkService;
		
		@Autowired
		private IArticleService articleService;

		@RequestMapping(value = "/")
		public String commandeFournisseur(Model model) {

			List<CommandeFournisseur> commandeFournisseurs = commandeFournisseurService.selectAll();
			if (commandeFournisseurs == null) {
				commandeFournisseurs = new ArrayList<CommandeFournisseur>();
			}
			model.addAttribute("commandeFournisseurs", commandeFournisseurs);
			return "commandeFournisseur/commandeFournisseur";
		}

		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterCommandeFournisseur(Model model) {
			CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
			List<Article> articles = articleService.selectAll();
			if(articles == null){
				//on l'initialise
				articles = new ArrayList<Article>();
			}
			model.addAttribute("articles", articles);
			model.addAttribute("commandeFournisseur", commandeFournisseur);

			return "commandeFournisseur/ajouterCommandeFournisseur";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerCommandeFournisseur(Model model, CommandeFournisseur commandeFournisseur) {
			if(commandeFournisseur != null) {
				if(commandeFournisseur.getIdCommandeFournisseur() != null){
					commandeFournisseurService.update(commandeFournisseur);
				}else {
					commandeFournisseurService.save(commandeFournisseur);
				}
			}
			return "redirect:/commandeFournisseur/";
		}

		@RequestMapping(value = "/modifier/{idCommandeFournisseur}")
		public String modifierCommandeFournisseur(Model model, @PathVariable Long idCommandeFournisseur) {

			if (idCommandeFournisseur != null) {
				CommandeFournisseur commandeFournisseur = commandeFournisseurService.getById(idCommandeFournisseur);
				List<Article> articles = articleService.selectAll();
				if(articles == null){
					articles = new ArrayList<Article>();
				}
				model.addAttribute("articles", articles);
				if (commandeFournisseur != null) {
					model.addAttribute("commandeFournisseur", commandeFournisseur);
				}
			}

			return "commandeFournisseur/ajouterCommandeFournisseur";
		}
		
		@RequestMapping(value="/supprimer/{idCommandeFournisseur}")
		public String supprimerCommandeFournisseur(Model model, @PathVariable Long idCommandeFournisseur){
			
			if (idCommandeFournisseur != null) {
				CommandeFournisseur commandeFournisseur = commandeFournisseurService.getById(idCommandeFournisseur);
				if (commandeFournisseur != null) {
					commandeFournisseurService.remove(idCommandeFournisseur);
				}
			}
			
			return "redirect:/commandeFournisseur/";
		}
	
}
