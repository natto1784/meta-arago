SUMMARY = "TI Testing packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

TI_TEST_BASE = "\
    bc \
    bonnie++ \
    bridge-utils \
    cryptodev-tests \
    dma-heap-tests \
    evtest \
    fio \
    git \
    hdparm \
    iozone3 \
    kernel-selftest \
    libdrm-tests \
    linuxptp \
    lmbench \
    memtester \
    mstpd \
    mtd-utils-ubifs-tests \
    nbench-byte \
    openntpd \
    pcitest \
    perf \
    powertop \
    procps \
    pulseaudio-misc \
    rt-tests \
    rwmem \
    smcroute \
    stream \
    stress \
    stress-ng \
    v4l-utils \
    yavta \
"

TI_TEST_EXTRAS = " \
    piglit \
    python3-numpy \
"

TI_TEST_BASE:append:armv7a = " \
    cpuburn-neon \
"

TI_TEST_BASE:append:armv7ve = " \
    cpuburn-neon \
"

#    timestamping
TI_TEST_TI_TOOLS = " \
    arm-benchmarks \
    cpuloadgen \
    input-utils \
    ltp-ddt \
    uvc-gadget \
"

TI_TEST_TI_TOOLS:append:ti33x = " \
    omapconf \
"

TI_TEST_TI_TOOLS:append:ti43x = " \
    omapconf \
"

NOT_MAINLINE_MMIP_DEPS = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)}"

TI_TEST_TI_TOOLS:append:omap-a15 = " \
    omapconf \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', " \
        ti-ipc-test \
	    ${NOT_MAINLINE_MMIP_DEPS} \
    ", d)} \
"

TI_TEST_TI_TOOLS:append:k3 = " \
    k3conf \
"

TI_TEST_TI_TOOLS:append:j721e = " \
    ufs-utils \
"

# Disable due to breakage
#    viddec-test-app 
TI_TEST_TI_TOOLS:append:j721e = " \
    videnc-test-app \
"

TI_TEST_TI_TOOLS:append:omapl138 = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', 'ti-ipc-test', d)} \
"

RDEPENDS:${PN} = "\
    ${TI_TEST_BASE} \
    ${TI_TEST_TI_TOOLS} \
"

# Package group for things that should only be present in tisdk-default-image
PACKAGES += " ${PN}-extras"
RDEPENDS:${PN}-extras = "\
    ${TI_TEST_EXTRAS} \
"
