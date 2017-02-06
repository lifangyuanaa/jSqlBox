/**
 * Copyright (C) 2016 Yong Zhu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.drinkjava2.jsqlbox;

/**
 * This class is for store Sql Mapping Type
 * 
 * @author Yong Zhu
 * @version 1.0.0
 * @since 1.0.0
 */
public enum MappingType {
	ONETOONE, ONETOMANY, MANYTOMANY, TREE;

	public static MappingType getMappingType(String mappingName) {
		if ("ONETOONE".equalsIgnoreCase(mappingName))
			return ONETOONE;
		if ("ONETOMANY".equalsIgnoreCase(mappingName))
			return ONETOMANY;
		if ("MANYTOMANY".equalsIgnoreCase(mappingName))
			return MANYTOMANY;
		if ("TREE".equalsIgnoreCase(mappingName))
			return TREE;
		else
			SqlBoxException.throwEX("MappingType error, \"" + mappingName + "\" is not a legel mapping name.");
		return null;
	}

}