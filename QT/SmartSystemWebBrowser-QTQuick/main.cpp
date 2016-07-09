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
    Configuration configuration(&engine) ;
    PhotoHelper photoHelper(configuration.getPath()) ;
    engine.rootContext()->setContextProperty("photoHelper", &photoHelper);
    qDebug() << "photohelper set" ;
    engine.rootContext()->setContextProperty("configuration", &configuration);
    qDebug() << "configuration set" ;
    QQmlComponent component(&engine, QUrl(QStringLiteral("qrc:/main.qml")));
    qDebug() << "QML add" ;
    component.create();
    if(component.status() == QQmlComponent::Error)
    {
        qDebug() << component.errorString();
    }
    qDebug() << "component created" ;

    return app.exec();
}
