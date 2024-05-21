SUMMARY = "Helper script for OE's llvm support"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://llvm-config"

ALLOW_EMPTY:${PN} = "1"
SYSROOT_PREPROCESS_FUNCS:append:class-target = " llvm_common_sysroot_preprocess"

llvm_common_sysroot_preprocess() {
    install -d ${SYSROOT_DESTDIR}${bindir_crossscripts}/
    install -m 0755 ${UNPACKDIR}/llvm-config ${SYSROOT_DESTDIR}${bindir_crossscripts}/
}

do_install:class-native() {
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/llvm-config ${D}${bindir}
}

BBCLASSEXTEND = "native"
