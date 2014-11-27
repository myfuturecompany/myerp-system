package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_menu_map database table.
 * 
 */
@Entity
@Table(name="role_menu_map")
@NamedQuery(name="RoleMenuMap.findAll", query="SELECT r FROM RoleMenuMap r")
public class RoleMenuMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to RoleMaster
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleMaster roleMaster;

	//bi-directional many-to-one association to MenuMaster
	@ManyToOne
	@JoinColumn(name="menu_id")
	private MenuMaster menuMaster;

	public RoleMenuMap() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

	public MenuMaster getMenuMaster() {
		return this.menuMaster;
	}

	public void setMenuMaster(MenuMaster menuMaster) {
		this.menuMaster = menuMaster;
	}

}