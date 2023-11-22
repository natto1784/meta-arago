# Produces wic image for jailhouse

require recipes-core/images/tisdk-default-image.bb

COMPATIBLE_MACHINE = "am62xx|am62pxx"

IMAGE_INSTALL += " jailhouse"

export IMAGE_BASENAME = "tisdk-jailhouse-image"

WIC_CREATE_EXTRA_ARGS:append = " --no-fstab-update"
