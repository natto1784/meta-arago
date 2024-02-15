FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago1"

# Drop 0001-backend-drm-Select-plane-based-on-current-attached-C.patch once we
# get past version 11.0.1 or commit 94afcbcdc3f1b1cfc050da242c9c70009b007fc6
# upstream

SRC_URI += " \
        file://0001-backend-drm-Select-plane-based-on-current-attached-C.patch \
        file://0001-Revert-require-GL_EXT_unpack_subimage-commit.patch \
        file://0001-backend-drm-Pre-sort-plane-list-by-zpos.patch \
        file://0002-backend-drm-fix-plane-sorting.patch \
        file://0003-drm-backend-Remember-to-set-the-zpos-for-the-scanout.patch \
        file://0004-backend-drm-Assign-plane_idx-by-plane-list-order.patch \
"

# required for weston user to interact with the render devices
inherit extrausers
EXTRA_USERS_PARAMS = " \
	usermod -aG render weston; \
"
