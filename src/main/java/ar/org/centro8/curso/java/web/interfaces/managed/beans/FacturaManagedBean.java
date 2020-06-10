package ar.org.centro8.curso.java.web.interfaces.managed.beans;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("facturaMB")
@SessionScoped
public class FacturaManagedBean implements Serializable{
    private Factura factura;
    private String mensaje;
    private I_FacturaRepository fr=new FacturaRepository(Connector.getConnection());
    private int buscarIdCliente;

    public FacturaManagedBean() {
        mensaje="";
        factura=new Factura();
    }
    
    public void save(){
        fr.save(factura);
    }
    
    public List<Factura> getAll(){
        return fr.getAll();
    }
    
    public List<Factura> getByIdCliente(){
        return fr.getByIdCliente(buscarIdCliente);
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getBuscarIdCliente() {
        return buscarIdCliente;
    }

    public void setBuscarIdCliente(int buscarIdCliente) {
        this.buscarIdCliente = buscarIdCliente;
    }
    
    
    
}
