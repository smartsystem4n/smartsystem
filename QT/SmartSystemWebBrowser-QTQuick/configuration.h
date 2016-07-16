#ifndef CONFIGURATION_H
#define CONFIGURATION_H
#define PI
#include <QObject>
#include <QDebug>
#include <QQuickView>
class Configuration : public QObject
{
    QQuickView *qQuickView ;
    Q_OBJECT
        Q_PROPERTY(QString url READ getUrl WRITE setUrl NOTIFY urlChanged)
        Q_PROPERTY(QString generateClickV READ generateClick WRITE setGenerateClick)

signals:
    void urlChanged();
public:
    Configuration();
    Configuration(QQuickView *quickView);
    QString generateClick();
    void setUrl(const QString &a) {
        // no need
    }
    void setGenerateClick(const QString &a) {
    }

    QString getUrl()
    {
        #ifdef PI

        qDebug() << "In PI" ;
            return "http://127.0.0.1:8080/MySmartHome-New/room25.jsp";
            //return "http://www.google.com" ;
        #else

            qDebug() << "NOT In PI" ;
            return "http://192.168.0.150:8080/MySmartHome-New/room25.jsp";
        #endif
    }

    QString getPath()
    {
        #ifdef PI
            return "/home/pi/qt-potoview-image-folder/";
        #else
            return "/home/nishit/qt-potoview-image-folder/";
        #endif
    }

};

#endif // CONFIGURATION_H
