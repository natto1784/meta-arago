
PREFERRED_VERSION_linux-ti-staging = "6.6%"
PREFERRED_VERSION_linux-ti-staging-rt = "6.6%"
PREFERRED_VERSION_linux-ti-staging-systest = "6.6%"
PREFERRED_VERSION_u-boot-ti-staging = "2024.04%"
PREFERRED_VERSION_ti-img-rogue-umlibs = "24.1.6554834"
PREFERRED_VERSION_ti-img-rogue-driver = "24.1.6554834"
PREFERRED_VERSION_mesa-pvr = "23.2.1"

# Remove mmip - DRM allocator, KMS sink, Wayland sink need porting to GST 1.18
MACHINE_FEATURES:remove = "mmip"

# GC320 support requires out-of-tree drivers not available in until LTS prep is
# complete. Disable for now.
MACHINE_FEATURES:remove = "gc320"

PREFERRED_PROVIDER_virtual/gpudriver:am335x-evm = ""
PREFERRED_PROVIDER_virtual/gpudriver:am335x-hs-evm = ""
PREFERRED_PROVIDER_virtual/gpudriver:am437x-evm = ""
PREFERRED_PROVIDER_virtual/gpudriver:am437x-hs-evm = ""
PREFERRED_PROVIDER_virtual/gpudriver:am57xx-evm = ""
PREFERRED_PROVIDER_virtual/gpudriver:am57xx-hs-evm = ""
PREFERRED_PROVIDER_virtual/gpudriver:am65xx-evm = ""
