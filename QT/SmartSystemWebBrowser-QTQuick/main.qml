import QtQuick 2.0
import QtQuick.Controls 1.2
import QtQuick.Window 2.2
import QtWebEngine 1.0

ApplicationWindow {
    id: application
    property double startTime: new Date().getTime()
    title: qsTr("Smart System")
    //visibility: "FullScreen"
    width: 800
    height: 480
    color: "#000000"
    //color: "#00000000"
    maximumWidth: 800
    maximumHeight: 480
    visible: true
    flags: Qt.FramelessWindowHint | Qt.WindowStaysOnTopHint

    WebEngineView {
        id: webviewScroll
        visible: true
        //url: "http://127.0.0.1:8080/MySmartHome-New"
        //url:"http://www.google.com"
        url: configuration.url
        anchors.fill: parent
        width: parent.width
        height: parent.height
    }

    Image {
        id: photoViewer
        width: parent.width
        height: parent.height
        fillMode: Image.PreserveAspectFit
        visible: false
        source: "file://" + photoHelper.imagePath
    }

    MouseArea {
        anchors.fill: parent
        propagateComposedEvents:true
        onClicked: {
            handleClickeEventForPhotoViewer(mouse) ;
        }
        onPressed: {
            handleClickeEventForPhotoViewer(mouse) ;
        }
        onReleased: {
            handleClickeEventForPhotoViewer(mouse) ;
        }
        onDoubleClicked: {
            handleClickeEventForPhotoViewer(mouse) ;
        }
        onPositionChanged: {
            handleClickeEventForPhotoViewer(mouse) ;
        }
        onPressAndHold: {
            handleClickeEventForPhotoViewer(mouse) ;
        }
    }
    Item {
        Timer {
            interval: 5000; running: true; repeat: true
            onTriggered: {
                time.text=startTime.toString();
                if(new Date().getTime()-startTime > interval && parent.visible)
                {
                    photoHelper.next
                    photoViewer.update()
                    time.text=new Date().getTime().toString() + "hmm";
                    hideWebviewScrol()
                    showPhotoViewer()
                }
            }
        }

        Text { id: time }
    }

    function handleClickeEventForPhotoViewer(mouse)
    {
        if(photoViewer.visible)
        {
            hidePhotoViewer()
            showWebviewScrol()
            startTime=new Date().getTime()
        }
        else
        {
            startTime=new Date().getTime()
        }
        mouse.accepted = false
    }


    function hidePhotoViewer()
    {
        photoViewer.visible=false
    }
    function showPhotoViewer()
    {
        photoViewer.visible=true
    }
    function hideWebviewScrol(){
        webviewScroll.visible=false
    }
    function showWebviewScrol(){
        webviewScroll.visible=true
    }

/*
    property var splashWindow: Splash {
        onTimeout: showWebviewScrol()
    }
*/
}
