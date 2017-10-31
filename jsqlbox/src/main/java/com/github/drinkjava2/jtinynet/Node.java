/*
 * Copyright (C) 2016 Yong Zhu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.github.drinkjava2.jtinynet;

import java.util.HashSet;
import java.util.Set;

/**
 * Node is a POJO represents a Node in entity net, Node allow have many parents,
 * but Node do not allow have child node, so "Many to one" is the only
 * relationship allowed in EntityNet system, exact like Relational Database, so
 * it's easy to translate a Relational Database into an EntityNet.
 * 
 * @author Yong Zhu (Yong9981@gmail.com)
 * @since 1.0.0
 */
public class Node {
	/**
	 * a unique String ID generated by EntityNet, usually format is
	 * className...idvalue for singly key, or
	 * className...idValue1...idValue2...idValueN for compound keys
	 */
	String id;

	Object entity;

	Object entityClass;

	/** Label is not unique, many nodes can have same label name */
	String label;

	public Node(String id, Object entity) {
		this.id = id;
		this.entity = entity;
		if (entity != null)
			this.entityClass = entity.getClass();
	}

	public Node(String id, Object entity, Set<String> parentIDs) {
		this(id, entity);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Object getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Object entityClass) {
		this.entityClass = entityClass;
	}

}
