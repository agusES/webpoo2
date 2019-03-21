package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.UsuarioBean;
import ar.edu.unnoba.poo2018.model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean isAdmin;
	private String name;
	private String password;
	private static Usuario user = null;

	@EJB
	private UsuarioBean userb;

	public List<Usuario> getUsers() {
		return userb.getAllUsers();
	}

	public String register() {
		System.out.println("Estamos en register().");
		if (userb.findUser(name) == true) {
			System.out.println("Se detectó que el usuario ya está creado. Volviendo a inicio.");
			return "inicio.xhtml?faces-redirect=true";
		} else {
			userb.create(new Usuario(name, password, isAdmin));
			return "inicio.xhtml?faces-redirect=true";
		}
	}

	public String login() {
		user = userb.authUser(name, password);
		System.out.println("Estamos en usuarioController.login(). User = " + user);
		if (user != null) {
			if (user.isAdmin() == true) {
				System.out.println("Se detectó que el usuario es admin. Entramos a homeAdmin.");
				return "homeAdmin.xhtml?faces-redirect=true";
			} else {
				System.out.println("Se detectó que el usuario es un usuario común. Entramos a homeUser.");
				return "homeUser.xhtml?faces-redirect=true";
			}
		} else {
			System.out.println("Volvemos al inicio porque el usuario no se pudo loguear.");
			return "inicio.xhtml?faces-redirect=true";
		}
	}

	public String logout() {
		System.out.println("Entramos al logout(). User = " + user);
		user = null;
		System.out.println("Se ejecutó User = null. Ahora User = " + user);
		return "inicio.xhtml?faces-redirect=true";
	}

	public String inicio() {
		System.out.println("Entramos al inicio(). User = " + user);
		System.out.println("El usuario es admin? " + user.isAdmin());
		if (user.isAdmin() == true) {
			return "homeAdmin.xhtml?faces-redirect=true";
		} else {
			return "homeUser.xhtml?faces-redirect=true";
		}
	}
        public Long getUserId() {
            return user.getId();
        }
	public String getUserName() {
		return user.getName();
	}

	public static Usuario getUser() {
		return user;
	}

	public UsuarioBean getUserb() {
		return userb;
	}

	public void setUserb(UsuarioBean userb) {
		this.userb = userb;
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
