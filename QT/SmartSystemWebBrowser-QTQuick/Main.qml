import QtQuick 2.0
import QtQuick.Controls 1.2
import QtQuick.Window 2.2
import QtWebEngine 1.0
import QtMultimedia 5.0

ApplicationWindow {
    id: application
    property double startTime: new Date().getTime()
    property int welcomeImagetimeoutInterval: 5000
    property int photoTimeoutInterval: 10000
    property int screanSaverTimeoutInterval: 5000
    property string filePath : "file://" + photoHelper.imagePath
    property int loadVideo : 0
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

    Item {
        id: welcomeImage
        visible: true
        x: (application.width - splashImage.width) / 2
        y: (application.height - splashImage.height) / 2
        width: splashImage.width
        height: splashImage.height
        AnimatedImage {
            id: splashImage
            source: "qt-logo.png"
        }
        //! [timer]
        Timer {
            interval: application.welcomeImagetimeoutInterval; running: true; repeat: false
            onTriggered: {
                welcomeImage.visible = false
                showWebviewScrol()
                photoTimer.start()
            }
        }
    }

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


    Item
    {
        id: screenSaver
        visible: false
        height: parent.height
        width: parent.width
        Item
        {
            id:imageItem
            visible: false
            height: parent.height
            width: parent.width
            Image {
                id: photoViewer1
                width: parent.width
                height: parent.height
                x:0
                y:0
                fillMode: Image.PreserveAspectFit
                visible: true
                property string imagePath: "file://" + photoHelper.imagePath
                source: imagePath
            }
            Image {
                id: photoViewer2
                width: parent.width
                height: parent.height
                x:0
                y:0
                fillMode: Image.PreserveAspectFit
                visible: false
                property string imagePath: "file://" + photoHelper.imagePath
                source: imagePath
            }
        }
        Video
        {
            id: video
            property string videoPath: ""
            width : 800
            height : 600
            source: videoPath
            visible: false
        }

        ParallelAnimation {
            id:animationPhotoViewer1

            NumberAnimation { target: photoViewer1; properties: "x,y"; to: 300; duration: 1000 }
            onRunningChanged: {
                if (!animationPhotoViewer1.running)
                {
                    photoViewer1.visible=false
                    photoViewer1.x=0
                    photoViewer1.y=0
                }
            }
        }

        ParallelAnimation {
            id:animationPhotoViewer2

            NumberAnimation { target: photoViewer2; properties: "x,y"; to: 300; duration: 1000 }
            onRunningChanged: {
                if (!animationPhotoViewer2.running)
                {
                    photoViewer2.visible=false
                    photoViewer2.x=0
                    photoViewer2.y=0
                }
            }
        }


        Timer {
            id:nextItemTimer
            interval: application.photoTimeoutInterval
            running: false
            repeat: true
            onTriggered: {
                if(video.playbackState == MediaPlayer.StoppedState)
                {
                    initScreenSaver()
                    if(loadVideo == 0)
                    {
                        if(photoViewer1.visible)
                        {
                            photoViewer2.imagePath= filePath
                            photoViewer2.update()
                            photoViewer2.visible = true
                            photoViewer2.z=0
                            photoViewer1.z=1
                            animationPhotoViewer1.start()
                        }
                        else
                        {
                            photoViewer1.imagePath= filePath
                            photoViewer1.update()
                            photoViewer1.visible = true
                            photoViewer1.z=0
                            photoViewer2.z=1
                            animationPhotoViewer2.start()
                        }
                    }
                }
            }
        }

    }

    MouseArea {
        anchors.fill: parent
        propagateComposedEvents:true
        onClicked: {
            handleClickeEvent(mouse) ;
        }
        onPressed: {
            handleClickeEvent(mouse) ;
        }
        onReleased: {
            handleClickeEvent(mouse) ;
        }
        onDoubleClicked: {
            handleClickeEvent(mouse) ;
        }
        onPositionChanged: {
            handleClickeEvent(mouse) ;
        }
        onPressAndHold: {
            handleClickeEvent(mouse) ;
        }
    }
    Timer {
        id:photoTimer
        interval: application.screanSaverTimeoutInterval
        running: false
        repeat: true
        onTriggered: {
            if(new Date().getTime()-startTime > interval && !screenSaver.visible){
                hideWebviewScrol()
                showScreenSaver()
            }
        }
    }


    function handleClickeEvent(mouse)
    {
        if(screenSaver.visible)
        {
            hideScreenSaver()
            showWebviewScrol()
            startTime=new Date().getTime()
            // as screen saver is visible we have to grabe click event so that not goes to web page
            mouse.accepted = true
        }
        else
        {
            startTime=new Date().getTime()
            mouse.accepted = false
        }        
    }


    function hideScreenSaver()
    {
        screenSaver.visible=false
        nextItemTimer.stop()
    }
    function showScreenSaver()
    {
        initScreenSaver()
        screenSaver.visible=true
    }
    function hideWebviewScrol(){
        webviewScroll.visible=false
    }
    function showWebviewScrol(){
        webviewScroll.visible=true
    }

    function initScreenSaver()
    {
        var dummy = photoHelper.next
        var filePath = "file://" + photoHelper.imagePath
        var indexOfDot = filePath.indexOf(".") ;
        if(filePath.substring(indexOfDot,filePath.length) == ".jpg")
        {
            loadVideo = 0
            // image found
            imageItem.visible=true
            //photoViewer1.source = filePath
            //photoViewer2.source = filePath
            video.visible=false
        }
        else
        {
            loadVideo = 1
            video.visible=true
            imageItem.visible=false
            video.videoPath = filePath
            video.play()
        }
        nextItemTimer.restart()
    }


}
