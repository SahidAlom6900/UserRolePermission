package com.technoelevate.user_service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role_details")
@JsonInclude(value = Include.NON_DEFAULT)
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	private String roleName;

	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private List<User> users;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_permission", inverseJoinColumns = 
	@JoinColumn(name = "permission_id", referencedColumnName = "permissionId", insertable = false, updatable = false), joinColumns = 
	@JoinColumn(name = "role_id", referencedColumnName = "roleId", insertable = false, updatable = false))
//	@JsonManagedReference
	private List<Permission> permissions;

}
