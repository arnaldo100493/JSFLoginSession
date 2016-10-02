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
public class ManagedBeanSession {

    private String usuario;

    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;

    /**
     * Creates a new instance of ManagedBeanSession
     */
    public ManagedBeanSession() {
        this.facesContext = FacesContext.getCurrentInstance();
        this.httpServletRequest = (HttpServletRequest) this.facesContext.getExternalContext().getRequest();
        if (this.httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            this.usuario = this.httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    public String cerrarSesion() {
        this.httpServletRequest.getSession().removeAttribute("sessionUsuario");
        this.facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada correctamente.", null);
        this.facesContext.addMessage(null, this.facesMessage);
        return "index";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
