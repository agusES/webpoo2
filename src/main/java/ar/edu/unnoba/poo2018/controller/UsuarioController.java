package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.UsuarioBean;
import ar.edu.unnoba.poo2018.model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;

@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController {

	private boolean isAdmin;
	private String name;
	private String password;

	@EJB
	private UsuarioBean userb;

	public String register() {
		if (userb.findUser(name) == true) {
			return "usernameInUse";
		} else {
			userb.create(new Usuario(name, password, isAdmin));
			return "success";
		}
	}

	public String logout() {
		return "logout";
	}

	public String inicio() {
		return "inicio.xhtml?faces-redirect=true";
	}

	public String login() {
		Usuario authuser = userb.authUser(name, password);

		if (authuser != null) {
			if (authuser.isAdmin() == true) {
				return "successAdmin";
			} else {
				return "successUser";
			}
		}
		return "invalid";
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
