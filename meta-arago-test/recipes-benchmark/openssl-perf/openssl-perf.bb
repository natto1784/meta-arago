SUMMARY = "Benchmarks for checking various OpenSSL performance functions"
HOMEPAGE = "https://git.ti.com/cgit/matrix-gui-v2/matrix-gui-v2-apps/tree/cryptos_apps_scripts/"
LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"

PV = "1.0"

SRC_URI = " \
    https://git.ti.com/cgit/matrix-gui-v2/matrix-gui-v2-apps/plain/cryptos_apps_scripts/openssl_perf_scripts/openssl_perf.sh;name=openssl_perf \
    https://git.ti.com/cgit/matrix-gui-v2/matrix-gui-v2-apps/plain/cryptos_apps_scripts/openssl_aes256_encdec_scripts/openssl_aes256_encdec.sh;name=openssl_aes256_encdec \
    https://git.ti.com/cgit/matrix-gui-v2/matrix-gui-v2-apps/plain/LICENSE;name=license \
"
SRC_URI[openssl_perf.sha256sum] = "1ba5188beb6a1fa69d9f34df12c596ed49907c2b2d2ce2d985a305b9ecbed800"
SRC_URI[openssl_aes256_encdec.sha256sum] = "c63efc35f7c161e02ef6d53b428bfbfce7ea3f2d329c552dbb04f865317eb408"
SRC_URI[license.sha256sum] = "7febd1df714fa4b1e44fe0b0f73ceac7f9b9f97326695a0cc7074bd6c8d263e3"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/openssl_perf.sh ${D}${bindir}/openssl_perf.sh
    install -m 0755 ${S}/openssl_aes256_encdec.sh ${D}${bindir}/openssl_aes256_encdec.sh
}

FILES:${PN} = "\
    ${bindir}/openssl_perf.sh \
    ${bindir}/openssl_aes256_encdec.sh \
"

