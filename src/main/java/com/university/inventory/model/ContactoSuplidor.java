package com.university.inventory.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "contactos_suplidor",
        uniqueConstraints = @UniqueConstraint(name="uk_suplidor_email", columnNames = {"suplidor_id","email"})
)
public class ContactoSuplidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suplidor_id", nullable = false)
    private Suplidor suplidor;

    @Column(nullable = false) private String nombres;
    @Column(nullable = false) private String apellidos;
    @Column(nullable = false) private String email;
    private String telefono;
    private String cargo;
    @Column(nullable = false) private boolean esPrincipal = false;

    @CreationTimestamp private LocalDateTime creadoEn;
    @UpdateTimestamp  private LocalDateTime actualizadoEn;

    public Long getId() { return id; }
    public Suplidor getSuplidor() { return suplidor; }
    public void setSuplidor(Suplidor suplidor) { this.suplidor = suplidor; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public boolean isEsPrincipal() { return esPrincipal; }
    public void setEsPrincipal(boolean esPrincipal) { this.esPrincipal = esPrincipal; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
    public LocalDateTime getActualizadoEn() { return actualizadoEn; }
}
