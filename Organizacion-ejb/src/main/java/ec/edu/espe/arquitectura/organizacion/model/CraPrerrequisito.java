/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "cra_prerrequisito")
public class CraPrerrequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PRERREQUISITO")
    private Integer codigo;
    
    @JoinColumn(name = "COD_MAT_MALLA", referencedColumnName = "COD_DETALLE_MALLA", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private CraDetalleMalla codMateria;
    
    @JoinColumn(name = "COD_MAT_PRE", referencedColumnName = "COD_DETALLE_MALLA", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private CraDetalleMalla codPreRequisito;
    
    public CraPrerrequisito() {
    }

    public CraPrerrequisito(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public CraDetalleMalla getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(CraDetalleMalla codMateria) {
        this.codMateria = codMateria;
    }

    public CraDetalleMalla getCodPreRequisito() {
        return codPreRequisito;
    }

    public void setCodPreRequisito(CraDetalleMalla codPreRequisito) {
        this.codPreRequisito = codPreRequisito;
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
        if (!(object instanceof CraPrerrequisito)) {
            return false;
        }
        CraPrerrequisito other = (CraPrerrequisito) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prerrequisito{" + "codigo=" + codigo + ", codMateria=" + codMateria + ", codPreRequisito=" + codPreRequisito + '}';
    }

}
