FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://network.cfg \
	file://utils.cfg \
"

PR:append = ".arago22"
