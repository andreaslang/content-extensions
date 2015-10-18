package wekarest

import java.security.MessageDigest

class MD5Extension {

    static String asMD5(byte[] self) {
        def diggest = MessageDigest.getInstance('MD5')
        diggest.update(self)
        return diggest.digest().encodeHex()
    }

    static String asMD5(String self) {
        return asMD5(self.bytes)
    }

}
