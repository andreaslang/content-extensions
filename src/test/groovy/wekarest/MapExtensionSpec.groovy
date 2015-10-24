package wekarest

import spock.lang.Specification

class MapExtensionSpec extends Specification {

    def "should merge simple maps"() {
        given:
        def base = [
            a: 'abc',
            b: '1'
        ]
        def other = [
            a: 'override',
            c: 'new'
        ]
        MapExtension.mergeRecursive(base, other)

        expect:
        base == [
            a: 'override',
            b: '1',
            c: 'new'
        ]
    }

    def "should merge recursive"() {
        given:
        def base = [
                a: [aa1: 'base', aa2: 'base'],
                b: [other: 'b']
        ]
        def other = [
                a: [aa1: 'override', aa3: 'add'],
                c: [other: 'c']
        ]
        MapExtension.mergeRecursive(base, other)

        expect:
        base == [
                a: [aa1: 'override', aa2: 'base', aa3: 'add'],
                b: [other: 'b'],
                c: [other: 'c']
        ]
    }
}
