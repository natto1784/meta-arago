# Disable the "buildpaths" check while upstream oe-core figures out
# how they are going to address it.  This will hopefully be a short
# lived patch.
INSANE_SKIP:${PN} += "buildpaths"
