
require recipes-core/packagegroups/packagegroup-core-boot.bb

RDEPENDS:${PN}:remove = "grub-efi kernel"
