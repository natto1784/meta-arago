TI_DEFAULT_BSP = "ti-6_6"

# Remove mmip - DRM allocator, KMS sink, Wayland sink need porting to GST 1.18
MACHINE_FEATURES:remove = "mmip"

# GC320 support requires out-of-tree drivers not available in until LTS prep is
# complete. Disable for now.
MACHINE_FEATURES:remove = "gc320"
