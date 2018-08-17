package gla.stock.mvc.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gla.stock.mvc.entities.Roles;
import gla.stock.mvc.services.IRolesService;



@Controller
@RequestMapping(value = "/role")
public class RoleController {

	// Déclaration des services internes
		@Autowired
		private IRolesService rolesService;

		@RequestMapping(value = "/")
		public String roles(Model model) {

			List<Roles> roles = rolesService.selectAll();
			if (roles == null) {
				roles = new ArrayList<Roles>();
			}
			model.addAttribute("roles", roles);
			return "role/role";
		}

		@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
		public String ajouterRole(Model model) {
			Roles role = new Roles();

			model.addAttribute("role", role);

			return "role/ajouterRole";
		}

		@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
		public String enregistrerRole(Model model, Roles role) {
			if(role != null) {
				if(role.getIdRole() != null){
					rolesService.update(role);
				}else {
					rolesService.save(role);
					}
			}
			return "redirect:/role/";
		}

		@RequestMapping(value = "/modifier/{idRole}")
		public String modifierRole(Model model, @PathVariable Long idRole) {

			if (idRole != null) {
				Roles role = rolesService.getById(idRole);
				if (role != null) {
					model.addAttribute("role", role);
				}
			}

			return "role/ajouterRole";
		}
		
		@RequestMapping(value="/supprimer/{idRole}")
		public String supprimerRole(Model model, @PathVariable Long idRole){
			
			if (idRole != null) {
				Roles role = rolesService.getById(idRole);
				if (role != null) {
					rolesService.remove(idRole);
				}
			}
			
			return "redirect:/role/";
		}
	
}
