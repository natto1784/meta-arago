SUMMARY = "Arago TI SDK image with Xen Hypervisor"

DESCRIPTION = "Arago TI SDK image meant for running Xen hypervisor. This image\
 is derived from tisdk-default-image and contains the xen image and xen\
 userspace tools\
"

require recipes-core/images/tisdk-default-image.bb

COMPATIBLE_MACHINE = "am62xx|am62pxx"

IMAGE_INSTALL:append = " xen xen-tools"

export IMAGE_BASENAME = "tisdk-xen-image"
