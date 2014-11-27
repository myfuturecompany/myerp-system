package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu_master database table.
 * 
 */
@Entity
@Table(name="menu_master")
@NamedQuery(name="MenuMaster.findAll", query="SELECT m FROM MenuMaster m")
public class MenuMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String imagepath;

	private String menu;

	private String url;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to RoleMenuMap
	@OneToMany(mappedBy="menuMaster")
	private List<RoleMenuMap> roleMenuMaps;

	public MenuMaster() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		roleMenuMap.setMenuMaster(this);

		return roleMenuMap;
	}

	public RoleMenuMap removeRoleMenuMap(RoleMenuMap roleMenuMap) {
		getRoleMenuMaps().remove(roleMenuMap);
		roleMenuMap.setMenuMaster(null);

		return roleMenuMap;
	}

}