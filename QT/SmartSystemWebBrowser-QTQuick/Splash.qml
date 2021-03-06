import QtQuick 2.0
import QtQuick.Window 2.1

//! [splash-properties]
Window {
    id: splash
    color: "transparent"
    visible: true
    title: "Splash Window"
    modality: Qt.ApplicationModal
    flags: Qt.SplashScreen
    property int timeoutInterval: 2000
    signal timeout
//! [splash-properties]
//! [screen-properties]
    x: (application.width - splashImage.width) / 2
    y: (application.height - splashImage.height) / 2
//! [screen-properties]
    width: splashImage.width
    height: splashImage.height


    AnimatedImage {
        id: splashImage
        source: "qt-logo.png"
        MouseArea {
            anchors.fill: parent
            onClicked: Qt.quit()
        }
    }
    //! [timer]
    Timer {
        interval: timeoutInterval; running: true; repeat: false
        onTriggered: {
            visible = false
            splash.timeout()
        }
    }
    //! [timer]
    Component.onCompleted: visible = true
}
