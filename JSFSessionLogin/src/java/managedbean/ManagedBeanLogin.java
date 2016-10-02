/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author FABAME
 */
@ManagedBean
@SessionScoped
public class ManagedBeanLogin {

    private String usuario;
    private String contrasenia;

    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;

    /**
     * Creates a new instance of ManagedBeanLogin
     */
    public ManagedBeanLogin() {
        this.facesContext = FacesContext.getCurrentInstance();
        this.httpServletRequest = (HttpServletRequest) this.facesContext.getExternalContext().getRequest();
    }

    public String login() {
        if (this.usuario.equals("arnaldo100493") && this.contrasenia.equals("100493")) {
            this.httpServletRequest.getSession().setAttribute("sessionUsuario", this.usuario);
            this.facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto.", null);
            this.facesContext.addMessage(null, this.facesMessage);
            return "acceso";
        } else {
            this.facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrectos.", null);
            this.facesContext.addMessage(null, this.facesMessage);
            return "index";
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
