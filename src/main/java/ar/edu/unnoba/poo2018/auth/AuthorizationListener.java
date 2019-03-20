package ar.edu.unnoba.poo2018.auth;

import ar.edu.unnoba.poo2018.controller.UsuarioController;
import ar.edu.unnoba.poo2018.model.Usuario;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthorizationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();

		UsuarioController usuarioController = null;
		Usuario currentUser = null;
		
		try {
			usuarioController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{usuarioController}",
					UsuarioController.class);
		} catch (Exception e) {
			System.out.println("Algo salió mal en el método afterPhase.");
		}
		
		if (usuarioController != null) {
			currentUser = (Usuario) UsuarioController.getUser();
		}

		if (currentUser == null) {
			if (!currentPage.equals("/inicio.xhtml") && !currentPage.equals("/register.xhtml")) {
				NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
				nh.handleNavigation(facesContext, null, "/inicio.xhtml?faces-redirect=true");
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
