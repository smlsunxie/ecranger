package org.geeks.browserdetection.taglib

/**
 * Describes a hierarchy level as the choice tag and
 * a condition tag
 */
class HierarchyLevelHolder {
	HierarchyLevelType levelType

	/**
	 * It makes sense only for the choice tag
	 */
	Closure otherwise
	boolean successfulCondition
}