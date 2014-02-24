package org.geeks.browserdetection

final class VersionHelper {

	/**
	 * Compares versions like x.y.z. It does not support wildcards.
	 *
	 * @return a negative integer, zero, or a positive integer as the first argument is less than,
	 * equal to, or greater than the second
	 */
	static int compare(String v1, String v2){
		checkArguments(v1, v2)

		def v1parts = v1.split("\\.")
		def v2parts = v2.split("\\.")

		def length = Math.min(v1parts.size(), v2parts.size())

		int compRes
		for(int i=0; i<length; i++){
			compRes = v1parts[i].toInteger().compareTo(v2parts[i].toInteger())

			if(compRes != 0){
				return compRes
			}
		}

		// processing the case when rest contains only 0 because
		// 1,0 equals to 1.0.0
		def strMinLength = Math.min(v1.length(), v2.length())
		def rest = v1.substring(strMinLength)
		if(!rest){
			rest = v2.substring(strMinLength)
		}

		if(rest ==~ /(\.|0)+/){
			return 0
		}

		v1parts.size() <=> v2parts.size()
	}

	/**
	 * Checks whether versions are equal. This method supports wildcards.
	 */
	static boolean equals(String v1, String v2){
		checkArguments(v1, v2)

		def wildcardIndex1 = v1.indexOf("*")
		def wildcardIndex2 = v2.indexOf("*")
		def wildcardIndex = wildcardIndex1
		if(wildcardIndex == -1 || (wildcardIndex2 != -1 && wildcardIndex > wildcardIndex2)){
			wildcardIndex = wildcardIndex2
		}

		if(wildcardIndex != -1){
			0 == compare(v1.substring(0, wildcardIndex), v2.substring(0, wildcardIndex))
		} else {
			0 == compare(v1, v2)
		}

	}

	private static void checkArguments(v1, v2){
		if(!v1 || !v2){
			throw new IllegalArgumentException("Versions should not be null or empty")
		}
	}

}