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

import gla.stock.mvc.entities.Utilisateur;
import gla.stock.mvc.services.IRolesService;
import gla.stock.mvc.services.IUtilisateurServive;

@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {

	// Déclaration des services internes
		@Autowired
		private IUtilisateurServive utilisateurService;
		
		private IRolesService role;

		@RequestMapping(value = "/")
		public String utilisateur(Model model) {

			List<Utilisateur> utilisateurs = utilisateurService.selectAll();
			if (utilisateurs == null) {
				utilisateurs = new ArrayList<Utilisateur>();
			}
			model.addAttribute("utilisateurs", utilisateurs);
			return "utilisateur/utilisateur";
		}

		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterUtilisateur(Model model) {
			Utilisateur utilisateur = new Utilisateur();
			model.addAttribute("utilisateur", utilisateur);

			return "utilisateur/ajouterUtilisateur";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerUtilisateur(Model model, Utilisateur utilisateur, MultipartFile file) {

			String photoUrl = null;
			if (utilisateur != null) {
				if (file != null && !file.isEmpty()) {
					InputStream stream = null;
					try {
						stream = file.getInputStream();
						//photoUrl = flickrService.savePhoto(stream, client.getNom());
						utilisateur.setPhoto(photoUrl);
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
				if(utilisateur.getIdUtilisateur() != null){
					utilisateurService.update(utilisateur);
				}else {
					utilisateurService.save(utilisateur);
				}
			}
			return "redirect:/utilisateur/";
		}

		@RequestMapping(value = "/modifier/{idUtilisateur}")
		public String modifierUtilisateur(Model model, @PathVariable Long idUtilisateur) {

			if (idUtilisateur != null) {
				Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
				if (utilisateur != null) {
					model.addAttribute("utilisateur", utilisateur);
				}
			}

			return "utilisateur/ajouterUtilisateur";
		}
		
		@RequestMapping(value="/supprimer/{idUtilisateur}")
		public String supprimerUtilisateur(Model model, @PathVariable Long idUtilisateur){
			
			if (idUtilisateur != null) {
				Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
				
				if (utilisateur != null) {
					utilisateurService.remove(idUtilisateur);
				}
			}
			
			return "redirect:/utilisateur/";
		}
	
}
