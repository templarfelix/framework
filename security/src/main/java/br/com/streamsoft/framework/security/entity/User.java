package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;
import br.com.streamsoft.framework.base.form.FieldType;
import br.com.streamsoft.framework.base.form.FormColumn;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(schema = "SECURITY", name = "USER",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))

@NamedQueries({
        @NamedQuery(name = "USER.FIND_ALL", query = "SELECT u FROM User u "),
        @NamedQuery(name = "USER.FIND_BY_ID",
                query = "SELECT u FROM User u left join fetch u.listRoles left join fetch u.plan where u.id = :id "),
        @NamedQuery(name = "USER.FIND_BY_LOGIN",
                query = "SELECT u FROM User u WHERE TRIM(u.email) = trim(:login) "),
        @NamedQuery(name = "USER.LIKE_BY_NAME",
                query = "SELECT u FROM User u WHERE UPPER(u.name) like UPPER(:name) "),
        @NamedQuery(name = "USER.COUNT_LIKE_BY_NAME",
                query = "SELECT count(*) FROM User u WHERE UPPER(u.name) like UPPER(:name)")})
// WEBSERVICE
@XmlRootElement

public class User extends LogBaseEntityImpl<UUID> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

	/* PK */

    // TODO TESTES DE FORMFIELD
    @FormColumn(description = "security_user", label = "security_user_label", placeholder = "security_user_placeholder")
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Getter
    @Setter
    private UUID id;

    @FormColumn(description = "security_email", label = "security_email_label", placeholder = "security_email_placeholder", filter = true, grid = true)
    @Email
    @NotNull
    @NotEmpty
    @Column(name = "email", unique = true)
    @Getter
    @Setter
    private String email;

    @FormColumn(description = "security_name", label = "security_name_label", placeholder = "security_name_placeholder")
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    /* 1 = actived, 0 = disabled */
    @FormColumn(description = "security_status", label = "security_status_label", placeholder = "security_name_placeholder")
    @NotNull
    @Column(name = "status", length = 1)
    @Getter
    @Setter
    private Long status;

    @FormColumn(type = FieldType.PASSSWORD, description = "security_password", label = "security_password_label", placeholder = "security_password_placeholder")
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_last_login")
    @Getter
    @Setter
    private Date lastLogin;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    @Getter
    @Setter
    private Date birthDay;

    // Control version of Entity
    @Version
    @Getter
    @Setter
    private Long version;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "USER_ROLE", schema = "SECURITY", joinColumns = {
            @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false,
                    updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_role", referencedColumnName = "role", nullable = false,
                    updatable = false)})
    @Getter
    @Setter
    private Set<Role> listRoles;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_plan")
    @Getter
    @Setter
    private Plan plan;
}
