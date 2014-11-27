package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role_master database table.
 * 
 */
@Entity
@Table(name="role_master")
@NamedQuery(name="RoleMaster.findAll", query="SELECT r FROM RoleMaster r")
public class RoleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String role;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to RoleMenuMap
	@OneToMany(mappedBy="roleMaster")
	private List<RoleMenuMap> roleMenuMaps;

	public RoleMaster() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public List<RoleMenuMap> getRoleMenuMaps() {
		return this.roleMenuMaps;
	}

	public void setRoleMenuMaps(List<RoleMenuMap> roleMenuMaps) {
		this.roleMenuMaps = roleMenuMaps;
	}

	public RoleMenuMap addRoleMenuMap(RoleMenuMap roleMenuMap) {
		getRoleMenuMaps().add(roleMenuMap);
		roleMenuMap.setRoleMaster(this);

		return roleMenuMap;
	}

	public RoleMenuMap removeRoleMenuMap(RoleMenuMap roleMenuMap) {
		getRoleMenuMaps().remove(roleMenuMap);
		roleMenuMap.setRoleMaster(null);

		return roleMenuMap;
	}

}