package wekarest

class MapExtension {

    static Map mergeRecursive(Map self, Map other) {
        other.each { key, otherValue ->
            if (self.containsKey(key)) {
                def selfValue = self[key]
                if (isMap(selfValue) && isMap(otherValue))
                    mergeRecursive(selfValue, otherValue)
                else
                    self[key] = otherValue
            } else
                self[key] = otherValue

        }
    }

    static boolean isMap(self) {
        Map.isAssignableFrom(self.getClass())
    }


}
