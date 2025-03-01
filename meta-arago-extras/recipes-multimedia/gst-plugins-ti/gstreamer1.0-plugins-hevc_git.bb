SUMMARY = "GStreamer plugin for ARM HEVC decoder"
HOMEPAGE = "https://git.ti.com/processor-sdk/gst-plugin-hevc"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=2827f94fc0a1adeff4d9702e97ce2979"

COMPATIBLE_MACHINE = "dra7xx"

SRC_URI = "git://git.ti.com/git/processor-sdk/gst-plugin-hevc.git;protocol=https;branch=master \
           file://0001-configure.ac-stop-using-export-symbols-regex.patch \
           file://0001-Switch-submodule-common-to-github.patch \
"
SRCREV = "e4ea007d0ddeb95ae01742293454ef3c87a6e84c"

S = "${WORKDIR}/git"

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-base hevc-arm-decoder gettext-native"

inherit autotools-brokensep pkgconfig gettext

PR = "r5"

do_configure() {
    cd ${S}
    chmod +x autogen.sh
    ./autogen.sh --host=arm-linux --with-libtool-sysroot=${STAGING_DIR_TARGET} --prefix=/usr
}

EXTRA_OECONF += "--enable-maintainer-mode"
EXTRA_OEMAKE += "'ERROR_CFLAGS=-Wno-deprecated-declarations'"
CFLAGS += "-fcommon"

FILES:${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES:${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES:${PN}-dev += "${libdir}/gstreamer-1.0/*.la"

INSANE_SKIP:${PN} = "textrel"
