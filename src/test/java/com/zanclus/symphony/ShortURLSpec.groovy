package com.zanclus.symphony

import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by dphillips on 2/22/17.
 */
class ShortURLSpec extends Specification {

    protected Object clone() throws CloneNotSupportedException {
        return super.clone()
    }

    @Unroll
    def "Test BigInteger to base62 string conversion"() {
        setup:
            def underTest = new ShortURL()

        expect:
            assert underTest.bigIntToString(BigInteger.valueOf(input)) == output

        where:
            input           || output
            0L              || "0"
            63L             || "11"
            62L             || "10"
            123L            || "1Z"
            2048L           || "x2"
            1234567890L     || "1ly7vk"
            9999999999L     || "aUKYOz"
            0xFFFFFFFFFFFFL || "1hVwxnaA7"
    }
}