SUMMARY = "TI Testing packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

TI_TEST_BASE = "\
    bonnie++ \
    hdparm \
    iozone3 \
    lmbench \
    rt-tests \
    evtest \
    bc \
    memtester \
    libdrm-tests \
    dma-heap-tests \
    powertop \
    stress \
    stress-ng \
    yavta \
    perf \
    v4l-utils \
    smcroute \
    rwmem \
    pulseaudio-misc \
    kernel-selftest \
    procps \
    mtd-utils-ubifs-tests \
    pcitest \
    mstpd \
    fio \
    git \
    bridge-utils \
    linuxptp \
    openntpd \
    nbench-byte \
    stream \
    cryptodev-tests \
"

TI_TEST_EXTRAS = " \
    python3-numpy \
    piglit \
"

TI_TEST_BASE:append:armv7a = " \
    cpuburn-neon \
"

TI_TEST_BASE:append:armv7ve = " \
    cpuburn-neon \
"

#    timestamping
TI_TEST_TI_TOOLS = " \
    ltp-ddt \
    input-utils \
    cpuloadgen \
    uvc-gadget \
    arm-benchmarks \
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
