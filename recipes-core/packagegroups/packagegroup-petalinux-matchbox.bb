DESCRIPTION = "PetaLinux Matchbox related packages"

inherit packagegroup distro_features_check

REQUIRED_DISTRO_FEATURES = "x11"

MATCHBOX_PACKAGES = " \
	matchbox-config-gtk \
	matchbox-desktop \
	matchbox-keyboard \
	matchbox-keyboard-applet \
	matchbox-panel-2 \
	matchbox-session \
	matchbox-terminal \
	matchbox-theme-sato \
	matchbox-session-sato \
	matchbox-wm \
	settings-daemon \
        adwaita-icon-theme \
	"

RDEPENDS_${PN} = "packagegroup-petalinux-x11 ${MATCHBOX_PACKAGES}"
