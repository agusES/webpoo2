package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "usuario.findbyNameAndPassword",
            query = "SELECT u FROM Usuario u where u.name = :value1 and u.password = :value2"),
    @NamedQuery(name = "usuario.allUsuarios",
            query = "SELECT u FROM Usuario u"),
})

public class Usuario {
    
    @Id
    @SequenceGenerator(name = "ID_USUARIO_SEQ", sequenceName = "SEQ_USUARIO", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USUARIO_SEQ")
    private long id;

    private String name;
    private String password;
    private boolean administrador;
    
    @Version
    protected int version;

    public Usuario() {
    }

    public Usuario(String name, String password, boolean administrador) {
        this.name = name;
        this.password = password;
        this.administrador = administrador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isAdmin() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + name + ", password=" + password + ", administrador=" + administrador + "]";
    }

}
