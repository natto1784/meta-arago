
PREFERRED_VERSION_linux-ti-staging = "6.6%"
PREFERRED_VERSION_linux-ti-staging-rt = "6.6%"
PREFERRED_VERSION_linux-ti-staging-systest = "6.6%"
PREFERRED_VERSION_u-boot-ti-staging = "2024.01%"

# Remove mmip - DRM allocator, KMS sink, Wayland sink need porting to GST 1.18
MACHINE_FEATURES:remove = "mmip"

# GC320 support requires out-of-tree drivers not available in until LTS prep is
# complete. Disable for now.
MACHINE_FEATURES:remove = "gc320"
