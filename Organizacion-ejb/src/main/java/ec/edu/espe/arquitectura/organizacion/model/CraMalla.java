/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "cra_malla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CraMalla.findAll", query = "SELECT c FROM CraMalla c")
    , @NamedQuery(name = "CraMalla.findByCodMalla", query = "SELECT c FROM CraMalla c WHERE c.codMalla = :codMalla")
    , @NamedQuery(name = "CraMalla.findByFechaElaboracion", query = "SELECT c FROM CraMalla c WHERE c.fechaElaboracion = :fechaElaboracion")
    , @NamedQuery(name = "CraMalla.findByFechaVigencia", query = "SELECT c FROM CraMalla c WHERE c.fechaVigencia = :fechaVigencia")})
public class CraMalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COD_MALLA")
    private String codMalla;
    @Column(name = "FECHA_ELABORACION")
    @Temporal(TemporalType.DATE)
    private Date fechaElaboracion;
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;
    @JoinColumn(name = "COD_CARRERA", referencedColumnName = "COD_CARRERA")
    @ManyToOne(optional = false)
    private CraCarrera codCarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMalla")
    private Collection<CraDetalleMalla> craDetalleMallaCollection;

    public CraMalla() {
    }

    public CraMalla(String codMalla) {
        this.codMalla = codMalla;
    }

    public String getCodMalla() {
        return codMalla;
    }

    public void setCodMalla(String codMalla) {
        this.codMalla = codMalla;
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

    @XmlTransient
    public Collection<CraDetalleMalla> getCraDetalleMallaCollection() {
        return craDetalleMallaCollection;
    }

    public void setCraDetalleMallaCollection(Collection<CraDetalleMalla> craDetalleMallaCollection) {
        this.craDetalleMallaCollection = craDetalleMallaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMalla != null ? codMalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CraMalla)) {
            return false;
        }
        CraMalla other = (CraMalla) object;
        if ((this.codMalla == null && other.codMalla != null) || (this.codMalla != null && !this.codMalla.equals(other.codMalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.organizacion.model.CraMalla[ codMalla=" + codMalla + " ]";
    }
    
}
