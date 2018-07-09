/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "cra_malla")
public class CraMalla implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_MALLA", nullable = false, length = 6)
    private String codigo;
    
    @Column(name = "FECHA_ELABORACION")
    @Temporal(TemporalType.DATE)
    private Date fechaElaboracion;
    
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo")
//    private Collection<DetalleMalla> detalleMallaCollection;
    
    @JoinColumn(name = "COD_CARRERA", referencedColumnName = "COD_CARRERA", nullable = false, updatable = false, insertable = false)
    @ManyToOne
    private CraCarrera codCarrera;

    public CraMalla() {
    }

    public CraMalla(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public CraCarrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(CraCarrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CraMalla)) {
            return false;
        }
        CraMalla other = (CraMalla) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Malla{" + "codigo=" + codigo + ", fechaElaboracion=" + fechaElaboracion + ", fechaVigencia=" + fechaVigencia + ", codCarrera=" + codCarrera + '}';
    }
    
}
