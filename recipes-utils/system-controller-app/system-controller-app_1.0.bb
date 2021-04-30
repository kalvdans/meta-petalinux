DESCRIPTION = "System Contoller App"
SUMMARY = "System Controller App"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI ?= "git://github/Xilinx/system-controller-app.git;branch=master;protocol=https"

SRCREV="54654011e82c036bb851ac49139ed0c143ce6886"

inherit update-rc.d

INITSCRIPT_NAME = "system_controller.sh"
INITSCRIPT_PARAMS = "start 99 S ."

S="${WORKDIR}/git"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_vck-sc = "${MACHINE}"
COMPATIBLE_MACHINE_a2197 = "${MACHINE}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "libgpiod"

do_compile(){
	cd ${S}/build/
	oe_runmake
}

do_install(){
	install -d ${D}/usr/bin/
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}${datadir}/system-controller-app

	cp ${S}/build/sc_app ${D}/usr/bin/
	cp ${S}/build/sc_appd ${D}/usr/bin/
	cp -r ${S}/BIT ${D}${datadir}/system-controller-app/
	install -m 0755 ${S}/src/system_controller.sh ${D}${sysconfdir}/init.d/
}

FILES_${PN} += "${datadir}/system-controller-app /usr/bin"
