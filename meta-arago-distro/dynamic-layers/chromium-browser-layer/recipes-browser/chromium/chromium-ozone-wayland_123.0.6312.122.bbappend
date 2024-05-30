PR:append = ".arago0"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

CHROMIUM_EXTRA_ARGS:remove = " --use-gl=egl"
CHROMIUM_EXTRA_ARGS:append = " --use-gl=angle"

SRC_URI:append = " \
                  file://0001-chromium-gpu-sandbox-allow-access-to-PowerVR-GPU-fro.patch \
                  file://0002-upstream-fix-incorrect-size-allocation.patch \
                  "
