FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
PR:append = ".arago2"

SRC_URI += " \
    file://0001-plugins-decorations-bradient-display-window-icon-onl.patch \
"

PACKAGECONFIG:remove = "xcomposite-egl xcomposite-glx"
