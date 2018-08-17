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
import gla.stock.mvc.entities.Vente;
import gla.stock.mvc.services.IArticleService;
import gla.stock.mvc.services.IMvtStkService;
import gla.stock.mvc.services.IVenteService;



@Controller
@RequestMapping(value = "/vente")
public class VenteController {

	// Déclaration des services internes
		@Autowired
		private IVenteService venteService;
		
		@Autowired
		private IMvtStkService mvtStkService;
		
		@Autowired
		private IArticleService articleService;

		@RequestMapping(value = "/")
		public String vente(Model model) {

			List<Vente> ventes = venteService.selectAll();
			if (ventes == null) {
				ventes = new ArrayList<Vente>();
			}
			model.addAttribute("ventes", ventes);
			return "vente/vente";
		}

		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterVente(Model model) {
			Vente vente = new Vente();
			List<Article> articles = articleService.selectAll();
			if(articles == null){
				//on l'initialise
				articles = new ArrayList<Article>();
			}
			model.addAttribute("articles", articles);
			model.addAttribute("vente", vente);

			return "vente/ajouterVente";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerVente(Model model, Vente vente) {
			if(vente != null) {
				if(vente.getIdVente() != null){
					venteService.update(vente);
				}else {
	
					venteService.save(vente);
				}
			}
			return "redirect:/vente/";
		}

		@RequestMapping(value = "/modifier/{idVente}")
		public String modifierVente(Model model, @PathVariable Long idVente) {

			if (idVente != null) {
				Vente vente = venteService.getById(idVente);
				List<Article> articles = articleService.selectAll();
				if(articles == null){
					articles = new ArrayList<Article>();
				}
				model.addAttribute("articles", articles);
				if (vente != null) {
					model.addAttribute("vente", vente);
				}
			}

			return "vente/ajouterVente";
		}
		
		@RequestMapping(value="/supprimer/{idVente}")
		public String supprimerVente(Model model, @PathVariable Long idVente){
			
			if (idVente != null) {
				Vente vente = venteService.getById(idVente);
				if (vente != null) {
					venteService.remove(idVente);
				}
			}
			
			return "redirect:/vente/";
		}
	
}
