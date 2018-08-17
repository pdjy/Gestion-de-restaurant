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
import gla.stock.mvc.entities.CommandeClient;
import gla.stock.mvc.services.IArticleService;
import gla.stock.mvc.services.IClientService;
import gla.stock.mvc.services.ICommandeClientService;
import gla.stock.mvc.services.IMvtStkService;



@Controller
@RequestMapping(value = "/commandeClient")
public class CommandeClientController {

	// Déclaration des services internes
		@Autowired
		private ICommandeClientService commandeClientService;
		
		@Autowired
		private IClientService clientService;
		
		@Autowired
		private IMvtStkService mvtStkService;
		
		@Autowired
		private IArticleService articleService;

		@RequestMapping(value = "/")
		public String commandeClient(Model model) {

			List<CommandeClient> commandeClients = commandeClientService.selectAll();
			if (commandeClients == null) {
				commandeClients = new ArrayList<CommandeClient>();
			}
			model.addAttribute("commandeClients", commandeClients);
			return "commandeClient/commandeClient";
		}

		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterCommandeClient(Model model) {
			CommandeClient commandeClient = new CommandeClient();
			List<Article> articles = articleService.selectAll();
			if(articles == null){
				//on l'initialise
				articles = new ArrayList<Article>();
			}
			model.addAttribute("articles", articles);
			model.addAttribute("commandeClient", commandeClient);

			return "commandeClient/ajouterCommandeClient";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerCommandeClient(Model model, CommandeClient commandeClient) {
			if(commandeClient != null) {
				if(commandeClient.getIdCommandeClient() != null){
					commandeClientService.update(commandeClient);
				}else {
					commandeClientService.save(commandeClient);
				}
			}
			return "redirect:/commandeClient/";
		}

		@RequestMapping(value = "/modifier/{idCommandeClient}")
		public String modifierCommandeClient(Model model, @PathVariable Long idCommandeClient) {

			if (idCommandeClient != null) {
				CommandeClient commandeClient = commandeClientService.getById(idCommandeClient);
				List<Article> articles = articleService.selectAll();
				if(articles == null){
					articles = new ArrayList<Article>();
				}
				model.addAttribute("articles", articles);
				if (commandeClient != null) {
					model.addAttribute("commandeClient", commandeClient);
				}
			}

			return "commandeClient/ajouterCommandeClient";
		}
		
		@RequestMapping(value="/supprimer/{idCommandeClient}")
		public String supprimerCommandeClient(Model model, @PathVariable Long idCommandeClient){
			
			if (idCommandeClient != null) {
				CommandeClient commandeClient = commandeClientService.getById(idCommandeClient);
				if (commandeClient != null) {
					commandeClientService.remove(idCommandeClient);
				}
			}
			
			return "redirect:/commandeClient/";
		}
	
}
