PR:append = ".arago0"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}_${PV}:"

SRC_URI:append = " \
                  file://0001-chromium-gpu-sandbox-allow-access-to-PowerVR-GPU-fro.patch \
                  file://0002-upstream-chromium-32307795-fix-nullprt-deref.patch \
                  "
