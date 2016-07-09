#ifndef CONFIGURATION_H
#define CONFIGURATION_H
#define PI
#include <QObject>
#include <QDebug>

class Configuration : public QObject
{
    QObject *screen ;
    Q_OBJECT
        Q_PROPERTY(QString url READ getUrl WRITE setUrl NOTIFY urlChanged)

signals:
    void urlChanged();
public:
    Configuration(QObject *screen);
    void generateClick();
    void setUrl(const QString &a) {
        // no need
    }
    QString getUrl()
    {
        #ifdef PI

        qDebug() << "In PI" ;
            return "http://127.0.0.1:8080/MySmartHome-New/room25.jsp";
            //return "http://www.google.com" ;
        #else

            qDebug() << "NOT In PI" ;
            return "http://www.google.com";
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
