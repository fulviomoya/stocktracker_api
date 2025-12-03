package com.university.inventory.contactSupplier.model;

import com.university.inventory.supplier.model.Supplier;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "contactos_suplidor",
        uniqueConstraints = @UniqueConstraint(name="uk_suplidor_email", columnNames = {"suplidor_id","email"})
)
public class SupplierContact {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID supplier;

    @Column(nullable = false) private String nombres;
    @Column(nullable = false) private String apellidos;
    @Column(nullable = false) private String email;
    private String telefono;
    private String cargo;
    @Column(nullable = false) private boolean esPrincipal = false;

    @CreationTimestamp private LocalDateTime creadoEn;
    @UpdateTimestamp  private LocalDateTime actualizadoEn;

    public UUID getId() { return id; }
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
