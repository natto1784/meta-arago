inherit update-alternatives

ALTERNATIVE:${PN}-programs += "hello"
ALTERNATIVE_LINK_NAME[hello] = "${bindir}/hello"
