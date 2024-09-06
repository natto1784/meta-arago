SUMMARY = "Arago TI SDK super minimal base image for Xen DomU demonstration"

DESCRIPTION = "Arago TI SDK image meant to be run as rootfs for Xen DomU.\
 This image is derived from tisdk-tiny-initramfs image.\
"

require recipes-core/images/tisdk-tiny-initramfs.bb

COMPATIBLE_MACHINE = "am62xx|am62pxx"

export IMAGE_BASENAME = "tisdk-xen-domu${ARAGO_IMAGE_SUFFIX}"
