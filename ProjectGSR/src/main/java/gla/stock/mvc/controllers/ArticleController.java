package gla.stock.mvc.controllers;


import java.io.IOException;
import java.io.InputStream;
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
import gla.stock.mvc.entities.Categorie;
import gla.stock.mvc.services.IArticleService;
import gla.stock.mvc.services.ICategorieService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	
	// Déclaration des services internes
		@Autowired
		private IArticleService articleService;
		
		@Autowired
		private ICategorieService categorieService;

		//Index qui permet d'afficher la liste des articles
		@RequestMapping(value = "/")
		public String article(Model model) {

			List<Article> articles = articleService.selectAll();
			if (articles == null) {
				articles = new ArrayList<Article>();
			}
			model.addAttribute("articles", articles);
			return "article/article";
		}

		//Methode permettant retourner la page ajouter article
		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterArticle(Model model) {
			Article article = new Article();
			List<Categorie> categories = categorieService.selectAll();
			if(categories == null){
				//on l'initialise
				categories = new ArrayList<Categorie>();
			}
			model.addAttribute("article", article);
			model.addAttribute("categories", categories);

			return "article/ajouterArticle";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerArticle(Model model, Article article, MultipartFile file) {

			String photoUrl = null;
			if (article != null) {
				if (file != null && !file.isEmpty()) {
					InputStream stream = null;
					try {
						stream = file.getInputStream();
						//photoUrl = flickrService.savePhoto(stream, client.getNom());
						article.setPhoto(photoUrl);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							stream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(article.getIdArticle() != null){
					articleService.update(article);
				}else {

					articleService.save(article);
				}
			}
			
			return "redirect:/article/";
		}

		@RequestMapping(value = "/modifier/{idArticle}")
		public String modifierArticle(Model model, @PathVariable Long idArticle) {

			if (idArticle != null) {
				Article article = articleService.getById(idArticle);
				List<Categorie> categories = categorieService.selectAll();
				if(categories == null){
					categories = new ArrayList<Categorie>();
				}
				model.addAttribute("categories", categories);
				if (article != null) {
					model.addAttribute("article", article);
				}
			}

			return "article/ajouterArticle";
		}
		
		@RequestMapping(value="/supprimer/{idArticle}")
		public String supprimerClient(Model model, @PathVariable Long idArticle){
			
			if (idArticle != null) {
				Article article = articleService.getById(idArticle);
				if (article != null) {
					articleService.remove(idArticle);
				}
			}
			
			return "redirect:/article/";
		}

}
