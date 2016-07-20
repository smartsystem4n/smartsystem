#include <QApplication>
#include <QDesktopWidget>
#include <QQmlApplicationEngine>
#include <QDesktopServices>
#include <QUrl>
#include <QQmlContext>
#include <QQmlComponent>
#include <QProcess>
#include <QGraphicsSceneMouseEvent>
#include<photohelper.h>
#include<configuration.h>
#include <qtwebengineglobal.h>
#include <QQuickView>
#include <QThread>
static QProcess browser ;
static QString browserAndURL = "firefox \"http://www.google.com\"";
//static QString browserAndURL = "epiphany-browser -a --profile /home/pi/.browser-config \"http://www.google.com\"";
int main(int argc, char *argv[])
{
    //browser.start(browserAndURL);
    QGuiApplication app(argc, argv);
    qDebug() << "app" ;
    QtWebEngine::initialize();
    qDebug() << "QtWebEngine init" ;
    QQmlEngine engine;
    Configuration configuration;
    PhotoHelper photoHelper(configuration.getPath()) ;
    engine.rootContext()->setContextProperty("photoHelper", &photoHelper);
    qDebug() << "photohelper set" ;
    engine.rootContext()->setContextProperty("configuration", &configuration);
    qDebug() << "configuration set" ;
    QQmlComponent component(&engine, QUrl(QStringLiteral("qrc:/Main.qml")));
    qDebug() << "QML add" ;
    QObject *object = component.create();
    if(component.status() == QQmlComponent::Error)
    {
        qDebug() << component.errorString();
    }
    qDebug() << "component created" ;
    app.exec();

/*
    QGuiApplication app(argc, argv);
    qDebug() << "app" ;
    QtWebEngine::initialize();
    QQuickView view;

    view.setSource(QUrl(QStringLiteral("qrc:/main.qml")));
    Configuration configuration(&view) ;
    PhotoHelper photoHelper(configuration.getPath()) ;
    view.engine()->rootContext()->setContextProperty("photoHelper", &photoHelper);
    view.engine()->rootContext()->setContextProperty("configuration", &configuration);

    view.setMouseGrabEnabled(true);


    app.exec();

    QGraphicsSceneMouseEvent pressEvent(QEvent::GraphicsSceneMousePress);
    pressEvent.setScenePos(QPointF(0, 0));
    pressEvent.setButton(Qt::LeftButton);
    pressEvent.setButtons(Qt::LeftButton);

    qDebug() << "--->" + QApplication::sendEvent(&view, &pressEvent);

    QMouseEvent * event1 = new QMouseEvent ((QEvent::MouseButtonPress), QPoint(0,0),
        Qt::LeftButton,
        Qt::LeftButton,
        Qt::NoModifier   );
    qDebug() << "--->" + QApplication::sendEvent(&view,event1);
    app.postEvent(&view,event1);
*/
}
void run1(QGuiApplication app)
{

}
