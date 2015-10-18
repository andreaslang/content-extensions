package wekarest

import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream


class ZipExtension {

    static byte[] zip(byte[] self) {
        def out = new ByteArrayOutputStream()
        new GZIPOutputStream(out).withCloseable { stream ->
            stream.setBytes(self)
        }
        return out.toByteArray()
    }

    static byte[] unzip(byte[] self) {
        def byteArrayInputStream = new ByteArrayInputStream(self)
        def zipInputStream = new GZIPInputStream(byteArrayInputStream)
        return zipInputStream.getBytes()
    }

}
